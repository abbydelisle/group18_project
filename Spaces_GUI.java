import java.util.ArrayList;
import javafx.scene.input.KeyCode;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class Spaces_GUI extends Application {
	Stage stage;
	private Text score = new Text (10, 50, "HighScore: " + readScore.read());
	private String quit = "Quit";
	static Scene scene;
	private boolean avatar_dead = false;
	private boolean e_dead = false;
	static Image avatar_image = new Image("avatar.png");
	//https://wallimpex.com/super-mario-galaxy-backgrounds/5510708.html
	static Image background = new Image("background.jpg");
	static ImageView iv = new ImageView(background);
	static Pane pane = new Pane();
	static Avatar_GUI avatar = new Avatar_GUI(avatar_image, 60, 60, 265, 700);
	static Image enemy_image = new Image("enemy.png");
	static Image heart_image = new Image("heart.png");
	static Image bullet_image = new Image("mario1.gif");
	static Image bullete_image = new Image("luigi1.gif");
	MenuBox menuBox = new MenuBox();


	Enemy_GUI enemy1 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy2 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy3 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy4 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy5 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	ArrayList<Enemy_GUI> enemy_list = new ArrayList<Enemy_GUI>(5);
	static Heart_GUI heart = new Heart_GUI(heart_image);


	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start (Stage stage) {
		this.stage = stage;
		score.setStyle("-fx-font-weight: bold");
		score.setFont(Font.font ("Verdana", 20));
		score.setFill(Color.YELLOW);
		stage.setTitle("Space Invaders");
		pane.getChildren().addAll(iv);
		//pane.setStyle("-fx-background-color:black;");
		pane.getChildren().add(avatar.getIV());
		pane.getChildren().addAll(enemy1.getIV(), enemy2.getIV(), enemy3.getIV(), enemy4.getIV(), enemy5.getIV());
		pane.getChildren().add(score);
		AnimationTimer eTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				enemy_list.add(enemy1);
				enemy_list.add(enemy2);
				enemy_list.add(enemy3);
				enemy_list.add(enemy4);
				enemy_list.add(enemy5);
				for (int i = 0; i < 5; i++) {
					enemy_list.get(i).moveRan();
				}
				if (avatar_dead) {
					stop();
					quit = "Lost";
					endGame();
				}
				if (e_dead) {
					stop();
					quit = "Won";
					endGame();
				}
			for (int i = 0; i <5; i++) {
				if(enemy_list.get(i).enemyShoot()) {
					shoot("enemy" + i, avatar, enemy_list.get(i));
				}
			}
			}
		};

		eTimer.start();
		heart.addHearts(pane, 10);

		scene = new Scene(pane, 600, 800, Color.BLACK);

		scene.setOnKeyPressed(e -> {
			avatar.movement(e.getCode());
			if (e.getCode() == KeyCode.Q) {
				quit = "Quit";
				endGame();
			}
			if (avatar.getShoots()) {
				shoot("avatar", avatar, null);
			}
		});
		stage.setScene(scene);
		stage.show();

	}
	public void endGame() {
		if (quit.equals("Won")) {
			menuBox.Win(stage, heart);
		}
		else if (quit.equals("Won Boss")) {
			menuBox.WinBoss(stage, heart);
		}

		// if avatar is dead; quit condition '2'
		else if (quit.equals("Lost")) {
			menuBox.Lose(stage);
		}

		// if 'Q' is pressed; quit condition '0'
		else {
			menuBox.Quit(stage);
		}

	}
	public void shoot(String type, Avatar_GUI avatar, Enemy_GUI enemy) {
		Bullet_GUI bullet;
		if (type == "avatar") {
			bullet = new Bullet_GUI(bullet_image, 60, 35, avatar.getX_coordinate(), avatar.getY_coordinate(), type);
		}
		else {
		bullet = new Bullet_GUI(bullete_image, 50, 35, enemy.getX_coordinate(), enemy.getY_coordinate() + 30, type);
		}

		pane.getChildren().add(bullet.getIV());
		AnimationTimer bulletTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				bullet.shoot(enemy_list, pane, avatar, heart, this);
				if (heart.getLife() == 0) {
					avatar.delete();
					avatar_dead = true;
				}
				if (avatar.getE_killed() == 5) {
					e_dead = true;
				}
			}
		};
		bulletTimer.start();

	}

}
