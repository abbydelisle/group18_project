import static org.junit.Assert.*;

import org.junit.Test;

public class BulletTest {
	
	@Test
	public void test_getX_Coordinate() {
		Bullet s = new Bullet(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_getY_Coordinate() {
		Bullet s = new Bullet(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	@Test
	public void test_getMovement() {
		Bullet s = new Bullet(300, 300); 
		s.setMovement(50);
		assertEquals("set amount of pixels moved per move is 50 unit", 50, s.getMovement());
	}
	@Test
	public void test_moveLeft() {
		Bullet s = new Bullet(300, 300);
		s.moveLeft();
		assertEquals("x move 1 unit to the left", 299, s.getX_coordinate());
	}
	@Test
	public void test_moveRight() {
		Bullet s = new Bullet(300, 300);
		s.moveRight();
		assertEquals("x move 1 unit to the right", 301, s.getX_coordinate());
	}
	@Test
	public void test_moveUp() {
		Bullet s = new Bullet(300, 300);
		s.moveUp();
		assertEquals("x move 1 unit to the up", 299, s.getY_coordinate());
	}
	@Test
	public void test_moveDown() {
		Bullet s = new Bullet(300, 300);
		s.moveDown();
		assertEquals("x move 1 unit to the down", 301, s.getY_coordinate());
	}
	@Test
	public void test_delete() {
		Bullet s = new Bullet(300, 300);
		s.delete();
		assertEquals("x coordinate is set to -1000", -300, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -300, s.getY_coordinate());
	}
	@Test
	public void test_bossPattern() {
		Bullet s = new Bullet(300, 300);
		s.bossPattern();
		assertEquals("x coordinate is set to 300 and moves to 308.14.....", 308, s.getX_coordinate());
		assertEquals("y coordinate is set to 300 and moves tp 303", 303, s.getY_coordinate());
	}
	
}