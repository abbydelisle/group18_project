import javafx.scene.input.KeyCode;

public class Boss_Bullet {
    final int DELETE_COORD = -300;
    final int RIGHT_BOUNDS = 540;
    final int BOTTOM_BOUNDS = 800;
    private int life = 5;
    private int x_coordinate = 0;
    private int y_coordinate = 0;
    private int bullet_movement = 1;

    public Boss_Bullet(int x_coordinate, int y_coordinate) {
        setX_coordinate(x_coordinate);
        setY_coordinate(y_coordinate);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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
        return bullet_movement;
    }

    public void setMovement(int bullet_movement) {
        this.bullet_movement = bullet_movement;
    }

    public void moveLeft() {
        if (getX_coordinate() > 0) {
            setX_coordinate(getX_coordinate() - getMovement());
        }
    }

    public void moveRight() {
        if (getX_coordinate() < RIGHT_BOUNDS) {
            setX_coordinate(getX_coordinate() + getMovement());
        }
    }

    public void moveUp() {
        setY_coordinate(getY_coordinate() - getMovement());

    }

    public void moveDown() {
        if (getY_coordinate() < BOTTOM_BOUNDS) {
            setY_coordinate(getY_coordinate() + getMovement());
        }
    }

    public void delete() {
        setX_coordinate(DELETE_COORD);
        setY_coordinate(DELETE_COORD);
    }
}
