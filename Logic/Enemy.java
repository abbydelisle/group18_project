package Logic;

/**
 * This class is the logic base for the enemies in both the text based
 * and GUI versions. It contains methods for movement as well as methods
 * to determine what actions the enemies should take.
 */

public class Enemy {
  final int RIGHT_BOUNDS = 600;
  final int BOTTOM_BOUNDS = 500;
  final int DELETE_COORD = -1000;
  final double ENEMY_BULLET_SPEED = 0.005;
  private int x_coordinate = 0;
  private int y_coordinate = 0;
  private int movement = 7;
  private boolean shoot = false;
  private boolean dead = false;

  /**
   * Creates an enemy with random x and y coordinates by multiplying a max
   * x and y by a random number between 0 and 1.
   * @param max_x the bound for the x coordinate.
   * @param max_y the bound for the y coordinate.
   */
  public Enemy(int max_x, int max_y) {
    setX_coordinate((int) (Math.random() * max_x));
    setY_coordinate((int) (Math.random() * max_y));
  }

  /**
   * @return x_coordinate which is used to place the Enemy
   */
  public int getX_coordinate() {
    return x_coordinate;
  }

  /**
   * @param x_coordinate the x coord for Enemy.
   */
  public void setX_coordinate(int x_coordinate) {
    this.x_coordinate = x_coordinate;
  }

  /**
   * @return y_coordinate which is used to place the Enemy.
   */
  public int getY_coordinate() {
    return y_coordinate;
  }

  /**
   *@param y_coordinate the y coord for Enemy.
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
   * @return dead is true if the Enemy has been shot, true otherwise.
   */
  public boolean getDead() {
    return dead;
  }

  /**
   * @param dead sets whether or not the Enemy has been shot.
   */
  public void setDead(boolean dead) {
    this.dead = dead;
  }

  /**
   * @return shoot is true if the Enemy should shoot, false otherwise.
   */
  public boolean getShoot() {
    return shoot;
  }

  /**
   * @param shoot sets whether or not the Enemy should shoot.
   */
  public void setShoot(boolean shoot) {
    this.shoot = shoot;
  }

  /**
   * Sets the x and y coordinates to a location off screen.
   */
  public void delete() {
    setX_coordinate(DELETE_COORD);
    setY_coordinate(DELETE_COORD);
  }

  /**
   * This method uses Math.random() to move the enemy. The magic numbers
   * are percentages, so for the first 10% the enemy is moved left, for the next
   * 10% it moves right, then up and down respectively. If the number generated
   * is greater than 0.40 the enemy will not move.
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
   * bullet speed and the Enemy is not dead.
   * This causes the Enemy to shoot at random times but ensures that it is
   * not shooting too often.
   */
  public boolean enemyShoot() {
    if (Math.random() < ENEMY_BULLET_SPEED && !this.getDead()) {
      setShoot(true);
    } else {
        setShoot(false);
      }
    return getShoot();
  }
}
