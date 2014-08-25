package helper;

import junit.framework.TestCase;

@SuppressWarnings("unused")
public class ScheduleTest extends TestCase 
{
	public void testAddSection() 
	{
		Schedule sch = new Schedule();
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		sch.addSection(s);
		assertEquals("Add Section- pass", sch.sections.get(0), s);
	}

	public void testRemoveSection() 
	{
		Schedule sch = new Schedule();
		Course c = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s = new Section("Call Number", "Availability", c);
		sch.addSection(s);
		assertEquals("Constructor- pass", sch.sections.get(0), s);
		assertEquals("Constructor- pass", sch.sections.size(), 1);
		sch.removeSection(s.callNum);
		assertEquals("Remove Section- pass", sch.sections.size(), 0);
	}

	/**public void testIsTimeConflict() 
	{
		Schedule sch = new Schedule();
		Course c1 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s1 = new Section("Call Number", "Availability", c1);
		Meeting m1 = new Meeting("Instructor", "Day", "0900A", "1000A", "Building", "Room", s1, c1);
		sch.addSection(s1);
		
		Course c3 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s3 = new Section("Call Number", "Availability", c3);
		Meeting m3 = new Meeting("Instructor", "Day", "0845A", "0915A", "Building", "Room", s3, c3);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s3), true);
		//m3 begins before m1 begins, m3 ends after m1 begins
	
		Course c4 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s4 = new Section("Call Number", "Availability", c4);
		Meeting m4 = new Meeting("Instructor", "Day", "0930A", "0935A", "Building", "Room", s4, c4);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s4), true);
		//m1 begins before m4 begins, m1 ends after m4 begins
		
		Course c5 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s5 = new Section("Call Number", "Availability", c5);
		Meeting m5 = new Meeting("Instructor", "Day", "0945A", "1015A", "Building", "Room", s5, c5);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s5), true);
		//m5 begins before m1 ends, m5 ends after m1 ends
		
		Course c6 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s6 = new Section("Call Number", "Availability", c6);
		Meeting m6 = new Meeting("Instructor", "Day", "0845A", "1015A", "Building", "Room", s6, c6);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s6), true);
		//m6 begins before m1 begins, m6 ends after m1 begins
		
		Course c7 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s7 = new Section("Call Number", "Availability", c7);
		Meeting m7 = new Meeting("Instructor", "Day", "0900A", "1000A", "Building", "Room", s7, c7);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s7), true);
		//same times
		
		Course c8 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s8 = new Section("Call Number", "Availability", c8);
		Meeting m8 = new Meeting("Instructor", "Day", "0900A", "1045A", "Building", "Room", s8, c8);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s8), true);
		//same times
		
		Course c9 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s9 = new Section("Call Number", "Availability", c9);
		Meeting m9 = new Meeting("Instructor", "Day", "0845A", "0900A", "Building", "Room", s9, c9);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s9), true);
		//same times
		
		Course c10 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s10 = new Section("Call Number", "Availability", c10);
		Meeting m10 = new Meeting("Instructor", "Day", "1100A", "1130A", "Building", "Room", s10, c10);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s10), false);
		//no time conflict
		
		Course c11 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s11 = new Section("Call Number", "Availability", c11);
		Meeting m11 = new Meeting("Instructor", "Day2", "0900A", "1000A", "Building", "Room", s11, c11);
		assertEquals("Time Conflict- pass", sch.isTimeConflict(s11), false);
		//different days
	} **/

	public void testIsScheduleConflict() 
	{
		Schedule sch = new Schedule();
		Course c1 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s1 = new Section("Call Number", "Availability", c1);
		Meeting m1 = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s1, c1);
		sch.addSection(s1);
		
		Course c2 = new Course("Prefix", "Course Number", "Course Title", 5, "Session");
		Section s2 = new Section("Call Number", "Availability", c2);
		Meeting m2 = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s2, c2);
		assertEquals("Schedule Conflict- pass", sch.isScheduleConflict(s2), true);
		//same prefix and course number
		
		Course c3 = new Course("Prefix3", "Course Number", "Course Title", 5, "Session");
		Section s3 = new Section("Call Number", "Availability", c3);
		Meeting m3 = new Meeting("Instructor", "Day", "0900A", "0630PA", "Building", "Room", s3, c3);
		assertEquals("Schedule Conflict- pass", sch.isScheduleConflict(s3), false);
		//different prefix
		
		Course c4 = new Course("Prefix", "Course Number4", "Course Title", 5, "Session");
		Section s4 = new Section("Call Number", "Availability", c4);
		Meeting m4 = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s4, c4);
		assertEquals("Schedule Conflict- pass", sch.isScheduleConflict(s4), false);
		//different course number
		
		Course c5 = new Course("Prefix5", "Course Number5", "Course Title", 5, "Session");
		Section s5 = new Section("Call Number", "Availability", c5);
		Meeting m5 = new Meeting("Instructor", "Day", "0900A", "0630P", "Building", "Room", s5, c5);
		assertEquals("Schedule Conflict- pass", sch.isScheduleConflict(s5), false);
		//different prefix and course number
	}
}
