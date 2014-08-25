package helper;

import java.util.ArrayList;

import org.json.simple.*;

/**
 * Section class
 */
public class Section
{
	ArrayList<Meeting> meetings = new ArrayList<Meeting>();

	String callNum;
	String availability;
	
	Course cour;
	
	public Section(String callNum, String availability, Course cour)
	{
		this.callNum = callNum;
		this.availability = availability;
		this.cour = cour;
		//cour.addSection(this);
	}
	
	public Section(Section sec)
	{
		this.callNum = sec.callNum;
		this.availability = sec.availability;
		//cour.addSection(this);
	}
	
	public Section(Section sec, Course cour)
	{
		this.callNum = sec.callNum;
		this.availability = sec.availability;
		this.cour = cour;	
		//cour.addSection(this);
	}
	
	public void addMeeting(Meeting meet)
	{
		meetings.add(meet);
	}
	
	public void removeMeeting(Meeting meet)
	{
		meetings.remove(meet);
	}
	
	public Course getCourse()
	{
		return this.cour;
	}

	public String getCallNum() 
	{
		return callNum;
	}
	
	public String getAvailability() 
	{
		return availability;
	}
	
	public void setAvailability(String a)
	{
		this.availability = a;
	}
	
	public ArrayList<Meeting> getMeetings() 
	{
		return this.meetings;
	}
	
	/**
	 * Convert this Section into a JSON string
	 *
	 */
	@SuppressWarnings("unchecked")
	public String toJSONString() {

		JSONObject json = new JSONObject();
		  
		json.put("prefix",cour.getPrefix());
		json.put("number",cour.getCourseNum());
		json.put("name",cour.getCourseTitle());
		json.put("creditHours",cour.getCreditHours());

		JSONArray list = new JSONArray();
		for(Meeting m : meetings)
			list.add(m.toJSONString());

		json.put("meetingsList", list);

		return json.toJSONString();
	}
}
