import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BossFight extends Spaces_GUI{
	Stage stage;
	Scene scene;
	boolean avatar_dead = false;
	boolean boss_dead = false;
	String quit = "Quit";
	Pane pane = new Pane();
	// avatar_image;
	// heart_image;
	// backgorund
	// iv;
	//Avatar_GUI avatar = new Avatar_GUI(avatar_image, 60, 60, 265, 700);
	Image boss_image = new Image("boss.png");
	Boss_GUI boss = new Boss_GUI(boss_image, 100, 100, 400, 500);
	Heart_GUI boss_heart = new Heart_GUI(heart_image);
	
	public static void main (String[] args) {
		launch(args);
	}
	@Override
	public void start (Stage stage) {
		this.stage = stage;
		stage.setTitle("Space Invaders Boss Fight");
		pane.getChildren().addAll(iv);
		pane.getChildren().add(avatar.getIV());
		pane.getChildren().add(boss.getIV());
		AnimationTimer eTimer = new AnimationTimer() {
			@Override
			public void handle (long now) {
				boss.moveRan();
				if (avatar_dead) {
					stop();
					quit = "Lost";
					endGame();
					}
				if (boss_dead) {
					stop();
					quit = "Won Boss";
					endGame();
				}
				if(boss.enemyShoot()) {
					shoot("enemy" + 1, avatar, boss);
				}
				
			}
		};
		eTimer.start();
		heart.addHearts(pane, 10);
		boss_heart.addHearts(pane, 400);
		scene = new Scene(pane, 600, 800, Color.BLACK);
		scene.setOnKeyPressed(e -> {
			avatar.movement(e.getCode());
			if (e.getCode() == KeyCode.Q) {
				quit = "Quit";
				endGame();
			}
			if (avatar.getShoots()) {
				shoot("avatar", avatar, boss);
			}
		});
		stage.setScene(scene);
		stage.show();
		


		
	}
	public void endGame() {
		if (quit.equals("Won")) {
			menuBox.Win(stage);
		}
		else if (quit.equals("Won Boss")) {
			menuBox.WinBoss(stage);
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

	public void shoot(String type, Avatar_GUI avatar, Boss_GUI boss) {
		Boss_Bullet_GUI bullet;
		if (type == "avatar") {
			bullet = new Boss_Bullet_GUI(bullet_image, 60, 35, avatar.getX_coordinate(), avatar.getY_coordinate(), type); 
		}
		else {
		bullet = new Boss_Bullet_GUI(bullete_image, 50, 35, boss.getX_coordinate(), boss.getY_coordinate() + 30, type); 
		}
		
		pane.getChildren().add(bullet.getIV());
		AnimationTimer bulletTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				bullet.shoot(boss, pane, avatar, heart, boss_heart, this);
				if (heart.getLife() == 0) {
					avatar.delete();
					avatar_dead = true;
				}
				if (boss_heart.getLife() == 0) {
					boss_dead = true;
				}
			}
		};
		bulletTimer.start();
		
	}
	}
