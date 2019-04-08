
public class Grid_Text {
	public static char[][] grid = {{'#','#','#','#','#','#','#','#'}, //0
									{'#','.','.','.','.','.','.','#'},  //1
									{'#','.','.','.','.','.','.','#'},  //2
									{'#','.','.','.','.','.','.','#'},	//3
									{'#','.','.','.','.','.','.','#'},  //4
									{'#','.','.','.','.','.','.','#'},  //5
									{'#','.','.','.','.','.','.','#'},  //6
									{'#','.','.','.','.','.','.','#'},  //7
									{'#','.','.','.','.','.','.','#'},  //8
									{'#','#','#','#','#','#','#','#'}}; //9
	public void print(){
		for (int row = 0; row < 10; row++){
		for (int column = 0; column < 8; column++){
			System.out.print(grid[row][column]);
			}
		System.out.println();
		}
		}
	public void placeObject(char object, int row, int column) {
		grid[row][column] = object;
		}
	public void removeObject(int row, int column) {
		grid[row][column] = '.';
		}
	public char getObject(int row, int column){
		return grid[row][column];
	}

	}
