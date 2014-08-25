package fifteenpuzzle;

import junit.framework.TestCase;

/**
 * Verify that a Position object returns the data with
 * which it was created
 * @author drdan
 *
 */
public class PositionTest extends TestCase 
{

	/**
	 * Verify that a newly constructed Position object contains the
	 * data provided in its constructor
	 */
	public void testConstructor(){
		Position instance1 = new Position(0,0);
		assertEquals("instance1 X",0, instance1.getX());
		assertEquals("instance1 Y",0, instance1.getY());
		
		Position instance2 = new Position(3,0);
		assertEquals("instance2 X",3, instance2.getX());
		assertEquals("instance2 Y",0, instance2.getY());
		
		Position instance3 = new Position(0,3);
		assertEquals("instance3 X",0, instance3.getX());
		assertEquals("instance3 Y",3, instance3.getY());
		
		Position instance4 = new Position(1,3);
		assertEquals("instance4 X",1, instance4.getX());
		assertEquals("instance4 Y",3, instance4.getY());
	}

	
}	// End of PositionTest class
