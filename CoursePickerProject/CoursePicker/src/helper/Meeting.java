package helper;

import org.json.simple.*;

/**
 * Meeting class
 */
public class Meeting
{
	String instructor;
	String day;
	String beginTime;
	String endingTime;
	String building;
	String room;
	
	Section sec;

	int begTime;
	int endTime;
	
	public Meeting(String instructor, String day, String beginTime, String endingTime, String building, String room, Section sec)
	{
		this.instructor = instructor;
		this.day = day;
		this.beginTime = beginTime;
		this.endingTime = endingTime;
		this.building = building;
		this.room = room;
		this.sec = sec;
		
		try {	
		//Stores the beginning time as an int
		if (beginTime.charAt(4) == 'A')
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
		else if (beginTime.charAt(4) == 'P' && beginTime.charAt(0) =='1' && beginTime.charAt(1) == '2')
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
		else
		{
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
			this.begTime += 1200;
		}
		} catch (Exception e) {
			this.begTime = 0000;
		}
	
		try {	
		//Stores the ending time as an int
		if (endingTime.charAt(4) == 'A')
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
		else if (endingTime.charAt(4) == 'P' && endingTime.charAt(0) =='1' && endingTime.charAt(1) == '2')
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
		else
		{
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
			this.endTime += 1200;
		}
		} catch (Exception e) {
			this.endTime = 0001;
		}
		
		//sec.addMeeting(this);
	}	
	public Meeting(String instructor, String day, String beginTime, String endingTime, String building, String room, Section sec, Course c)
	{
		this.instructor = instructor;
		this.day = day;
		this.beginTime = beginTime;
		this.endingTime = endingTime;
		this.building = building;
		this.room = room;
		this.sec = sec;
			
		//Stores the beginning time as an int
		if (beginTime.charAt(4) == 'A')
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
		else if (beginTime.charAt(4) == 'P' && beginTime.charAt(0) =='1' && beginTime.charAt(1) == '2')
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
		else
		{
			this.begTime = Integer.parseInt(beginTime.substring(0,4));
			this.begTime += 1200;
		}
		
		//Stores the ending time as an int
		if (endingTime.charAt(4) == 'A')
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
		else if (endingTime.charAt(4) == 'P' && endingTime.charAt(0) =='1' && endingTime.charAt(1) == '2')
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
		else
		{
			this.endTime = Integer.parseInt(endingTime.substring(0,4));
			this.endTime += 1200;
		}
		
		//sec.addMeeting(this);
	}	
		
		
	public String getInstructor() 
	{
		return instructor;
	}

	public String getBuilding() 
	{
		return building;
	}

	public String getRoom() 
	{
		return room;
	}

	public String getBeginTime()
	{
		return this.beginTime;
	}

	public String getEndingTime()
	{
		return this.endingTime;
	}

	public String getDay()
	{
		return this.day;
	}
	
	public int getBegTime() 
	{
		return begTime;
	}

	public int getEndTime() 
	{
		return endTime;
	}
	
	public Section getSection()
	{
		return this.sec;
	}
	
	/**
	 * Convert this Meeting into a JSON string
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String toJSONString() {

		JSONObject json = new JSONObject();

		json.put("day", day);
		json.put("startTime", beginTime);
		json.put("endTime", endingTime);
		json.put("building", building);
		json.put("roomNumber", room);
		json.put("instructor", instructor);

		return json.toJSONString();
	}
}
