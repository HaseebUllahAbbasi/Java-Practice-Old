package FX_Practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Face_Teeth extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(400, 300);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.setTitle("Happy Smile Face");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Code here
        gc.strokeOval(100, 50, 200, 200);  //face
        gc.fillOval(155, 100, 10, 20);   //left eye
        gc.fillOval(230, 100, 10, 20);   //right eye
        gc.strokeArc(150, 160, 100, 50, 180, 180, ArcType.CHORD);  //mouth
        
        //show stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
