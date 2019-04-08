public class Avatar {
	final int DELETE_COORD = -1000;
	final int RIGHT_BOUNDS = 540;
	final int BOTTOM_BOUNDS = 740;
	private int life = 5;
	private int x_coordinate = 0;
	private int y_coordinate = 0;
	private int movement = 10;
	private boolean avatar_hit = false;
	public boolean shoots = false;
	public int enemies_killed = 0;


	public Avatar(int x_coordinate, int y_coordinate) {
		setX_coordinate(x_coordinate);
		setY_coordinate(y_coordinate);
	}
	
	public int getEnemies_killed() {
		return enemies_killed;
	}

	// what is value??
	public void setEnemies_killed(int add_Enemies_Killed) {
		enemies_killed = add_Enemies_Killed;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void delete() {
		setX_coordinate(DELETE_COORD);
		setY_coordinate(DELETE_COORD);

	}

	public int getX_coordinate() {
		return x_coordinate;
	}

	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public int getY_coordinate() {
		return y_coordinate;
	}

	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	public int getMovement() {
		return movement;
	}

	public boolean getShoots() {
		return shoots;
	}
	public void setShoots(boolean shoots){
		this.shoots = shoots;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public void moveLeft() {
		if (getX_coordinate()> 0) {
			setX_coordinate(getX_coordinate() - getMovement());
		}
	}

	public void moveRight() {
		if (getX_coordinate() < RIGHT_BOUNDS) {
			setX_coordinate(getX_coordinate() + getMovement());
		}
	}

	public void moveUp() {
		if (getY_coordinate() > 0) {
			setY_coordinate(getY_coordinate() - getMovement());
		}
	}

	public void moveDown() {
		if (getY_coordinate() < BOTTOM_BOUNDS) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}

	public boolean isAvatar_hit() {
		return avatar_hit;
	}


	
}
