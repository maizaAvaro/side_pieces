package coursepicker;

public class Section 
{
	
	private String callNumber;
	private String availability;
	private Course prevCourse;

	public Section(String callNumber, String availability, Course prevCourse) 
	{
		
		this.callNumber = callNumber;
		this.availability = availability;
		this.prevCourse = prevCourse;
		
	}
	
	public String getCallNumber()
	{
		
		return callNumber;
		
	}
	
	public String getAvailability()
	{
		
		return availability;
		
	}

	public Course getPrevCourse()
	{
		
		return prevCourse;
		
	}
	
}
