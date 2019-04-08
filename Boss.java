public class Boss {
    final int DELETE_COORD = -1000;
    final int RIGHT_BOUNDS = 540;
    final int BOTTOM_BOUNDS = 740;
    private int x_coordinate = 0;
    private int y_coordinate = 0;
    private int movement = 7;
    private boolean does_Boss_Shoot = false;
    private boolean is_Boss_Dead = false;
    private int hp = 5;

    public Boss(int x, int y) {
        setX_coordinate((int) (Math.random() * x));
        setY_coordinate((int) (Math.random() * y));
    }

    public boolean isBossDead() {
        return is_Boss_Dead;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public boolean doesBossShoot() {
        return does_Boss_Shoot;
    }

    public void setBossShoot(boolean shoot) {
        this.does_Boss_Shoot = shoot;
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
        if (Math.random() < 0.05 && !this.isBossDead()) {

            setBossShoot(true);

        } else {
            setBossShoot(false);
        }

        return doesBossShoot();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
