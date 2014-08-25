package coursepicker;

public class Course 
{

	private String coursePrefix;
	private String courseNumber;
	private String courseTitle;
	private int creditHrs;
	private String session;
	
	
	private String callNumber;
	

	public Course(String coursePrefix, String courseNumber, String courseTitle, int creditHrs, String session) 
	{
	
		this.coursePrefix = coursePrefix;
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.creditHrs = creditHrs;
		this.session = session;
		
	}

	public void addSection(Section newSection) 
	{
		
		// TODO
		
	}

	public void addMeeting(Meeting meeting) 
	{
		
		// TODO
		
	}
	
	public String getCoursePrefix()
	{
		
		return coursePrefix;
		
	}
	
	public String getCourseNumber()
	{
		
		return courseNumber;
		
	}
	
	public String getCourseTitle()
	{
		
		return courseTitle;
		
	}
	
	public int getCreditHrs()
	{
		
		return creditHrs;
		
	}
	
	public String getSession()
	{
		
		return session;
		
	}

	public String getCallNumber()	// TODO - Call number should be part of a Section, not Course
	{
		
		return callNumber;
		
	}
	
}
