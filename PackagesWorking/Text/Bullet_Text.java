package Text;

import Logic.Bullet;

public class Bullet_Text extends Bullet{
    private char bullet_Char = '|';

	public Bullet_Text(int x, int y) {
		super(x,y);
		setBullet_Char('|');
	}
    public void setBullet_Char(char aChar) {
        this.bullet_Char = aChar;
    }
    public char getBullet_Char() {
        return bullet_Char;
    }

	public void shoot(Grid_Text grid, Avatar_Text avatar) {
		boolean enemy_hit = true;
		grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
		grid.print();
		while ((enemy_hit)){
			if ((grid.getObject(getY_coordinate()-1, getX_coordinate()) == 'E')) {
				enemy_hit = false;
				super.setY_coordinate(super.getY_coordinate()-1);
				grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate()+1, super.getX_coordinate());
				grid.removeObject(super.getY_coordinate(), super.getX_coordinate());
				grid.print();
				avatar.setEnemies_killed(avatar.getEnemies_killed() + 1);
			}
			else {
				super.setY_coordinate(super.getY_coordinate()-1);
				grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate()+1, super.getX_coordinate());
				grid.print();	
			}
			if (grid.getObject(getY_coordinate()-1, getX_coordinate()) == '#'){
				enemy_hit = false;
				grid.removeObject(super.getY_coordinate()+1, super.getX_coordinate());
				grid.removeObject(super.getY_coordinate(), super.getX_coordinate());
				grid.print();
			}

			}
	}


}
