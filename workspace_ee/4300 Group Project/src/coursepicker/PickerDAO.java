package coursepicker;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class that handles database access for the Course Picker project
 * 
 * @author Nathan Ray
 * All database tables for this project were created and populated by Nathan Ray
 * as well
 */
public class PickerDAO 
{
	
	/**
	 * Represents the statement used to list the courses in the CourseListing table
	 */
	private PreparedStatement listCoursesStatement;
	
	/**
	 * Represents the statement used to remove a course from the CourseListing table
	 */
	private PreparedStatement removeCoursesStatement;
	
	/**
	 * Represents the statement used to list the requirements in the Requirements table for a course
	 */
	private PreparedStatement listRequirementsStatement;
	
	/**
	 * Represents the statement used to get the requirement name, given an id
	 */
	private PreparedStatement getRequirementName;
	
	/**
	 * Represents the URL used to connect to the appropriate database
	 */
	private static String JDBC_URL = "jdbc:mysql://localhost/cs4300";
	
	
	/**
	 * The constructor method that will connect to the database and initialize the 
	 * PreparedStatements
	 */
	public PickerDAO()
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "Taoisone1?");
			
			removeCoursesStatement = conn.prepareStatement("truncate CourseListing");
			listCoursesStatement = conn.prepareStatement("select * from CourseListing join Requirements on(Requirements.requirementID = ? and CourseListing.coursePrefix = Requirements.coursePrefix and CourseListing.courseNumber = Requirements.courseNumber)");
			listRequirementsStatement = conn.prepareStatement("select requirementID, requirementName from RequirementMap");
			getRequirementName = conn.prepareStatement("select requirementName from RequirementMap where requirementID = ?");
			
		}catch (Exception error) 
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
		
	}	// End of PickerDAO constructor
	
	/**
	 * Gets the list of courses in the CourseListing table that correspond to the requirementID
	 * 
	 * @return ArrayList<Course>
	 */
	public ArrayList<Course> getCourseList(int requirementID)
	{
		
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		Course prevCourse = null;
		Section newSection = null;
		
		ResultSet rs;
		
		try
		{
			listCoursesStatement.setInt(1, requirementID);
			rs = listCoursesStatement.executeQuery();
			
			while(rs.next())
			{	
				
				// On one iteration of this loop a course is either added, a section is added, 
				// or a meeting is added to the course list depending on which conditions are
				// satisfied by the entry that is being viewed in comparison to the previous
				// entry viewed
				
				
				
				if(prevCourse == null)
				{
					
					String callNumber = rs.getString("callNumber");
					String coursePrefix = rs.getString("coursePrefix");
					String courseNumber = rs.getString("courseNumber");
					String courseTitle = rs.getString("courseTitle");
					String instructorName = rs.getString("instructorName");
					String availability = rs.getString("availability");
					int creditHrs = rs.getInt("creditHrs");
					String session = rs.getString("session");
					String days = rs.getString("days");
					String periodBegin = rs.getString("periodBegin");
					String periodEnd = rs.getString("periodEnd");
					String building = rs.getString("building");
					String room = rs.getString("room");
					
					prevCourse = new Course(coursePrefix, courseNumber, courseTitle, creditHrs, session);
					newSection = new Section(callNumber, availability, prevCourse);
					prevCourse.addSection(newSection);
					prevCourse.addMeeting(new Meeting(instructorName, days, periodBegin, periodEnd, building, room, newSection));
					courseList.add(prevCourse);

				}else if(prevCourse != null)
				{
					
					String callNumber = rs.getString("callNumber");
					String coursePrefix = rs.getString("coursePrefix");
					String courseNumber = rs.getString("courseNumber");
					String courseTitle = rs.getString("courseTitle");
					String instructorName = rs.getString("instructorName");
					String availability = rs.getString("availability");
					int creditHrs = rs.getInt("creditHrs");
					String session = rs.getString("session");
					String days = rs.getString("days");
					String periodBegin = rs.getString("periodBegin");
					String periodEnd = rs.getString("periodEnd");
					String building = rs.getString("building");
					String room = rs.getString("room");
					
					if(prevCourse.getCourseTitle().equals(courseTitle) && !(prevCourse.getCallNumber().equals(callNumber)))
					{
						
						newSection = new Section(callNumber, availability, prevCourse);
						prevCourse.addSection(newSection);
						
					}else if(prevCourse.getCallNumber().equals(callNumber)) // TODO - call number is for section not course...
					{
						
						prevCourse.addMeeting(new Meeting(instructorName, days, periodBegin, periodEnd, building, room, newSection));
						
					}else
					{
					
						prevCourse = new Course(coursePrefix, courseNumber, courseTitle, creditHrs, session);
						newSection = new Section(callNumber, availability, prevCourse);
						prevCourse.addSection(newSection);
						prevCourse.addMeeting(new Meeting(instructorName, days, periodBegin, periodEnd, building, room, newSection));
						courseList.add(prevCourse);
						
					}
					
				}
				
			}
			
		}
		catch(SQLException error)
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
			
		}
		
		return courseList;
		
	}	// End of getCourseList method
	
	/**
	 * Removes the course from the CourseListing table that corresponds to the call number
	 * being searched
	 * 
	 * @param removeID - String - the call number of a course to be removed
	 */
	public void removeCourses()
	{
		
		try 
		{
		
			removeCoursesStatement.executeQuery();
		
		} 
		catch (SQLException error) 
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
			
		}
		
	}	// End of method removeCourse
	
	/**
	 * Gets the list of requirements (corresponding to courses) from the Requirements
	 * table in the database
	 * 
	 * @return ArrayList<Requirement>
	 */
	public ArrayList<Requirement> getRequirementList()
	{
		
		ArrayList<Requirement> requirements = new ArrayList<Requirement>();
		ResultSet rs;
		
		try 
		{
		
			rs = listRequirementsStatement.executeQuery();
			
			while(rs.next())
			{	
				
				// On one iteration of this loop a requirement name is obtained from the current 
				// requirement being viewed from the RequirementMap table and this requrirement
				// name is added to the requirementNames list
				
				int requirementID = rs.getInt("requirementID");
				String requirementName = rs.getString("requirementName");
				
				Requirement newRequirement = new Requirement(requirementID, requirementName);
				
				requirements.add(newRequirement);
				
			}
		
		} 
		catch (SQLException error) 
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		
		}
		
		return requirements;
		
	}	// End of getRequirementList method
	
	
	/**
	 * Gets the requirement name, given the requirement id from the database table RequirementMap
	 * 
	 * @param requirementID - the id associated with the requirement name in the database
	 * @return String
	 */
	public String getRequirement(int requirementID)
	{
		
		String requirementName = "";
		ResultSet rs;
		
		try 
		{
		
			getRequirementName.setInt(1, requirementID);
			rs = getRequirementName.executeQuery();
			
			rs.next();
			
			requirementName = rs.getString("requirementName");
		
		} 
		catch (SQLException error) 
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		
		}
		
		return requirementName;
		
	}
	
}	// End of PickerDAO class
