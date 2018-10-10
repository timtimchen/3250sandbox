//
// Source code created JavaFX 1 in-class activity
// by Tyson Farley and Jinghong Chen
//
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class DieRoller extends Application {

  private Random random = new Random();
  private ArrayList<boolean[]> dieList;


  @Override
  public void start(Stage primaryStage) {

    dieList = new ArrayList<>();
    boolean[] number0 = {true, true, true, true, true, true, false };
    boolean[] number1 = {false, false, true, true, false, false, false };
    boolean[] number2 = {false, true, true, false, true, true, true };
    boolean[] number3 = {false, true, true, true, true, false, true };
    boolean[] number4 = {true, false, true, true, false, false, true };
    boolean[] number5 = {true, true, false, true, true, false, true };
    boolean[] number6 = {true, true, false, true, true, true, true };
    boolean[] number7 = {false, true, true, true, false, false, false };
    boolean[] number8 = {true, true, true, true, true, true, true };
    boolean[] number9 = {true, true, true, true, true, false, true };

    dieList.add(number0);
    dieList.add(number1);
    dieList.add(number2);
    dieList.add(number3);
    dieList.add(number4);
    dieList.add(number5);
    dieList.add(number6);
    dieList.add(number7);
    dieList.add(number8);
    dieList.add(number9);

    ArrayList<Rectangle> rectangles = new ArrayList<>();
    rectangles.add(new Rectangle(30.0, 30.0, 5.0, 70.0));
    rectangles.add(new Rectangle(30.0, 30.0, 50.0, 5.0));
    rectangles.add(new Rectangle(80.0, 32.0, 5.0, 70.0));
    rectangles.add(new Rectangle(80.0, 103.0, 5.0, 70.0));
    rectangles.add(new Rectangle(30.0, 170.0, 50.0, 5.0));
    rectangles.add(new Rectangle(30.0, 100.0, 5.0, 70.0));
    rectangles.add(new Rectangle(30.0, 100.0, 50.0, 5.0));

    Pane pane = new Pane();
    Scene scene = new Scene(pane, 100, 200);
    primaryStage.setTitle("Roll a Die");
    primaryStage.setScene(scene);

    Button rollButton = new Button("roll die");
    rollButton.setOnAction(e -> {
      int ran = random.nextInt(10);
      for (int i = 0; i < 7; i++) {
        pane.getChildren().remove(rectangles.get(i));
        if (dieList.get(ran)[i] == true) {
          rectangles.get(i).setArcHeight(5);
          rectangles.get(i).setArcWidth(5);
          pane.getChildren().add(rectangles.get(i));
        }
      }
    });

    HBox hBox = new HBox(500);
    hBox.getChildren().add(rollButton);
    hBox.setAlignment(Pos.CENTER);

    pane.getChildren().add(hBox);

    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
