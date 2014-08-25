package helper;

import junit.framework.TestCase;

public class CourseTest extends TestCase 
{
	public void testCourseStringStringStringStringInt() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Prefix- pass", c.prefix, "Prefix");
		assertEquals("Course Number- pass", c.courseNum, "Course Number");
		assertEquals("Course Title- pass", c.courseTitle, "Course Title");
		assertEquals("Session- pass", c.session, "Session");
		assertEquals("Credit Hours- pass", c.creditHours, 5);
	}

	public void testCourseCourse() 
	{
		Course d = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Course c = new Course(d);
		assertEquals("Prefix- pass", c.prefix, "Prefix");
		assertEquals("Course Number- pass", c.courseNum, "Course Number");
		assertEquals("Course Title- pass", c.courseTitle, "Course Title");
		assertEquals("Session- pass", c.session, "Session");
		assertEquals("Credit Hours- pass", c.creditHours, 5);
	}

	public void testGetSections() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Section s2 = new Section("Call Number2", "Availability", c);
		c.addSection(s);
		c.addSection(s2);
		assertEquals("Get Sections- pass", c.getSections().size(), 2);
		assertEquals("Get Sections- pass", c.getSections().get(0), s);
		assertEquals("Get Sections- pass", c.getSections().get(1), s2);
	}

	public void testGetPrefix() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Prefix- pass", c.getPrefix(), "Prefix");
	}

	public void testGetCourseNum() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Course Number- pass", c.getCourseNum(), "Course Number");
	}

	public void testGetCourseTitle() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Course Title- pass", c.getCourseTitle(), "Course Title");
	}

	public void testGetSession() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Session- pass", c.getSession(), "Session");
	}

	public void testGetCreditHours() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		assertEquals("Credit Hours- pass", c.getCreditHours(), 5);
	}
}
