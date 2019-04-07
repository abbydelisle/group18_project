import javafx.scene.input.KeyCode;

import java.io.DataOutputStream;

public class Enemy {
    final int RIGHT_BOUNDS = 540;
    final int BOTTOM_BOUNDS = 740;
    final int DELETE_COORD = -1000;
    final double ENEMY_BULLET_SPEED = 0.005;
    private int x_coordinate = 0;
    private int y_coordinate = 0;
    private int movement = 7;
    private boolean shoot = false;
    private boolean dead = false;

    public Enemy(int x, int y) {
        setX_coordinate((int) (Math.random() * x));
        setY_coordinate((int) (Math.random() * y));
    }

    public boolean getDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public boolean getShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
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

    public void setMovement(int movement) {
        this.movement = movement;
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
        if (getY_coordinate() > 0) {
            setY_coordinate(getY_coordinate() - getMovement());
        }
    }

    public void moveDown() {
        if (getY_coordinate() < BOTTOM_BOUNDS) {
            setY_coordinate(getY_coordinate() + getMovement());
        }
    }

    public void moveRan() {
        double r = Math.random();
        if (r < 0.10 && getX_coordinate() > 0) {
            setX_coordinate(getX_coordinate() - getMovement());
        } else if (r < 0.20 && getX_coordinate() < 600) {
            setX_coordinate(getX_coordinate() + getMovement());
        } else if (r < 0.30 && getY_coordinate() > 0) {
            setY_coordinate(getY_coordinate() - getMovement());
        } else if (r < 0.40 && getY_coordinate() < 500) {
            setY_coordinate(getY_coordinate() + getMovement());
        }
    }

    public void delete() {
        setX_coordinate(DELETE_COORD);
        setY_coordinate(DELETE_COORD);

    }

    public boolean enemyShoot() {
        if (Math.random() < ENEMY_BULLET_SPEED && !this.getDead()) {

            setShoot(true);

        } else {
            setShoot(false);
        }

        return getShoot();
    }


}
