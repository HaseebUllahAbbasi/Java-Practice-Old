package UFO;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Starfield with multiple UFO
 * @author Abdus Sattar Mia
 */
public class TestStarFieldWithUFOs extends Application
{
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
        Starfield starfield = new Starfield(800, 450, 1000);
        UFO[] ufos = new UFO[10];
        for (int i = 0; i < ufos.length; i++) {
            int xs, ys,  r;
            do {
                xs = (int) (Math.random() * 9 - 4);
                ys = (int) (Math.random() * 9 - 4);
                r = (int) (Math.random() * 255);       
            } while (xs == 0 || ys == 0);
            
            ufos[i] = new UFO((int) (Math.random() * 800), (int) (Math.random() * 450), xs, ys, 
                              (int) (Math.random() * 10 + 2), Color.rgb(r, 0, 100));
        }
        starfield.draw(gc);
        while (true) {
            starfield.twinkle();
            for (UFO ufo : ufos) {
                ufo.moveOneStep();
            }
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, 800, 450);
            starfield.draw(gc);
            for (UFO ufo : ufos) {
                ufo.draw(gc);
            }
            pause(50);
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
