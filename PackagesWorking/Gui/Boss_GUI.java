package Gui;

import Logic.Boss;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Boss_GUI extends Boss {
	private Image image;
	ImageView iv = new ImageView();
	private int width;
	private int height;

	public Boss_GUI(Image image, int width, int height, int xCoord, int yCoord) {
		super(xCoord, yCoord);
		setImage(image);
		iv.setImage(getImage());
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
		setWidth(width);
		setHeight(height);
	}

	public ImageView getImageView() {
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

	public void moveRan() {
		super.moveRan();
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
	}

	public void delete() {
		super.delete();
		setWidth(1);
		setHeight(1);
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
	}

}
