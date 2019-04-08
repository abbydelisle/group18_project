package Gui;

import java.util.ArrayList;

import Logic.Heart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Heart_GUI extends Heart {
    final int HEART_WIDTH_AND_HEIGHT = 20;
    private Image img;
    private ArrayList<ImageView> heart_Image_View = new ArrayList<ImageView>();

    public Heart_GUI(Image image) {
        setImg(image);
    }

    public void addHearts(Pane pane, int j) {
        removeHearts(pane);
        super.removeHeartList();
        super.createHeartList(j);
        for (int i = 0; i < super.getHeartList().size(); i++) {
            int xCoord = super.getHeartList().get(i);
            ImageView heart = new ImageView();
            heart.setImage(getImg());
            heart.setX(xCoord);
            heart.setY(super.getY());
            heart.setFitHeight(HEART_WIDTH_AND_HEIGHT);
            heart.setFitWidth(HEART_WIDTH_AND_HEIGHT);
            pane.getChildren().add(heart);
            heart_Image_View.add(heart);
        }
    }

    public void removeHearts(Pane pane) {
        for (int i = 0; i < heart_Image_View.size(); i++) {
            pane.getChildren().remove(heart_Image_View.get(i));
        }
        heart_Image_View.clear();
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
