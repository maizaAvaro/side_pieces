package csci4300;

import java.util.ArrayList;


public class Student 
{

	/**
	 * Represents the name of the student
	 */
	private String studentName;
	
	/**
	 * Represents the "about me" description of the student
	 */
	private String description;
	
	/**
	 * Represents the image URL of the student
	 */
	private String imageURL; // Web URL
	
	/**
	 * Represents the collection of student activities
	 */
	private ArrayList<String> studentActivities = new ArrayList<String>();
	
	/**
	 * Represents the string representation of the list of student activities
	 */
	private String activityStatement;
	
	
	/**
	 * Represents the no-argument constructor that must be used for a Bean class
	 */
	public Student()
	{
		
		// Used to satisfy Bean requirements only
		
	}	// End of no-argument Student constructor
	
	
	/**
	 * Initializes a Student object with the parameters listed below
	 * @param studentName - the name of the student
	 * @param description - a short biopic of the student
	 * @param imageURL - the web URL of an image of the student
	 */
	public Student(String studentName, String description, String imageURL)
	{
		
		this.studentName = studentName;
		this.description = description;
		this.imageURL = imageURL;
		studentActivities = new ArrayList<String>();
		activityStatement = "";
		
	}	// End of Student constructor
	
	
	/**
	 * Gets the student name of the Student object
	 * @return - 'studentName' field
	 */
	public String getStudentName() 
	{
		
		return studentName;
	
	}	// End of getStudentName method


	/**
	 * Sets the student name of the Student object
	 * @param studentName - the name of the student
	 */
	public void setStudentName(String studentName) 
	{
	
		this.studentName = studentName;
	
	}	// End of setStudentName method


	/**
	 * Gets the bio description of a Student object
	 * @return - 'description' field
	 */
	public String getDescription() 
	{
	
		return description;
	
	}	// End of getDescription method


	/**
	 * Sets the bio description of a Student object
	 * @param description - a short biopic of the student
	 */
	public void setDescription(String description) 
	{
	
		this.description = description;
	
	}	// End of setDescription method


	/**
	 * Gets the image URL of the Student object
	 * @return - 'imageURL' field
	 */
	public String getImageURL() 
	{
	
		return imageURL;
	
	}	// End of getImageURL method


	/**
	 * Sets the image URL of the Student object
	 * @param imageURL
	 */
	public void setImageURL(String imageURL) 
	{
	
		this.imageURL = imageURL;
	
	}	// End of setImageURL method


	/**
	 * Gets the ArrayList object of student activity Strings
	 * @return - 'studentActivities' field
	 */
	public ArrayList<String> getActivityList() 
	{
	
		return studentActivities;
	
	}	// End of getStudentActivities method


	/**
	 * Sets the ArrayList object of student activity Strings
	 * @param studentActivities - the list of Strings of student activities
	 */
	public void setNewActivity(String newActivity) 
	{
	
		studentActivities.add(newActivity);
	
	}	// End of setStudentActivites method
	
	
	/**
	 * Sets the activity statement given via the list of student activities
	 * @param activityStatement - the string representation of the list of activities
	 */
	public void setActivityStatement(String activityStatement)
	{
		
		this.activityStatement = activityStatement;
		
	}	// End of method setActivityStatement
	
	
	/**
	 * Gets the activity statement of the Student object
	 * @return - 'activityStatement' field
	 */
	public String getActivityStatement()
	{
		
		activityStatement = "";
		
		if(studentActivities.isEmpty())
		{
			
			activityStatement = "I am a complete nerd without any activities.";
			
			return activityStatement;
			
		}	// End of if statement
		
		if(studentActivities.size() == 1)
		{
			
			activityStatement = "My favorite activity is " + studentActivities.get(0) + ".";
			
			return activityStatement;
			
		}	// End of if statement
		
		if(studentActivities.size() == 2)
		{
			
			activityStatement = "My favorite activities are " + studentActivities.get(0) + " and " + studentActivities.get(1) + ".";
			
			return activityStatement;
			
		}	// End of if statement
		
		String pluralActivitiesLeadingStatement = "My favorite activities are ";
		
		//	On one iteration of this loop the field 'activityStatement' will be appended
		//	with the string that is contained in index 'i' of the ArrayList studentActivities
		for(int i = 0; i < (studentActivities.size() - 1); i++)
		{
			
			activityStatement = activityStatement + studentActivities.get(i) + ", ";
			
		}	// End of for loop
		
		// Appending the last activity in the list with "and" in addition to adding a period
		activityStatement = activityStatement + "and " + studentActivities.get(studentActivities.size() - 1) + ".";
		
		// Prefacing activityStatement with the appropriate leading statement
		return pluralActivitiesLeadingStatement + activityStatement; 
		
	}	// End of getActivityStatement method
	
}	// End of class Student
