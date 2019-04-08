import java.util.Scanner;

public class Spaces_Text {
	
	public static void main (String [] args) {
		Avatar_Text avatar = new Avatar_Text(4, 7, 'S');
		Grid_Text grid = new Grid_Text();
		Scanner reader = new Scanner(System.in);
		grid.placeObject(avatar.getName(), avatar.getY_coordinate(), avatar.getX_coordinate());
		Enemy_Text enemy = new Enemy_Text(7,6);
		enemy.placeEnemies(grid);
		boolean quit = false;
		while (!quit) {
			char c = reader.next().charAt(0);
			if (c == 'l') {
				shoot(avatar.getX_coordinate(), avatar.getY_coordinate(), grid);
			}
			else if (c == 'q') {
				quit = true;
			}
			else{
			avatar.movement(c, grid);
			}
			
		}
}
	public static void shoot(int x, int y, Grid_Text grid) {
		Bullet_Text bullet = new Bullet_Text(x,y-1);
		bullet.shoot(grid);
	}
	}
