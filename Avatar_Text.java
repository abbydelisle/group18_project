
public class Avatar_Text extends Avatar{
	private char avatar_Char = 'S';

	public Avatar_Text(int x, int y) {
		super(x,y);
		setAvatar_Char('S');
		super.setMovement(1);
	}
	public void setAvatar_Char(char aChar) {
		this.avatar_Char = aChar;
	}
	public char getAvatar_Char() {
		return avatar_Char;
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
			grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
					}
		else if(grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == '#'){
			System.out.println("You can not go out of bounds");
			super.setX_coordinate(x);
			super.setY_coordinate(y);
			grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
		}
		else {
		grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
		}

		grid.print();
		}
	}

