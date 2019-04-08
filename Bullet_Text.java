
public class Bullet_Text extends Bullet{
	public Bullet_Text(int x, int y) {
		super(x,y);
	}
	public void shoot(Grid_Text grid) {
		boolean enemy_hit = true;
		grid.placeObject(getName(), getY_coordinate(), getX_coordinate());
		grid.print();
		while ((enemy_hit)){
			if ((grid.getObject(getY_coordinate()-1, getX_coordinate()) == 'E')) {
				enemy_hit = false;
				super.setY_coordinate(super.getY_coordinate()-1);
				grid.placeObject(getName(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate()+1, super.getX_coordinate());
				grid.removeObject(super.getY_coordinate(), super.getX_coordinate());
				grid.print();
				
				
			}
			else {
				super.setY_coordinate(super.getY_coordinate()-1);
				grid.placeObject(getName(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate()+1, super.getX_coordinate());
				grid.print();	
			}
			}
	}
}
