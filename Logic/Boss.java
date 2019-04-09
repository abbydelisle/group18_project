package Logic;

/**
 * This class is used in the GUI version of the game to create a Boss.
 * It functions similar to the enemies but has more lives and shoots differently.
 */

public class Boss {
  final int DELETE_COORD = -1000;
  final int RIGHT_BOUNDS = 600;
  final int BOTTOM_BOUNDS = 500;
  final double BOSS_BULLET_SPEED = 0.05;
  private int x_coordinate = 0;
  private int y_coordinate = 0;
  private int movement = 7;
  private boolean does_Boss_Shoot = false;
  private boolean is_Boss_Dead = false;
  private int hp = 5;

  /**
   * Creates a Boss with random x and y coordinates by multiplying a max
   * x and y by a random number between 0 and 1.
   * @param max_x the bound for the x coordinate.
   * @param max_y the bound for the y coordinate.
   */
  public Boss(int max_x, int max_y) {
    setX_coordinate((int) (Math.random() * max_x));
    setY_coordinate((int) (Math.random() * max_y));
  }

  /**
   * @return x_coordinate which is used to place the Boss.
   */
  public int getX_coordinate() {
    return x_coordinate;
  }

  /**
   * @param x_coordinate the x coord for Boss.
   */
  public void setX_coordinate(int x_coordinate) {
    this.x_coordinate = x_coordinate;
  }

  /**
   * @return y_coordinate which is used to place the Boss.
   */
  public int getY_coordinate() {
    return y_coordinate;
  }

  /**
   * @param y_coordinate the y coord for Boss.
   */
  public void setY_coordinate(int y_coordinate) {
    this.y_coordinate = y_coordinate;
  }

  /**
   * @return movement which is the amount the Enemy moves each time.
   */
  public int getMovement() {
    return movement;
  }

  /**
   * @param movement sets a value for how much the Enemy moves.
   */
  public void setMovement(int movement) {
    this.movement = movement;
  }

  /**
   * @return hp the number of lives the Boss has left.
   */
  public int getHp() {
    return hp;
  }

  public void setBossShoot(boolean shoot) {
    this.does_Boss_Shoot = shoot;
  }

  public boolean doesBossShoot() {
    return does_Boss_Shoot;
  }

  /**
   * @return is_Boss_Dead which is true if the Boss has lost all it's lives.
   */
  public boolean isBossDead() {
    return is_Boss_Dead;
  }

  /**
   * Sets the x and y coordinates to a location off screen.
   */
  public void delete() {
    setX_coordinate(DELETE_COORD);
    setY_coordinate(DELETE_COORD);
  }

  /**
   * This method uses Math.random() to move the Boss. The magic numbers
   * are percentages, so for the first 10% the enemy is moved left, for the next
   * 10% it moves right, then up and down respectively. If the number generated
   * is greater than 0.40 the Boss will not move.
   */
  public void moveRan() {
    double r = Math.random();
      if (r < 0.10 && getX_coordinate() > 0) {
        setX_coordinate(getX_coordinate() - getMovement());
      } else if (r < 0.20 && getX_coordinate() < RIGHT_BOUNDS) {
          setX_coordinate(getX_coordinate() + getMovement());
      } else if (r < 0.30 && getY_coordinate() > 0) {
          setY_coordinate(getY_coordinate() - getMovement());
      } else if (r < 0.40 && getY_coordinate() < BOTTOM_BOUNDS) {
          setY_coordinate(getY_coordinate() + getMovement());
      }
  }

  /**
   * Sets shoot to true if a randomly generated number is less than the constant
   * bullet speed and the Boss is not dead.
   * This causes the Boss to shoot at random times but ensures that it is
   * not shooting too often.
   */
  public boolean enemyShoot() {
    if (Math.random() < BOSS_BULLET_SPEED && !this.isBossDead()) {
      setBossShoot(true);
    } else {
        setBossShoot(false);
      }
    return doesBossShoot();
  }
}
