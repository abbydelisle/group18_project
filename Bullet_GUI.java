import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Bullet_GUI extends Bullet {
	private Image image;
	ImageView iv = new ImageView();
	private int width;
	private int height;
	private String type;
	
	public Bullet_GUI(Image image, int w, int h, int x, int y, String type) {
		super (x,y);
		setImage(image);
		iv.setImage(getImage());
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
		setWidth(w);
		setHeight(h);
		setType(type);
		
	}

	public ImageView getIV() {
		return iv;
	}
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		iv.setFitWidth(width);
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		iv.setFitHeight(height);
		this.height = height;
	}
	
	public void movement(KeyCode code) {
		super.movement(code);
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
	}
	public void delete() {
		super.delete();
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
	}
	public void shoot(ArrayList<Enemy_GUI> enemy_list, Pane pane, Avatar_GUI avatar, Heart_GUI heart, AnimationTimer bulletTimer) {
		if (getType().equals("avatar")) {
		this.shootAvatar(enemy_list, pane, avatar);
		}
		else {
			this.shootEnemy(avatar, pane, heart, bulletTimer);
		}
	}
	public void shootAvatar(ArrayList<Enemy_GUI> enemy_list, Pane pane, Avatar avatar) {
		for (int i = 0; i <5; i++) {
		if (!iv.getBoundsInParent().intersects(enemy_list.get(i).getIV().getBoundsInParent()) 
				&& iv.getTranslateY() > -20) {
			this.moveUp();
			iv.setX(getX_coordinate());
			iv.setY(getY_coordinate());
			}
		// if the bullet does intersect with an enemy, set enemy to dead, remove the bullet and enemy
		// from the Pane, delete enemy from the list, and add one to number of enemies avatar has killed
		else if (iv.getBoundsInParent().intersects(enemy_list.get(i).getIV().getBoundsInParent()) ){
			pane.getChildren().remove(enemy_list.get(i).getIV());
			pane.getChildren().remove(iv);
			enemy_list.get(i).delete();
			enemy_list.get(i).setDead(true);
			this.delete();
			avatar.setE_killed(avatar.getE_killed() + 1);

			}
		}
		
	}
	public void shootEnemy(Avatar_GUI avatar, Pane pane, Heart_GUI heart, AnimationTimer bulletTimer) {
		avatar.setAvatar_hit(false);
		if (!iv.getBoundsInParent().intersects(avatar.getIV().getBoundsInParent()) 
				&& iv.getTranslateY() < 800){
			this.moveDown();
			iv.setX(getX_coordinate());
			iv.setY(getY_coordinate());
			}
		// if the bullet does intersect with the Avatar, remove the bullet, 
		// and set avatar to true
		else if (iv.getBoundsInParent().intersects(avatar.getIV().getBoundsInParent())){
			pane.getChildren().remove(iv);
			heart.loseLife();
			bulletTimer.stop();
			//System.out.println(heart.getLife());
			heart.addHearts(pane);
			//avatar_hit = true;
			}
		}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
