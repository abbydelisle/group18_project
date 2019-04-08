import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BossFight extends Application {
	Stage stage;
	Scene scene;
	boolean avatar_dead = false;
	boolean boss_dead = false;
	String quit = "Quit";
	static Image heart_image;
    static Image avatar_image;
	static Image background;
	static ImageView background_Iv;
    static Avatar_GUI avatar;
    static Heart_GUI heart;
    static Image bullet_image;
    static Image bullet_Enemy_Image;


	Pane pane = new Pane();
    public static String hearts_Transferred;
	Image boss_image;
	Boss_GUI boss;
	Heart_GUI boss_heart;
	MenuBox menuBox;

    public static void setHearts(String num_hearts) {
        hearts_Transferred = num_hearts;
    }
    public String getHearts() {
        return hearts_Transferred;
    }

	public static void main(String[] args) {
        setHearts(args[0]);
        launch(args);
	}

	@Override
	public void start(Stage stage) {
		boolean images_exist = true;
    	try {
    		createImages();
    	} catch (Exception e) {
    		images_exist = false;
    	}
    	if (images_exist) {
    		boss_heart = new Heart_GUI(heart_image);
    		boss = new Boss_GUI(boss_image, 100, 100, 400, 500);
		heart = new Heart_GUI(heart_image);
		menuBox = new MenuBox();
		avatar = new Avatar_GUI(avatar_image, 60, 60, 265, 700);
		this.stage = stage;
		stage.setTitle("Space Invaders Boss Fight");
		pane.getChildren().addAll(background_Iv);
		pane.getChildren().add(avatar.getIV());
		pane.getChildren().add(boss.getImageView());
		AnimationTimer eTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
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
				if (boss.enemyShoot()) {
					shoot("enemy" + 1, avatar, boss);
				}

			}
		};
		eTimer.start();
        heart.setLife(Integer.parseInt(getHearts()));
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
    	else {
    		Platform.exit();
    	}


	}

	public void endGame() {
		if (quit.equals("Won")) {
			menuBox.Win(stage, heart);
		} else if (quit.equals("Won Boss")) {
			menuBox.WinBoss(stage,heart);
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
    public void createImages() {
    	boss_image = new Image("boss.png");
        avatar_image = new Image("avatar.png");  
        //https://wallimpex.com/super-mario-galaxy-backgrounds/5510708.html
        background = new Image("background.jpg");
        heart_image = new Image("heart.png");
        bullet_image = new Image("mario1.gif");
        bullet_Enemy_Image = new Image("luigi1.gif");
        background_Iv = new ImageView(background);
        

    }


	public void shoot(String type, Avatar_GUI avatar, Boss_GUI boss) {
		Boss_Bullet_GUI bullet;
		if (type.equals("avatar")) {
			bullet = new Boss_Bullet_GUI(bullet_image, 60, 35, avatar.getX_coordinate(), avatar.getY_coordinate(), type);
		} else {
			bullet = new Boss_Bullet_GUI(bullet_Enemy_Image, 50, 35, boss.getX_coordinate(), boss.getY_coordinate() + 30, type);
		}

		pane.getChildren().add(bullet.getImageView());
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
					stop();
				}
			}
		};
		bulletTimer.start();

	}
}
