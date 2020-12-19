package FX_Practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ArcTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // An OPEN arc with a fill
        Arc arc1 = new Arc(0, 0, 50, 120, 0, 90);
        arc1.setFill(Color.LIGHTGRAY);

        // An OPEN arc with no fill and a stroke
        Arc arc2 = new Arc(0, 0, 50, 120, 0, 90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);

        // A CHORD arc with no fill and a stroke
        Arc arc3 = new Arc(0, 0, 50, 120, 0, 90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.BLACK);
        arc3.setType(ArcType.CHORD);

        // A ROUND arc with no fill and a stroke
        Arc arc4 = new Arc(0, 0, 50, 120, 0, 90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.BLACK);
        arc4.setType(ArcType.ROUND);

        // A ROUND arc with a gray fill and a stroke
        Arc arc5 = new Arc(0, 0, 50, 120, 0, 90);
        arc5.setFill(Color.GRAY);
        arc5.setStroke(Color.BLACK);
        arc5.setType(ArcType.ROUND);

        HBox root = new HBox(arc1, arc2, arc3, arc4, arc5);
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        stage.setTitle("Different Arcs");

        root.setSpacing(20);
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        stage.show();
    }
}
