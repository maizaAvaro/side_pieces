package helper;

/**
*
* Requirement class
*
**/

public class Requirement 
{
	
	private int requirementID;
	
	private String requirementName;

	public Requirement(int requirementID, String requirementName)
	{
		
		this.requirementID = requirementID;
		this.requirementName = requirementName;
		
	}
	
	public int getRequirementID()
	{
		
		return requirementID;
	
	}
	
	public String getRequirementName()
	{
		
		return requirementName;
		
	}

	public boolean equals(Object o) {
		Requirement r = (Requirement) o;
		return requirementID == r.getRequirementID();
	}
	
}
