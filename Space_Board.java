import java.util.*;
public class Space_Board {
	public char[][] grid = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R1
					 				 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R2
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},	 //R3
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R4
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R5
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R6
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R7
				 	 		 	 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R8
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R9
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}}; //R10
				   		  	//C 1   2   3   4   5   6   7   8   9   10  11

	public void placeObject(char object, int row, int column) {
		grid[row][column] = object;
	}

	public void removeObject(int row, int column) {
		grid[row][column] = ' ';
	}
	public char getObject(int row, int column){
		return grid[row][column];
	}

public void print(){
		for (int row = 0; row < 10; row++){
			for (int column = 0; column < 11; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}

public static void main(String [] args){
	Space_Board grix = new Space_Board();

	grix.placeObject('z', 3,3);
	grix.print();
}
}
