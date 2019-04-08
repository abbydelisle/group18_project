public class Enemy_Text extends Enemy{
	private int num_Enemies = 5;
	private char enemy_Char = 'E';


	public Enemy_Text(int x, int y) {
		super(x,y);
		gridErrorCheck();
	}
    public void setEnemy_Char(char aChar) {
		this.enemy_Char = aChar;
	}
	public char getEnemy_Char() {
		return enemy_Char;
	}

	public void placeEnemies(Grid_Text grid) {
		int counter = 0;
		while (counter < num_Enemies) {
		if (grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == '.') {
			grid.placeObject(getEnemy_Char(), super.getY_coordinate(), super.getX_coordinate());
			counter ++;
		}
		int x = 7;
		int y = 6;
		setX_coordinate((int) (Math.random() * x));
        setY_coordinate((int) (Math.random() * y));
        gridErrorCheck();
		}
		grid.print();
	}
	public void gridErrorCheck() {
		while (super.getX_coordinate() == 0 || super.getX_coordinate() == 7) {
			super.setX_coordinate(1);
		}
		while (super.getY_coordinate() == 0 || super.getY_coordinate() == 6) {
			super.setY_coordinate(1);
		}

	}
	
}
