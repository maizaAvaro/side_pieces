/**
 * @fileOverview This file provides drawing functionality for the schedule view page. The view will
 * be presented as a grid, with days of the week on one axis and meeting times on the other. Classes
 * will be drawn as boxes, with each box corresponding to a specific day and time period. The boxes
 * of each class will use the same color
 *
 */

/** How many times per second the screen is updated. Since the canvas does not 
 * have moving elements, this value can be fairly low @constant */
var FRAME_RATE = 20;
/** An array of values corresponding to the borders around the grid. The values
 * are left, top, right, and bottom borders, respectively @constant */
var BORDERS = [50, 50, 20, 20]; 
/** Array of names of the days of the week @constant */
var DAYS=["Monday","Tuesday","Wednesday","Thursday","Friday"];
/** Array of abbreviations of the days of the week @constant */
var DAY_ABBREVS=["M","T","W","R","F"];
/** Array of strings of each hour of the school day @constant */
var TIMES=["8:00","9:00","10:00","11:00","12:00","1:00","2:00","3:00","4:00","5:00"];
/** Array of colors. Each course will be a different color */
var COLORS=["255,0,0","0,255,0","0,0,255","255,144,0","0,255,255","191,0,255","255,95,255","255,255,0"];

/** The canvas upon which to draw */
var canvas;
/** The canvas context, which should be 2d */
var ctx;
/** The width in pixels of each cell on the grid */
var cellWidth;
/** The height in pixels of each cell on the grid */
var cellHeight;

/**
 * Creates a course with a name, a set of meeting times, and a color to use for drawing
 * @class Represents a course (or to be more accurate, a section of a course). A course consists of multiple
 * meeting times, which may not overlap with another course's meeting times
 * @constructor
 * @param {string} name The name of this course
 * @param {string} color The color of this schedule (in hex)
 */
function Course(name, color) {
	this.name = name;
	this.color = color;
	this.meetings = new Array();
};

/**
 * Draw all meeting times on the schedule grid
 * @function 
 */
Course.prototype.draw = function() {
	for(var i=0; i<this.meetings.length; i++) 
		//call the draw method of a meeting
		this.meetings[i].draw();
};

/**
 * Add a meeting to the current course
 * @function
 */
Course.prototype.addMeeting = function(day, startTime, endTime) {
	this.meetings.push(new Meeting(day, startTime, endTime, this));
};

/**
 * Creates a meeting for a time period during a single day
 * @class A single meeting of a course. Each course can have multiple meetings.
 * @constructor
 * @param {int} day A number corresponding to the day of the week (0=mon)
 * @param {decimal} startTime The time this meeting starts
 * @param {decimal} endTime The time this meeting ends
 */
function Meeting(day, startTime, endTime, parentCourse){
	this.day = day;
	this.startTime = startTime;
	this.endTime = endTime;
	this.parentCourse = parentCourse;
	this.color = parentCourse.color;
};

/**
 * Draw the meeting on the schedule grid in the appropriate location
 * @function 
 */
Meeting.prototype.draw = function() {
	var x = BORDERS[0] + cellWidth * this.day;
	var y = BORDERS[1] + (this.startTime - 8) * cellHeight;
	var width = cellWidth;
	var height = cellHeight * (this.endTime - this.startTime);
	
	ctx.fillStyle = this.color;
	ctx.fillRect(x, y, width, height);
	
	ctx.font = '18px sans-serif';
	ctx.fillStyle = "#000";
	ctx.textAlign = 'center';
	ctx.textBaseline = 'middle';
	ctx.fillText(this.parentCourse.name, x + width / 2, y + height / 2);
};

/**
 * Determine whether the given point is inside this meeting's edges
 * @param pointX The x value of the point to check
 * @param pointY The y value of the point to check
 * @returns {Boolean} Whether or not the point is in the bounding box
 */
Meeting.prototype.isPointInBoundingBox = function(point) {
	var x = BORDERS[0] + cellWidth * this.day;
	var y = BORDERS[1] + (this.startTime - 8) * cellHeight;
	var width = cellWidth;
	var height = cellHeight * (this.endTime - this.startTime);
	
	return point.x > x && point.x < x + width &&
		   point.y > y && point.y < y + height;
};

/**
 * Convert a string representing a time to a float value
 * @param timeStr The string representing the time
 * @return The float value representing the given time
 */
function parseTimeString(timeStr) {
	var hour = parseFloat(timeStr.substring(0,2));
	var minute = parseFloat(timeStr.substring(2,4));
	hour += minute / 60.0;
	if(hour < 8.0 ) hour += 12;
	
	return hour;
}

/**
 * Convert a string representing a day of the week into a value (0-4)
 * @param dayStr The string representing the day of the week
 * @return An int corresponding to the day of the week
 */
function parseDayString(dayStr) {
	for(var i=0; i<DAYS.length; i++) {
		if(dayStr == DAYS[i] || dayStr == DAY_ABBREVS[i])
			return i;
	}
}

/**
 * Draw the grid of days and hours
 */
function drawGrid() {
	
	ctx.font = '18px sans-serif';
	ctx.fillStyle = "#000";
	
	//draw the outer border of the grid
	ctx.beginPath();
	ctx.rect(BORDERS[0], BORDERS[1], canvas.width - BORDERS[0] - BORDERS[2], canvas.height - BORDERS[1] - BORDERS[3]);
	ctx.closePath();
	ctx.stroke();

	//draw the vertical lines and the day names
	for(var i=0; i<DAYS.length; i++) {
		//draw a vertical line and write a string containing an day ("Monday", "Tuesday", etc)
		var x = BORDERS[0] + cellWidth * i;
		ctx.beginPath();
		ctx.moveTo(x, BORDERS[1]);
		ctx.lineTo(x, canvas.height - BORDERS[3]);
		ctx.closePath();
		ctx.stroke();
		
		//write the day string
		ctx.textAlign = 'center';
		ctx.textBaseline = 'bottom';
		ctx.fillText(DAYS[i], x + cellWidth / 2, BORDERS[0] - 5);
	};
	
	//draw the horizontal lines and the hour names
	for(var i=0; i<TIMES.length; i++) {
		//draw a line and write a string containing an hour ("8:00", "9:00", etc)
		var y = BORDERS[1] + cellHeight * i;
		ctx.beginPath();
		ctx.moveTo(BORDERS[0], y);
		ctx.lineTo(canvas.width - BORDERS[2], y);
		ctx.closePath();
		ctx.stroke();
		
		//write the hour string
		ctx.textAlign = 'right';
		ctx.textBaseline = 'middle';
		ctx.fillText(TIMES[i], BORDERS[1] - 5, y);
	};
	
};

/**
 * Get the position of the mouse relative to the upper left corner of the canvas
 * @param event The mouse event from which to get the coordinates
 */
function getRelativePosition(event) {
    var rectangle = canvas.getBoundingClientRect();
    return {
      x: event.clientX - rectangle.left,
      y: event.clientY - rectangle.top
    };
  }

/**
 * Handles mouse events involving a mouse-over of one of the courses
 * @param event The mouse event
 * @param course A list of courses against which to check the mouse position
 */
function mouseoverListener(event, courses) {
	var mousePosition = getRelativePosition(event);
	for(var i=0; i<courses.length; i++)
		for(var j=0; j<courses[i].meetings.length; j++)
			if(courses[i].meetings[j].isPointInBoundingBox(mousePosition))
				courses[i].meetings[j].color = courses[i].color.substr(0,13) + "1)";
			else
				courses[i].meetings[j].color = courses[i].color;
}

/**
 * Updates every frame, drawing objects to the canvas and performing any logic that needs updating
 * @param {array} courses An array of Course objects to be drawn 
 */
function update(courses) {
	ctx.clearRect( 0, 0, canvas.width, canvas.height );
	
	drawGrid();
	
	for(var i=0; i<courses.length; i++)
		//draw the course on the grid
		courses[i].draw();
};

/**
 * Initialize the canvas and the drawing context and get course information via the request attribute
 */
function init(scheduleObject){
	canvas = document.getElementById("scheduleCanvas");
	ctx = canvas.getContext("2d");	
	
	cellWidth = (canvas.width - BORDERS[0] - BORDERS[2]) / DAYS.length;
	cellHeight = (canvas.height - BORDERS[1] - BORDERS[3]) / (TIMES.length - 1);
	
	var courses = new Array();
	
	for(var i=0; i<scheduleObject.sections.length; i++) {
		var course = JSON.parse(scheduleObject.sections[i]);
		courses[i] = new Course(course.prefix + " " + course.number, "rgba(" + COLORS[i] + ",0.75)");
		for(var j=0; j<course.meetingsList.length; j++) {
			//add a meeting to the course
			var meeting = JSON.parse(course.meetingsList[j]);
			var start = parseTimeString(meeting.startTime);
			var end = parseTimeString(meeting.endTime);
			var daysArray = meeting.day.split(" ");
			for(var k=0; k<daysArray.length; k++) {
				var day = parseDayString(daysArray[k]);
				courses[i].addMeeting(day, start, end);
			}
		}
	}
	
	window.addEventListener('mousemove', function(event) { mouseoverListener(event, courses); }, true);
	
	intervalID = setInterval( function() { update(courses); }, 1000 / FRAME_RATE);
}
