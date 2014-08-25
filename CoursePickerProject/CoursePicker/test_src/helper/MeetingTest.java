package helper;

import junit.framework.TestCase;

public class MeetingTest extends TestCase 
{
	public void testMeeting() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Instructor- pass", m.instructor, "Instructor");
		assertEquals("Day- pass", m.day, "Day");
		assertEquals("Begin Time- pass", m.beginTime, "0900A");
		assertEquals("Ending Time- pass", m.endingTime, "0630P");
		assertEquals("Building- pass", m.building, "Building");
		assertEquals("Room- pass", m.room, "Room");
		assertEquals("Section- pass", m.sec, s);
	}

	public void testGetInstructor() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Instructor- pass", m.getInstructor(), "Instructor");
	}

	public void testGetBuilding() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Building- pass", m.getBuilding(), "Building");
	}

	public void testGetRoom() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Room- pass", m.getRoom(), "Room");
	}

	public void testGetBeginTime() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Begin Time- pass", m.getBeginTime(), "0900A");
	}

	public void testGetEndingTime() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Ending Time- pass", m.getEndingTime(), "0630P");
	}

	public void testGetDay() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Day", m.getDay(), "Day");
	}

	public void testGetBegTime() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		assertEquals("Beg Time- pass", m.getBegTime(), 900);
		
		Course c2 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s2 = new Section("Call Number", "Availability", c2);
		Meeting m2 = new Meeting("Instructor", "Day", "1100A", "0630P", "Building", "Room", s2, c2);
		assertEquals("Beg Time- pass", m2.getBegTime(), 1100);
		
		Course c3 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s3 = new Section("Call Number", "Availability", c3);
		Meeting m3 = new Meeting("Instructor", "Day", "1200P", "0630P", "Building", "Room", s3, c3);
		assertEquals("Beg Time- pass", m3.getBegTime(), 1200);
		
		Course c4 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s4 = new Section("Call Number", "Availability", c4);
		Meeting m4 = new Meeting("Instructor", "Day", "0100P", "0630P", "Building", "Room", s4, c4);
		assertEquals("Beg Time- pass", m4.getBegTime(), 1300);
		
		Course c5 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s5 = new Section("Call Number", "Availability", c5);
		Meeting m5 = new Meeting("Instructor", "Day", "0400P", "0630P", "Building", "Room", s5, c5);
		assertEquals("Beg Time- pass", m5.getBegTime(), 1600);
	}

	public void testGetEndTime() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0900A", "Building", "Room", s, c);
		assertEquals("End Time- pass", m.getEndTime(), 900);
		
		Course c2 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s2 = new Section("Call Number", "Availability", c2);
		Meeting m2 = new Meeting("Instructor", "Day", "0900A", "1100A", "Building", "Room", s2, c2);
		assertEquals("End Time- pass", m2.getEndTime(), 1100);
		
		Course c3 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s3 = new Section("Call Number", "Availability", c3);
		Meeting m3 = new Meeting("Instructor", "Day", "0900A", "1200P", "Building", "Room", s3, c3);
		assertEquals("End Time- pass", m3.getEndTime(), 1200);
		
		Course c4 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s4 = new Section("Call Number", "Availability", c4);
		Meeting m4 = new Meeting("Instructor", "Day", "0900A", "0100P", "Building", "Room", s4, c4);
		assertEquals("End Time- pass", m4.getEndTime(), 1300);
		
		Course c5 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s5 = new Section("Call Number", "Availability", c5);
		Meeting m5 = new Meeting("Instructor", "Day", "0900A", "0400P", "Building", "Room", s5, c5);
		assertEquals("End Time- pass", m5.getEndTime(), 1600);
	}
}
