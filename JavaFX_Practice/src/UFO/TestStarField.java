package UFO;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Starfield test
 *
 * @author Abdus Sattar Mia
 */
public class TestStarField extends Application {

   
    @Override
    public void start(Stage stage) {
        stage.setTitle("Star Field!"); // window title here
        Canvas canvas = new Canvas(800, 450); // canvas size here
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
        // YOUR CODE HERE!
        Starfield starfield = new Starfield(800, 500, 1000);
        starfield.draw(gc);
        while (true) {
            starfield.twinkle();
            gc.setFill(Color.BLACK);
            gc.fillRect(0,0,800,500);
            starfield.draw(gc);
            pause(25);
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
