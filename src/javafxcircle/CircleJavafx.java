package javafxcircle;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.util.Duration;

public class CircleJavafx extends Application {

//	In the below code there are some missing places. Copy and paste the below code to a text file and complete the code according to the given comments. Then, send the completed file from the system.
//
//	The output of the application is given as an attachment:

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		double width = 600;
		double height = 600;
		Scene scene = new Scene(pane, width, height);
		double radius = Math.min(width, height) * 0.25;
		Circle c = new Circle(width / 2, height / 2, radius, Color.TRANSPARENT);
		c.setStroke(Color.RED);
		c.setRotate(180);
		Text text = new Text("Ad Soyad");
		Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 24);
		text.setFont(font);

		// 1. Create a path transition with the following properties:
		// 1.1. Set the duration of this animation as 10000
		var ptr = new PathTransition();
		ptr.setDuration(Duration.millis(10000));
		// 1.2. The path will be the circle
		ptr.setPath(c);
		// 1.3. The node will be the text
		ptr.setNode(text);
		// 1.4. The animation will cycle indefinite number of cycles
		// indefinite number of cycles
		ptr.setCycleCount(Timeline.INDEFINITE);

		ptr.setAutoReverse(true);
		ptr.play();

		// 2. Create a fade transition on the text with the following properties:
		FadeTransition fade = new FadeTransition();

		// 2.1. Set the duration of this animation as 5000
		fade.setDuration(Duration.millis(5000));

		// 2.2. The animation fade value will change from 1.0 to 0.0
		fade.setFromValue(1.0);
		fade.setToValue(0.0);
		// 2.3. The animationwill automatically reverse
		fade.setAutoReverse(true);

		// 2.4. The animation will cycle indefinite number of cycles
		fade.setCycleCount(Timeline.INDEFINITE);
		fade.setNode(text);

		fade.play();
		// 3. When the mouse is pressed on the pane both of the animations should pause
		EventHandler<javafx.scene.input.MouseEvent> pause = new EventHandler<javafx.scene.input.MouseEvent>() {

			@Override
			public void handle(javafx.scene.input.MouseEvent e) {

				fade.pause();
				ptr.pause();
				System.out.println("paused");
			}
		};

		pane.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, pause);

		// 4. When the mouse is released from the pane both of the animations should
		EventHandler<javafx.scene.input.MouseEvent> play = new EventHandler<javafx.scene.input.MouseEvent>() {

			@Override
			public void handle(javafx.scene.input.MouseEvent e) {

				fade.play();
				ptr.play();
				System.out.println("replay");

			}
		};
		pane.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_RELEASED, play);
		// continue to play

		pane.getChildren().addAll(text, c);
		primaryStage.setScene(scene);
		primaryStage.setTitle("WEEK 12 HW");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}