

import static org.junit.Assert.*;

import org.junit.Test;

public class AvatarTest {

	@Test
	public void test_getX_Coordinate() {
		Avatar s = new Avatar(300, 300);
		s.setX_coordinate(150);
		assertEquals("x = 150", 150, s.getX_coordinate());
	}
	@Test
	public void test_getY_Coordinate() {
		Avatar s = new Avatar(300, 300);
		s.setY_coordinate(150);
		assertEquals("y = 150", 150, s.getY_coordinate());
	}
	@Test
	public void test_moveLeft() {
		Avatar s = new Avatar(300, 300);
		s.moveLeft();
		assertEquals("x move 10 unit to the left", 290, s.getX_coordinate());
	}
	@Test
	public void test_moveRight() {
		Avatar s = new Avatar(300, 300);
		s.moveRight();
		assertEquals("x move 10 unit to the right", 310, s.getX_coordinate());
	}
	@Test
	public void test_moveUp() {
		Avatar s = new Avatar(300, 300);
		s.moveUp();
		assertEquals("x move 10 unit to the up", 290, s.getY_coordinate());
	}
	@Test
	public void test_moveDown() {
		Avatar s = new Avatar(300, 300);
		s.moveDown();
		assertEquals("x move 10 unit to the down", 310, s.getY_coordinate());
	}
	@Test
	public void test_setLife() {
		Avatar s = new Avatar(300, 300);
		s.setLife(5);
		assertEquals("amount of lives is 5", 5, s.getLife());
	}
	@Test
	public void test_delete() {
		Avatar s = new Avatar(300, 300);
		s.delete();
		assertEquals("x coordinate is set to -1000", -1000, s.getX_coordinate());
		assertEquals("y coordinate is set to -1000", -1000, s.getY_coordinate());
	}
	
}