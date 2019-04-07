import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Avatar_GUI extends Avatar {
	private Image image;
	ImageView iv = new ImageView();
	private int width;
	private int height;

	public Avatar_GUI(Image image, int width, int height, int xCood, int yCood) {
		super(xCood, yCood);
		setImage(image);
		iv.setImage(getImage());
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
		setWidth(width);
		setHeight(height);
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
		switch (code) {

			case A:
				moveLeft();
				setShoots(false);
				break;
			case D:
				moveRight();
				setShoots(false);
				break;
			case W:
				moveUp();
				setShoots(false);
				break;
			case S:
				moveDown();
				setShoots(false);
				break;
			case SPACE:
				setShoots(true);
				break;

		}
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
