package helper;

import junit.framework.TestCase;

public class SectionTest extends TestCase 
{
	public void testSectionStringStringCourse() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		assertEquals("Call Number- pass", s.callNum, "Call Number");
		assertEquals("Availability- pass", s.availability, "Availability");
		assertEquals("Course- pass", s.cour, c);
	}

	public void testSectionSectionCourse() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Section s2 = new Section(s, c);
		assertEquals("Call Number- pass", s2.callNum, "Call Number");
		assertEquals("Availability- pass", s2.availability, "Availability");
		assertEquals("Course- pass", s2.cour, c);
	}

	public void testGetMeetings() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		Meeting m = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s, c);
		Meeting m2 = new Meeting("Instructor", "Day2", "0900A", "0630P", "Building", "Room", s, c);
		s.addMeeting(m);
		s.addMeeting(m2);
		assertEquals("Constructor- pass", s.getMeetings().size(), 2);
		assertEquals("Constructor- pass", s.getMeetings().get(0), m);
		assertEquals("Add Meeting- pass", s.getMeetings().get(1), m2);
	}

	public void testGetCallNum() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		assertEquals("Call Number- pass", s.getCallNum(), "Call Number");
	}

	public void testGetAvailability() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		assertEquals("Availability- pass", s.getAvailability(), "Availability");
	}

	public void testSetAvailability() 
	{
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		s.setAvailability("Unavailable");
		assertEquals("Availability- pass", s.availability, "Unavailable");
	}
}
