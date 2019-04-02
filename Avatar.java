import javafx.scene.input.KeyCode;

public class Avatar{
	private int life = 5;
	private int x_coordinate = 0;
	private int y_coordinate = 0;
	private int movement = 10;
	private boolean avatar_hit = false;
	public boolean shoots = false;
	public int e_killed = 0;
	
	public Avatar (int x, int y) {
		setX_coordinate(x);
		setY_coordinate(y);
	}
	public int getE_killed() {
		return e_killed;
	}
	public void setE_killed(int value) {
		e_killed = value;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void delete() {
		setX_coordinate(-1000);
		setY_coordinate(-1000);
		
	}

	public void loseLife() {
		setAvatar_hit(true);
		setLife(getLife() - 1);
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
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public void moveLeft() {
		if (getX_coordinate()> 0) {
			setX_coordinate(getX_coordinate() - getMovement());
		}
	}
	public void moveRight() {
		if (getX_coordinate()< 540) {
			setX_coordinate(getX_coordinate() + getMovement());
		}
	}
	public void moveUp() {
		if (getY_coordinate()> 0) {
			setY_coordinate(getY_coordinate() - getMovement());
		}
	}
	public void moveDown() {
		if (getY_coordinate() < 740) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}

	public void movement(KeyCode code) {
		switch (code) {
		case A:
			moveLeft();
			shoots = false;
			break;
		case D:
			moveRight();
			shoots = false;
			break;
		case W:
			moveUp();
			shoots = false;
			break;
		case S:
			moveDown();
			shoots = false;
			break;
		case SPACE:
			shoots = true;
			break;
		}
	}
	public boolean isAvatar_hit() {
		return avatar_hit;
	}
	public void setAvatar_hit(boolean avatar_hit) {
		this.avatar_hit = avatar_hit;
	}


	
}
