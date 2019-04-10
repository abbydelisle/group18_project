package Logic;

/**
 * This class creates a bullet and isused in the GUI version.
 * The bullet can be used for Avatar_Logic, Enemy_Logic or Boss_Logic and contains movement methods and
 * a method for the pattern of the Boss_Logic bullets.
 */

public class Bullet_Logic {
  final int RIGHT_BOUNDS = 540;
  final int BOTTOM_BOUNDS = 800;
  final int DELETE_COORD = -300;
  private int life = 5;
  private int x_coordinate = 0;
  private int y_coordinate = 0;
  private int movement = 1;

  /**
   * Creates a Bullet_Logic with an x and y coordinate. These coordinates will come from
   * the getter methods of whatever is shooting the Bullet_Logic.
   * @param x_coordinate the x coord of the Bullet_Logic.
   * @param y_coordinate the y coord of the Bullet_Logic.
   */
   public Bullet_Logic(int x_coordinate, int y_coordinate) {
     setX_coordinate(x_coordinate);
     setY_coordinate(y_coordinate);
  }

  /**
   * @return x_coordinate which is used to place the Bullet_Logic.
   */
  public int getX_coordinate() {
    return x_coordinate;
  }

  /**
   * @return y_coordinate which is used to place the Bullet_Logic.
   */
  public int getY_coordinate() {
    return y_coordinate;
  }
  
  public int getLife() {
	    return life;
  }
  
  /**
   * @return movement which is the amount the Bullet_Logic moves each time.
   */
   public int getMovement() {
     return movement;
   }

  /**
   *@param y_coordinate the y coord for Bullet_Logic.
   */
  public void setY_coordinate(int y_coordinate) {
    this.y_coordinate = y_coordinate;
    }
  
  /**
   * @param x_coordinate the x coord for Bullet_Logic.
   */
  public void setX_coordinate(int x_coordinate) {
    this.x_coordinate = x_coordinate;
  }

  public void setLife(int life) {
    this.life = life;
  }

  /**
   * @param movement sets a value for how much the Bullet_Logic moves.
   */
  public void setMovement(int movement) {
    this.movement = movement;
  }

  /**
   * Sets the x and y coordinates to a location off screen.
   */
  public void delete() {
    setX_coordinate(DELETE_COORD);
    setY_coordinate(DELETE_COORD);
  }

  /**
	 * If the y coorinate is within the bounds of the screen, moves the bullet
	 * up by subtracting the value stored in movement from the y coordinate
	 * of Bullet_Logic.
	 */
	public void moveUp() {
		setY_coordinate(getY_coordinate() - getMovement());
	}

	/**
	 * If the y coorinate is within the bounds of the screen, moves the bullet
	 * down by adding the value stored in movement to the y coordinate
	 * of Bullet_Logic.
	 */
	public void moveDown() {
		if (getY_coordinate() < BOTTOM_BOUNDS) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}

  /**
   * This method changes the x and y coordinates so that they will shoot in an arc
   * instead of a straight line in the GUI.
   */
  public void bossPattern() {
    //3 and 50 are magic numbers that we used to make the bullet pattern
    int y_coordinate = getY_coordinate() + 3;
    int x_coordinate = (int) ((Math.cos(y_coordinate)) * 50);
    setX_coordinate(x_coordinate + getX_coordinate());
    setY_coordinate(y_coordinate);
  }
}
