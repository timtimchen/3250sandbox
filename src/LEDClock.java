//
// Source code created JavaFX 2 in-class activity
// by Tyson Farley and Jinghong Chen
//

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LEDClock extends Application {
  private int hour;
  private int minute;
  private int second;

  public LEDClock() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);

  }

  private class LEDPane extends Pane {
    private ArrayList<boolean[]> LEDList;
    private ArrayList<Rectangle> rectangles;

    public LEDPane(double x, double y, int d) {
      LEDList = new ArrayList<>();
      boolean[] number0 = {true, true, true, true, true, true, false};
      boolean[] number1 = {false, false, true, true, false, false, false};
      boolean[] number2 = {false, true, true, false, true, true, true};
      boolean[] number3 = {false, true, true, true, true, false, true};
      boolean[] number4 = {true, false, true, true, false, false, true};
      boolean[] number5 = {true, true, false, true, true, false, true};
      boolean[] number6 = {true, true, false, true, true, true, true};
      boolean[] number7 = {false, true, true, true, false, false, false};
      boolean[] number8 = {true, true, true, true, true, true, true};
      boolean[] number9 = {true, true, true, true, true, false, true};

      LEDList.add(number0);
      LEDList.add(number1);
      LEDList.add(number2);
      LEDList.add(number3);
      LEDList.add(number4);
      LEDList.add(number5);
      LEDList.add(number6);
      LEDList.add(number7);
      LEDList.add(number8);
      LEDList.add(number9);

      rectangles = new ArrayList<>();
      rectangles.add(new Rectangle(x, y, 5.0, 70.0));
      rectangles.add(new Rectangle(x, y, 50.0, 5.0));
      rectangles.add(new Rectangle(x + 50.0, y + 2.0, 5.0, 70.0));
      rectangles.add(new Rectangle(x + 50.0, y + 73.0, 5.0, 70.0));
      rectangles.add(new Rectangle(x, y + 140.0, 50.0, 5.0));
      rectangles.add(new Rectangle(x, y + 70.0, 5.0, 70.0));
      rectangles.add(new Rectangle(x, y + 70.0, 50.0, 5.0));

      showDigit(d);
    }

    public void showDigit(int digit) {
      for (int i = 0; i < 7; i++) {
        this.getChildren().remove(rectangles.get(i));
        if (LEDList.get(digit)[i]) {
          rectangles.get(i).setArcHeight(5);
          rectangles.get(i).setArcWidth(5);
          this.getChildren().add(rectangles.get(i));
        }
      }
    }
  }

  @Override
  public void start(Stage primaryStage) {

    StackPane rootPane = new StackPane();
    Scene scene = new Scene(rootPane, 620, 280);

    LEDPane pane1 = new LEDPane(80.0, 30.0, hour / 10);
    LEDPane pane2 = new LEDPane(160.0, 30.0, hour % 10);
    LEDPane pane3 = new LEDPane(280.0, 30.0, minute / 10);
    LEDPane pane4 = new LEDPane(360.0, 30.0, minute % 10);
    LEDPane pane5 = new LEDPane(480.0, 30.0, second / 10);
    LEDPane pane6 = new LEDPane(560.0, 30.0, second % 10);
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      second++;
      if (second >= 60) {
        second = 0;
        minute++;
        if (minute >= 60) {
          minute = 0;
          hour++;
          if (hour >= 24) {
            hour = 0;
          }
        }
      }
      pane1.showDigit(hour / 10);
      pane2.showDigit(hour % 10);
      pane3.showDigit(minute / 10);
      pane4.showDigit(minute % 10);
      pane5.showDigit(second / 10);
      pane6.showDigit(second % 10);
    };

    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation

    Pane buttonPane = new Pane();

    Button resetButton = new Button("Reset");
    resetButton.setOnAction(e -> {
      hour = 0;
      minute = 0;
      second = 0;
      pane1.showDigit(hour / 10);
      pane2.showDigit(hour % 10);
      pane3.showDigit(minute / 10);
      pane4.showDigit(minute % 10);
      pane5.showDigit(second / 10);
      pane6.showDigit(second % 10);
    });

    Label labelHrs = new Label("Hours");
    Label labelMin = new Label("Minutes");
    Label labelSec = new Label("Seconds");

    TextField textFieldHrs = new TextField ();
    TextField textFieldMin = new TextField ();
    TextField textFieldSec = new TextField ();


    textFieldHrs.setPrefWidth(50);
    textFieldMin.setPrefWidth(50);
    textFieldSec.setPrefWidth(50);

    Button setTimeButton = new Button("Set time");
    setTimeButton.setOnAction(e -> {
      String hrs = textFieldHrs.getText();
      String min = textFieldMin.getText();
      String sec = textFieldSec.getText();

      hour = hrs != null && !hrs.isEmpty() && Integer.parseInt(hrs) < 24 ?
        Integer.parseInt(hrs) : 0;

      minute  = min != null && !min.isEmpty() && Integer.parseInt(min) < 60 ?
        Integer.parseInt(min) : 0;

      second = sec != null && !sec.isEmpty() && Integer.parseInt(sec) < 60 ?
        Integer.parseInt(sec) : 0;

//            hour = 0;
//            minute = 0;
//            second = 0;
      pane1.showDigit(hour / 10);
      pane2.showDigit(hour % 10);
      pane3.showDigit(minute / 10);
      pane4.showDigit(minute % 10);
      pane5.showDigit(second / 10);
      pane6.showDigit(second % 10);
    });

    buttonPane.getChildren().addAll(
      resetButton, setTimeButton,
      textFieldHrs, textFieldMin, textFieldSec,
      labelHrs, labelMin, labelSec
    );

    textFieldHrs.setLayoutX(10);
    textFieldMin.setLayoutX(10);
    textFieldSec.setLayoutX(10);

    textFieldHrs.setLayoutY(50);
    textFieldMin.setLayoutY(105);
    textFieldSec.setLayoutY(160);

    labelHrs.setLayoutX(17);
    labelMin.setLayoutX(14);
    labelSec.setLayoutX(13);

    labelHrs.setLayoutY(30);
    labelMin.setLayoutY(85);
    labelSec.setLayoutY(140);


    resetButton.setPrefSize(100, 20);
    resetButton.setLayoutX(160); // Sets the X co-ordinate
    resetButton.setLayoutY(220); // Sets the Y co-ordinate

    setTimeButton.setLayoutY(200);
    setTimeButton.setLayoutX(5);

    //create the dots for the clock
    //Circle(double centerX, double centerY, double radius, Paint fill)
    Pane dotPane = new Pane();
    Circle dot1 = new Circle(250, 80, 5, Color.BLACK);
    Circle dot2 = new Circle(250, 120, 5, Color.BLACK);
    Circle dot3 = new Circle(450, 80, 5, Color.BLACK);
    Circle dot4 = new Circle(450, 120, 5, Color.BLACK);
    dotPane.getChildren().addAll(dot1, dot2, dot3, dot4);

    rootPane.getChildren().addAll(pane1, pane2, pane3, pane4, pane5, pane6, dotPane, buttonPane);

    primaryStage.setTitle("LED Clock");
    primaryStage.setWidth(680);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
