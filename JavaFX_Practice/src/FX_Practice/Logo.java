package FX_Practice;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;




public class Logo extends Application {

   
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 380); // Set canvas Size in Pixels
        stage.setTitle("JavaFX Logo"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Draw a rectangle
        gc.setFill(Color.rgb(180, 0, 40));
        gc.fillRect(30, 30, 520, 300);

        gc.setFont(new Font("Monotype Corsiva", 32));
        gc.setStroke(Color.rgb(255, 255, 255));
        gc.strokeText("JavaFX 8: Creating Apps", 150, 285);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.fillText("JavaFX 8: Creating Apps", 150, 285);

        gc.setFont(new Font("Times New Roman", 18));
        gc.setStroke(Color.rgb(51, 102, 255));
        gc.strokeText(" - Haseeb Ullah ", 358, 320);
        gc.setFill(Color.rgb(51, 102, 255));
        gc.fillText(" - Haseeb Ullah", 358, 320);

        //Set a circle around the cup and plate
        gc.setFill(Color.WHITE);
        gc.fillOval(195, 80, 170, 170);

        gc.setFill(Color.rgb(180, 0, 40));
        gc.fillArc(245, 111, 60, 80, 0, -180, ArcType.CHORD); //Code for producing cup
        gc.fillArc(290, 158, 20, 20, -110, 240, ArcType.CHORD); //Code for handle
        gc.fillArc(235, 186, 80, 10, 0, -180, ArcType.CHORD); //Code for plate

        //Code for heat spread
        gc.fillArc(277, 128, 10, 30, 140, 70, ArcType.CHORD);
        gc.fillArc(270, 121, 10, 30, 160, 70, ArcType.CHORD);
        gc.fillArc(287, 124, 10, 30, 140, 70, ArcType.CHORD);
        gc.fillArc(261, 121, 10, 30, 160, 70, ArcType.CHORD);
        gc.fillArc(275, 101, 10, 30, 140, 59, ArcType.CHORD);
        gc.fillArc(270, 105, 10, 30, 160, 56, ArcType.CHORD);
        gc.fillArc(286, 109, 10, 30, 130, 54, ArcType.CHORD);
        gc.fillArc(259, 106, 10, 30, 160, 50, ArcType.CHORD);

        //Show stage
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
