package helper;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * Class that tests the class PickerDAO
 * 
 * @author Nathan Ray
 *
 */
public class PickerDAOTest extends TestCase 
{

	/**
	 * Tests that a PickerDAO object is created properly
	 */
	public void testConstructor() 
	{
		
		PickerDAO dao = new PickerDAO();
		assertNotNull("PickerDAO is created properly", dao);
		
	}	// End of testConstructor method
	
	public void testMethods()
	{
		
		PickerDAO dao = new PickerDAO();
		
		ArrayList<Course> courseList = dao.getCourseList(19);
		ArrayList<Requirement> requirementNames = dao.getRequirementList();
		
		assertTrue("course list is populated", !courseList.isEmpty());
		assertTrue("requirement list is populated", !requirementNames.isEmpty());
		
	}	// End of testMethods method

}	// End of PickerDAOTest class
