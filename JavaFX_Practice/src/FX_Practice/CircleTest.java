// CircleTest.java
package FX_Practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleTest extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// centerX=0, centerY=0, radius=70, fill=LIGHTGRAY, stroke=null
		Circle c1 = new Circle(0, 0, 70);
		c1.setFill(Color.LIGHTGREEN);
	
		// centerX=10, centerY=10, radius=70. fill=YELLOW, stroke=BLACK
		Circle c2 = new Circle(10, 10, 70, Color.RED);
		c2.setStroke(Color.BLACK);
		c2.setStrokeWidth(2.0);

		HBox root = new HBox(c1, c2);
		Scene scene = new Scene(root, 400, 200);
		stage.setScene(scene);
		stage.setTitle("Circles");
                
                root.setSpacing(50);
		root.setStyle("-fx-padding: 10;" + 
		              "-fx-border-style: solid inside;" + 
		              "-fx-border-width: 2;" +
		              "-fx-border-insets: 5;" + 
		              "-fx-border-radius: 5;" + 
		              "-fx-border-color: blue;");

		stage.show();	
	}
}
