import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class HeartTest {
	@Test
	public void test_setLife() {
		Heart s = new Heart();
		s.setLife(5);
		assertEquals("Number of Hearts made is 5", 5, s.getLife());
	}
	/*@Test
	public void test_setHeartList_x() {
		Heart s = new Heart();
		ArrayList<Integer> categories = (1, 2, 3);
		assertTrue(myArraylist.equals(categories));
		s.setHeartList_x();
	}*/
	@Test
	public void test_loseLife() {
		Heart s = new Heart();
		s.loseLife();
		assertEquals("Lose 1 heart", 4, s.getLife());
	}
	@Test
	public void test_setY() {
		Heart s = new Heart();
		s.setY(40);
		assertEquals("Set the y-coordinate to 40", 40, s.getY());
	}
}
