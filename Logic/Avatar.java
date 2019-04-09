package Logic;

/**
 * This class is the logic base for the ship in both the text based
 * and GUI versions. It contains methods for movement as well as methods
 * to determine what actions the avatar should take.
 */

public class Avatar {
	final int DELETE_COORD = -1000;
	final int RIGHT_BOUNDS = 540;
	final int BOTTOM_BOUNDS = 740;
	private int x_coordinate = 0;
	private int y_coordinate = 0;
	private int movement = 10;
	private int enemies_killed = 0;
	private int life = 5;
	private boolean avatar_hit = false;
	private boolean shoots = false;

	/**
	 * Creates an avatar with a location.
	 * @param x_coordinate the x coord for Avatar.
	 * @param y_coordinate the y coord for Avatar.
	 */
	public Avatar(int x_coordinate, int y_coordinate) {
		setX_coordinate(x_coordinate);
		setY_coordinate(y_coordinate);
	}

	/**
	 * @return x_coordinate which is used to place the Avatar.
	 */
	public int getX_coordinate() {
		return x_coordinate;
	}

	/**
	 * @param x_coordinate the x coord for Avatar.
	 */
	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	/**
	 * @return y_coordinate which is used to place the Avatar.
	 */
	public int getY_coordinate() {
		return y_coordinate;
	}

	/**
	 * @param y_coordinate the y coord for Avatar.
	 */
	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	/**
	 * @return movement which is the amount the Avatar moves each time.
	 */
	public int getMovement() {
		return movement;
	}

	/**
	 * @param movement sets how much the Avatar will move.
	 */
	public void setMovement(int movement) {
		this.movement = movement;
	}

	/**
	 * @return enemies_killed the number of enemies the user has killed.
	 */
	public int getEnemies_killed() {
		return enemies_killed;
	}

	/**
	 * @param add_Enemies_Killed used to increase the number of enemies the
	 * user has killed.
	 */
	public void setEnemies_killed(int add_Enemies_Killed) {
		enemies_killed = add_Enemies_Killed;
	}

	/**
	 * @return life the number of lives the Avatar has remaining.
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @return shoots which is true if the Avatar should continue shooting and
	 * false otherwise.
	 */
	public boolean getShoots() {
		return shoots;
	}

	/**
	 * @param shoots sets whether or not the ship shoots a bullet.
	 */
	public void setShoots(boolean shoots) {
		this.shoots = shoots;
	}

	/**
	 * @return avatar_hit which is a boolean for if the avatar has been shot by
	 * an enemy.
	 */
	public boolean isAvatar_hit() {
		return avatar_hit;
	}

	/**
	 * Changes the x and y coordinates to a location out of view of the screen.
	 */
	public void delete() {
		setX_coordinate(DELETE_COORD);
		setY_coordinate(DELETE_COORD);
	}

	/**
	 * If the x coorinate is within the bounds of the screen, moves the ship
	 * left by subtracting the value stored in movement from the x coordinate
	 * of Avatar.
	 */
	public void moveLeft() {
		if (getX_coordinate()> 0) {
			setX_coordinate(getX_coordinate() - getMovement());
		}
	}

	/**
	 * If the x coorinate is within the bounds of the screen, moves the ship
	 * right by adding the value stored in movement to the x coordinate
	 * of Avatar.
	 */
	public void moveRight() {
		if (getX_coordinate() < RIGHT_BOUNDS) {
			setX_coordinate(getX_coordinate() + getMovement());
		}
	}

	/**
	 * If the y coorinate is within the bounds of the screen, moves the ship
	 * up by subtracting the value stored in movement from the y coordinate
	 * of Avatar.
	 */
	public void moveUp() {
		if (getY_coordinate() > 0) {
			setY_coordinate(getY_coordinate() - getMovement());
		}
	}

	/**
	 * If the y coorinate is within the bounds of the screen, moves the ship
	 * down by adding the value stored in movement to the y coordinate
	 * of Avatar.
	 */
	public void moveDown() {
		if (getY_coordinate() < BOTTOM_BOUNDS) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}
}
