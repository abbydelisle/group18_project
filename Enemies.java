import java.util.Random;

public class Enemies extends Space_Board {
  char alien = 'Z';
  boolean changeDirection = false;
  int MAXENEMIES = 9;
  int ROW = 10;
  int COLUMN =11;

//use randam to generate row and column where the enemies will be placed on the board
public void generateEnemies(char alien, int row, int column){
  Random rand = new Random();
  int enemies = 0;

  while (enemies<MAXENEMIES){
    // Obtain a number between 0 to x then use for row and column.
    //check if [row][column] already in list
    row = rand.nextInt(10);
    column = rand.nextInt(11);
    if (grid[row][column] == ' '){
      grid[row][column] = alien;
      enemies++;
    }
  }
}
public int getPosition() {
  for (int column = 0; column <= COLUMN; column++){
    for (int row = 0; row <= ROW; row++){
      if (grid[row][column] == 'Z'){
        return grid[row][column];
        }
      }
    } return -1;
  }

// after each turn move the enemy based on a boolean
public void moveEnemies() {
  for (int column = 0; column <= COLUMN; column++){
    for (int row = 0; row <= ROW; row++){
      if (grid[row][column] == 'Z'){
        //grid[row][column];
        //get temp location tempAlien = [row][column]
      }
    }
  }
  //make sure there is room in list to move
  if (changeDirection == true){
    //move on grid one way
  }
  else if (changeDirection == false){
    //move opposite way
  }
}


}
