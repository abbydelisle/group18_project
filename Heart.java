import java.util.ArrayList;

import javafx.scene.input.KeyCode;


public class Heart {
	private int life = 5;
	private int y = 10;
	private ArrayList<Integer> heartList_x = new ArrayList<Integer>();

	
	public void createHeartList(){
		for (int i = 0; i < getLife(); i++) {
			heartList_x.add(10 + i*30);
			System.out.println(heartList_x.size());
		}		
	}
	public void removeHeartList(){
			heartList_x.removeAll(heartList_x);
				
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		if (life >= 0) {
		this.life = life;
		}
	}

	public ArrayList<Integer> getHeartList_x() {
		return heartList_x;
	}

	public void setHeartList_x(ArrayList<Integer> heartList) {
		this.heartList_x = heartList;
	}

	public int getY() {
		return y;
	}
	public void loseLife() {
		setLife(getLife()-1);
	}

	public void setY(int y) {
		this.y = y;
	}

}
