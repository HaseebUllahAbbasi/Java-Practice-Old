// PolygonTest.java
package FX_Practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonTest extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Polygon triangle1 = new Polygon();
		triangle1.getPoints().addAll(50.0, 0.0,
		                             0.0, 100.0, 
		                             100.0, 100.0);
		triangle1.setFill(Color.VIOLET);
		triangle1.setStroke(Color.RED);

		Polygon parallelogram = new Polygon();
		parallelogram.getPoints().addAll(30.0, 0.0,
		                                 150.0, 0.0, 
		                                 120.00, 80.0, 
		                                 0.0, 80.0);
		parallelogram.setFill(Color.YELLOW);
		parallelogram.setStroke(Color.BLACK);

		Polygon hexagon = new Polygon(120, 0, 
		                             180, 20, 
		                             180, 80, 
		                             120, 100, 
		                             60, 80, 
		                             60, 20);
		hexagon.setFill(Color.LIGHTGREEN);
		hexagon.setStroke(Color.BLACK);

		HBox root = new HBox(triangle1, parallelogram, hexagon);
		Scene scene = new Scene(root, 500, 200);
		stage.setScene(scene);
		stage.setTitle("Using Polygons");
                
                root.setSpacing(30);
		root.setStyle("-fx-padding: 10;" + 
		              "-fx-border-style: solid inside;" + 
		              "-fx-border-width: 2;" +
		              "-fx-border-insets: 5;" + 
		              "-fx-border-radius: 5;" + 
		              "-fx-border-color: blue;");

		stage.show();
	}
}
