package helper;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Schedule class
 */
public class Schedule 
{
	ArrayList<Section> sections = new ArrayList<Section>();
	
	public int addSection(Section sec)
	{
		if (isTimeConflict(sec))
			return 1;
		else if (isScheduleConflict(sec))
			return 2;
		else
		{
			sections.add(sec);
			return 0;
		}
	}
	
	public void removeSection(String callNum)
	{
		for (int i = 0; i < sections.size(); i++)
		{
			if (callNum.equals(sections.get(i).getCallNum()))
				sections.remove(i);
		}
	}
	
	/**
	 * Checks if a given section's meetings conflict with all other sections' meetings
	 */
	public boolean isTimeConflict(Section sec)
	{
		for (int i = 0; i < sec.getMeetings().size(); i++)
		{
			for (int j = 0; j < sections.size(); j++)
			{
				for (int k = 0; k < sections.get(j).getMeetings().size(); k++)
				{
					//same day
					if (sec.getMeetings().get(i).getDay().equals(sections.get(j).getMeetings().get(k).getDay()))
					{
						//a begins before b begins, a ends after b begins
						if (sec.getMeetings().get(i).getBegTime() <= sections.get(j).getMeetings().get(k).getBegTime() 
									&& sec.getMeetings().get(i).getEndTime() >= sections.get(j).getMeetings().get(k).getBegTime())
							return true;

						//b begins before a begins, b ends after a begins
						else if (sec.getMeetings().get(i).getBegTime() >= sections.get(j).getMeetings().get(k).getBegTime() 
									&& sec.getMeetings().get(i).getBegTime() <= sections.get(j).getMeetings().get(k).getEndTime())
							return true;
						
						//a begins before b ends, a ends after b ends
						else if (sec.getMeetings().get(i).getBegTime() <= sections.get(j).getMeetings().get(k).getEndTime() 
									&& sec.getMeetings().get(i).getEndTime() >= sections.get(j).getMeetings().get(k).getEndTime())
							return true;

						//b begins before a ends, b ends after a ends
						else if (sec.getMeetings().get(i).getEndTime() >= sections.get(j).getMeetings().get(k).getBegTime() 
									&& sec.getMeetings().get(i).getEndTime() <= sections.get(j).getMeetings().get(k).getEndTime())
							return true;
					} // if
				} // for k
			} // for j
		} // for i
		return false;
	}
	
	public boolean isScheduleConflict(Section sec)
	{
		for (int i = 0; i < sections.size(); i++)
		{
			//same prefix and course number (duplicate course)
			if (sec.getCourse().getPrefix().equals(sections.get(i).getCourse().getPrefix()) 
					&& sec.getCourse().getCourseNum().equals(sections.get(i).getCourse().getCourseNum()))
				return true;
		}
		return false;
	}
	
	public String toJSONString() {

		JSONObject json = new JSONObject();

		JSONArray list = new JSONArray();
		for(Section s : sections)
			list.add(s.toJSONString());

		try {
			json.put("sections", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json.toString();
	}
	
	public String toString()
	{
		String s = "";
		for (int i = 0; i < sections.size(); i++)
		{
			for (int j = 0; j < sections.get(i).meetings.size(); j++)
			{
				s+=sections.get(i).getCourse().getPrefix() + " ";
				s+=sections.get(i).getCourse().getCourseNum() + " ";
				s+= sections.get(i).getCallNum() + " ";	
				s+=sections.get(i).meetings.get(j).getBeginTime() + "-";
				s+=sections.get(i).meetings.get(j).getEndingTime() + " ";
				s+= sections.get(i).meetings.get(j).getDay();
				s+="\n";
			}
		}
		return s;
	}
}

