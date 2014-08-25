package helper;

import java.util.ArrayList;
import org.json.simple.*;

/**
 * Course class
 */
public class Course
{
	ArrayList<Section> sections = new ArrayList<Section>();

	String prefix;
	String courseNum;
	String courseTitle;
	String session;
	int creditHours;
	
	public Course(String prefix, String courseNum, String courseTitle, int creditHours, String session)
	{
		this.prefix = prefix;
		this.courseNum = courseNum;
		this.courseTitle = courseTitle;
		this.session = session;
		this.creditHours = creditHours;
	}

	public Course(Course c)
	{
		this.prefix = c.prefix;
		this.courseNum = c.courseNum;
		this.courseTitle = c.courseTitle;
		this.session = c.session;
		this.creditHours = c.creditHours;
	}
	
	/**
	 * Adds the given section
	 */
	public void addSection(Section sec)
	{
		sections.add(sec);
	}
	
	/**
	 * Removes the section by its call number
	 */
	public void removeSection(String callNum)
	{
		for (int i = 0; i < sections.size(); i++)
		{
			if (callNum.equals(sections.get(i).getCallNum()))
				sections.remove(i);
		}
	}
	
	public Section getSection(String callNum)
	{
		for (int i = 0; i < sections.size(); i++)
		{
			String callNumberFun = sections.get(i).getCallNum();

			if (callNum.equals(callNumberFun))
				return sections.get(i);
		}
		return null;
	}
		
	public ArrayList<Section> getSections() 
	{
		return sections;
	}

	public String getPrefix() 
	{
		return prefix;
	}

	public String getCourseNum() 
	{
		return courseNum;
	}

	public String getCourseTitle() 
	{
		return courseTitle;
	}

	public String getSession() 
	{
		return session;
	}

	public int getCreditHours() 
	{
		return creditHours;
	}
	
	/**
	 * Get the call number of the mose recently added section 
	 * 
	 * 
	 */
	public String getCallNumber(){
		Section lastSec = sections.get(sections.size()-1);
		return lastSec.getCallNum();
	}
	
	public String toString() {
		String str = prefix + " " + courseNum + " (" + courseTitle + "):  ";
		for(Section s : sections)
			str += s.getCallNum() + ", ";

		return str;
	}
	
}
