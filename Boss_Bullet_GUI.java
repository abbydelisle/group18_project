import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Boss_Bullet_GUI extends Bullet {
	private Image image;
	ImageView iv = new ImageView();
	private int width;
	private int height;
	private String type;
	
	public Boss_Bullet_GUI(Image image, int w, int h, int x, int y, String type) {
		super (x,y);
		setImage(image);
		iv.setImage(getImage());
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
		setWidth(w);
		setHeight(h);
		setType(type);
		super.setMovement(15);
		
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
	public void shoot(Boss_GUI boss, Pane pane, Avatar_GUI avatar, Heart_GUI heart, Heart_GUI boss_heart, AnimationTimer bulletTimer) {
		if (getType().equals("avatar")) {
		this.shootAvatar(boss, pane, boss_heart, avatar, bulletTimer);
		}
		else {
			this.shootEnemy(avatar, pane, heart, bulletTimer);
		}
	}

	public void shootAvatar(Boss_GUI boss, Pane pane, Heart_GUI boss_heart, Avatar avatar, AnimationTimer bulletTimer) {
		if (!iv.getBoundsInParent().intersects(boss.getIV().getBoundsInParent()) 
				&& iv.getTranslateY() > -20) {
			this.moveUp();
			iv.setX(getX_coordinate());
			iv.setY(getY_coordinate());
			}
		// if the bullet does intersect with an enemy, set enemy to dead, remove the bullet and enemy
		// from the Pane, delete enemy from the list, and add one to number of enemies avatar has killed
		else if (iv.getBoundsInParent().intersects(boss.getIV().getBoundsInParent()) ){
			pane.getChildren().remove(iv);
			boss_heart.loseLife();
			bulletTimer.stop();
			boss_heart.addHearts(pane, 400);
			}
		
		
	}
	public void shootEnemy(Avatar_GUI avatar, Pane pane, Heart_GUI heart, AnimationTimer bulletTimer) {
		if (!iv.getBoundsInParent().intersects(avatar.getIV().getBoundsInParent()) 
				&& iv.getTranslateY() < 800){
			this.bossPattern();
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
			heart.addHearts(pane, 10);
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
