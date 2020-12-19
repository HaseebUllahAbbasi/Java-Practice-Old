package FX_Practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SimpleAnimation extends Application {

   
    @Override
    public void start(Stage stage) {
        stage.setTitle("Animation Example"); // window title here
        Canvas canvas = new Canvas(400, 300); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // This code starts a "thread" which will run your animation
        Thread t = new Thread(() -> animate(gc));
        t.start();
    }

    public void animate(GraphicsContext gc) {
        for (int x = -200; x <= 500; x++) {
            // clear the screen to ALICEBLUE
            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, 400, 300);

            // Draws the unchanging parts
            gc.setFont(Font.font("System", 30));
            gc.setLineWidth(1); //make font thicker
            gc.setFill(Color.rgb(128, 0, 0)); //set text color
            gc.fillText("Animation is Fun!!!", 20, 55);

            // Draws the changing part 
            gc.setFill(Color.BURLYWOOD);
            gc.fillOval(x, 100, 100, 100);

            // Slight pause
            pause(2);
        }
    }

    
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

  
    @Override
    public void stop() {
        System.exit(0);
    }

   
    public static void main(String[] args) {
        launch(args);
    }
}
