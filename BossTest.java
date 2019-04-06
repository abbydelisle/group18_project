

import static org.junit.Assert.*;

import org.junit.Test;

public class BossTest {

	@Test
	public void test_getX_Coordinate() {
		Boss s = new Boss(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate()); 
	}
	@Test
	public void test_getY_Coordinate() {
		Boss s = new Boss(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	
	@Test
	public void test_delete() {
		Boss s = new Boss(300, 300);
		s.delete();
		assertEquals("x coordinate is set to -1000", -1000, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -1000, s.getY_coordinate());
	}
	
	@Test
	public void test_moveRandom() {
		Boss s = new Boss(300, 300);
		s.moveRan();
		assertTrue("Check if Boss is within the boundary of the scene", s.getX_coordinate() < 600);
		assertFalse("Check if Boss is within the boundary of the scene", s.getX_coordinate() > 500);
		assertTrue("Check if Boss is within the boundary of the scene", s.getY_coordinate() > 0);
		assertFalse("Check if Boss is within the boundary of the scene", s.getY_coordinate() < 0);
	}
	@Test
	public void test_BossShoot() {
		Boss s = new Boss(300, 300);
	}
}