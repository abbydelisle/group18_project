import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuBox{
	private Button button1 = new Button ("Quit Game");
	private Button button2 = new Button ("Fight Boss");
	Text won = new Text (10, 10, "You Won!");
	Text lost = new Text (10, 10, "You Lost!");
	VBox vbox = new VBox();

	public void Win(Stage window) {
		vbox.getChildren().add(won);
		vbox.getChildren().add(button1);
		vbox.getChildren().add(button2);
		vbox.setAlignment(Pos.CENTER);
		Stage newstage = new Stage();
		Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
		newstage.setScene(newscene);
		newstage.show();

		button1.setOnAction(e -> {
			window.close();
			newstage.close();
			});
		button2.setOnAction(e -> {
			window.close();
			newstage.close();
			try {
				Process P = Runtime.getRuntime().exec("java BossFight");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			});

	}
	public void WinBoss(Stage window) {
		vbox.getChildren().add(won);
		vbox.getChildren().add(button1);
		vbox.setAlignment(Pos.CENTER);
		Stage newstage = new Stage();
		Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
		newstage.setScene(newscene);
		newstage.show();

		button1.setOnAction(e -> {
			window.close();
			newstage.close();
			});
	}
	public void Quit(Stage window) {
		vbox.getChildren().add(button1);
		vbox.setAlignment(Pos.CENTER);
		Stage newstage = new Stage();
		Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
		newstage.setScene(newscene);
		newscene.setFill(Color.BLACK);
		newstage.show();

		button1.setOnAction(e -> {
			window.close();
			newstage.close();
			});

	}
	public void Lose(Stage window) {
		vbox.getChildren().add(lost);
		vbox.getChildren().add(button1);
		vbox.setAlignment(Pos.CENTER);
		Stage newstage = new Stage();
		Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
		newstage.setScene(newscene);
		newscene.setFill(Color.BLACK);
		newstage.show();

		button1.setOnAction(e -> {
			window.close();
			newstage.close();
			});

	}
}
