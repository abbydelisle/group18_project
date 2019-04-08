
public class Avatar_Text extends Avatar{
	public Avatar_Text(int x, int y, char aChar) {
		super(x,y,aChar);
		super.setMovement(1);
	}
	public void movement(char aChar, Grid_Text grid) {
		int x = super.getX_coordinate();
		int y = super.getY_coordinate();
		grid.removeObject(getY_coordinate(), getX_coordinate());
		if (aChar == 'w') {
			moveUp();
		}
		else if (aChar == 's') {
			moveDown();
		}
		else if (aChar == 'a') {
			moveLeft();
		}
		else if (aChar == 'd') {
			moveRight();
		}
		if (grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == 'E'){
			System.out.println("You can not go over enemies");
			super.setX_coordinate(x);
			super.setY_coordinate(y);
			grid.placeObject(getName(), getY_coordinate(), getX_coordinate());
					}
		else {
		grid.placeObject(getName(), getY_coordinate(), getX_coordinate());
		}
		grid.print();
		}
	}

