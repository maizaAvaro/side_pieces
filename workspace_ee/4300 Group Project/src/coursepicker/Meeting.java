package coursepicker;

public class Meeting 
{

	private String instructorName;
	private String days;
	private String periodBegin;
	private String periodEnd;
	private String building;
	private String room;
	private Section newSection;
	
	public Meeting(String instructorName, String days, String periodBegin, String periodEnd, String building, String room, Section newSection) 
	{
	
		this.instructorName = instructorName;
		this.days = days;
		this.periodBegin = periodBegin;
		this.periodEnd = periodEnd;
		this.building = building;
		this.room = room;
		this.newSection = newSection;
		
	}

	public String getInstructorName() 
	{
		
		return instructorName;
	
	}

	public String getDays() 
	{
	
		return days;
	
	}

	public String getPeriodBegin() 
	{
	
		return periodBegin;
	
	}

	public String getPeriodEnd() 
	{
	
		return periodEnd;
	
	}

	public String getBuilding() 
	{
	
		return building;
	
	}

	public String getRoom() 
	{
	
		return room;
	
	}

	public Section getNewSection() 
	{
	
		return newSection;
	
	}

}
