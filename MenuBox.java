import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuBox {
    private Button b1 = new Button("Quit Game");
    private Button b2 = new Button("Fight Boss");
    Text won = new Text(10, 10, "You Won!");
    Text lost = new Text(10, 10, "You Lost!");
    VBox vbox = new VBox();
    int hearts_Transfered = 0;

    public void Win(Stage window, Heart_GUI heart) {
        vbox.getChildren().add(won);
        vbox.getChildren().add(b1);
        vbox.getChildren().add(b2);
        vbox.setAlignment(Pos.CENTER);
        Stage newstage = new Stage();
        Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
        newstage.setScene(newscene);
        newstage.show();
        hearts_Transfered = heart.getLife();

        b1.setOnAction(e -> {
            window.close();
            newstage.close();
        });
        b2.setOnAction(e -> {
            window.close();
            newstage.close();
            try {
                System.out.println("java BossFight" + hearts_Transfered);
                Process P = Runtime.getRuntime().exec("java BossFight"+ " "+ hearts_Transfered);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

    }

    public void WinBoss(Stage window, Heart_GUI heart) {
        int newScore = (heart.getLife())*100;
        Text score_Text = new Text(10,10, "Score: " + newScore);
        readScore.setScore(newScore);
        vbox.getChildren().add(won);
        vbox.getChildren().add(score_Text);
        vbox.getChildren().add(b1);
        vbox.setAlignment(Pos.CENTER);
        Stage newstage = new Stage();
        Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
        newstage.setScene(newscene);
        newstage.show();

        b1.setOnAction(e -> {
            window.close();
            newstage.close();
        });
    }

    public void Quit(Stage window) {
        vbox.getChildren().add(b1);
        vbox.setAlignment(Pos.CENTER);
        Stage newstage = new Stage();
        Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
        newstage.setScene(newscene);
        newscene.setFill(Color.BLACK);
        newstage.show();

        b1.setOnAction(e -> {
            window.close();
            newstage.close();
        });

    }

    public void Lose(Stage window) {
        vbox.getChildren().add(lost);
        vbox.getChildren().add(b1);
        vbox.setAlignment(Pos.CENTER);
        Stage newstage = new Stage();
        Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
        newstage.setScene(newscene);
        newscene.setFill(Color.BLACK);
        newstage.show();

        b1.setOnAction(e -> {
            window.close();
            newstage.close();
        });

    }
}