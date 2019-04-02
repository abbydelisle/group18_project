import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Heart_GUI extends Heart {
	private Image img;
	private ArrayList<ImageView> heartiv = new ArrayList<ImageView>();
	public Heart_GUI(Image image) {
		setImg(image);
	}
	public void addHearts(Pane pane) {
		removeHearts(pane);
		super.removeHeartList();
		super.createHeartList();
		for (int i = 0; i < super.getHeartList_x().size(); i ++) {
		int x = super.getHeartList_x().get(i);
		ImageView heart = new ImageView();
		heart.setImage(getImg());
		heart.setX(x);
		heart.setY(super.getY());
		heart.setFitHeight(20);
		heart.setFitWidth(20);
		pane.getChildren().add(heart);
		heartiv.add(heart);
		}
	}
	public void removeHearts(Pane pane) {
		for (int i = 0; i < heartiv.size(); i ++) {
		pane.getChildren().remove(heartiv.get(i));
		}
		heartiv.remove(heartiv);
	}
	
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
}
