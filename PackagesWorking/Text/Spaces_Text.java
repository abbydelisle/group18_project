package Text;

import java.util.Scanner;

public class Spaces_Text {
	
	public static void main (String [] args) {
		Avatar_Text avatar = new Avatar_Text(4, 7);
		Grid_Text grid = new Grid_Text();
		Scanner reader = new Scanner(System.in);
		grid.placeObject(avatar.getAvatar_Char(), avatar.getY_coordinate(), avatar.getX_coordinate());
		Enemy_Text enemy = new Enemy_Text(7,6);
		enemy.placeEnemies(grid);
		boolean quit = false;
		while (!quit) {
			if (avatar.getEnemies_killed() == 5) {
				quit = true;
				System.out.println("You Won!");
			}
			else {
			char c = reader.next().charAt(0);
			if (c == 'l') {
				shoot(avatar.getX_coordinate(), avatar.getY_coordinate(), grid, avatar);

			}
			else if (c == 'q') {
				quit = true;
			}
			else{
			avatar.movement(c, grid);}
			}

			
		}
}
	public static void shoot(int x, int y, Grid_Text grid, Avatar_Text avatar) {
		Bullet_Text bullet = new Bullet_Text(x,y-1);
		bullet.shoot(grid, avatar);
	}
	}
