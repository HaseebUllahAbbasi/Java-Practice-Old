package FX_Practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Abdus Sattar
 */

public class MultipleBouncingBalls extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bouncing Balls!"); // window title here
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

        // intial positions and speeds
        Ball[] balls = new Ball[20];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(100, 50, Math.random() * 5 - 2, Math.random() * 5 - 2, 20, Color.CORAL);
        }

        while (true) // loop forever
        {
            // draw screen 
            gc.setFill(Color.LIGHTYELLOW);
            gc.fillRect(0, 0, 400, 300);
            for (Ball ball : balls) {
                ball.draw(gc);
            }

            // moving
            for (Ball ball : balls) {
                ball.moveOneStep();
                // bouncing
                if (ball.getX() <= 0 || ball.getX() >= 400 - ball.getSize()) {
                    ball.bounceX();
                }
                if (ball.getY() <= 0 || ball.getY() >= 300 - ball.getSize()) {
                    ball.bounceY();
                }
            }

            // pause
            pause(12);
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
