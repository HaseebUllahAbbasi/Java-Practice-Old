package FX_Practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * @author Haseeb Ullah
 */
public class FireWorks extends Application {
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Fireworks"); // window title here
        Canvas canvas = new Canvas(600, 400); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        // This code starts a "thread" which will run your animation
        Thread t = new Thread(() -> animate(graphicsContext));
        t.start();
    }
    public void animate(GraphicsContext graphicsContext)
    {
        final int NUM_FLASHES = 3;      // number of times to flash the opening text
        final int EXPLODE_HEIGHT = 150; // the y coordinate where the rocket explodes
        final int PARTICLE_SIZE = 10;    // size of the explosion particles
        final int NUM_EXPLOSIONS = 20;  // number of explosions after the first one
        final int MAX_SIZE = 70;        // size of the explosions
        final int WIDTH = 600;
        final int HEIGHT = 400;

        int x, y, red, blue, green; // positions and colors
        int count;                  // loop counter
        int offSet;                 // counter for processing explosions

        // ***** clear screen
        graphicsContext.setFill(Color.CHOCOLATE);
        graphicsContext.fillRect(0, 0, 600, 400);

        // ***** FLASH INTRO TEXT
        count = 0;
        while (count < NUM_FLASHES)
        {
            graphicsContext.setFont(new Font("Courier New", 50));
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillText("Fireworks!", WIDTH / 2 - 150, HEIGHT / 2);
            pause(500);
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(0, 0, 600, 400);
            pause(500);
            count = count + 1;
        }
        // ***** ROCKET ANIMATION
        y = HEIGHT;
        while (y > EXPLODE_HEIGHT)
        {
            graphicsContext.setFill(Color.BLUE);
            // when creating animations, you must "synchronize" the access to
            // the buffer object to avoid screen flicker.
            graphicsContext.fillOval(WIDTH / 2, y, 10, 30);
            pause(5);
            graphicsContext.setFill(Color.PINK);
            graphicsContext.fillRect(0, 0, 600, 400);
            y = y - 1;
        }
        // ***** EXPLOSION ANIMATION
        offSet = 0;
        while (offSet < MAX_SIZE)
        {
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillOval(WIDTH / 2 + offSet, EXPLODE_HEIGHT + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2 + offSet, EXPLODE_HEIGHT - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2 - offSet, EXPLODE_HEIGHT + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2 - offSet, EXPLODE_HEIGHT - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2, EXPLODE_HEIGHT + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2, EXPLODE_HEIGHT - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2 + offSet, EXPLODE_HEIGHT, PARTICLE_SIZE, PARTICLE_SIZE);
            graphicsContext.fillOval(WIDTH / 2 - offSet, EXPLODE_HEIGHT, PARTICLE_SIZE, PARTICLE_SIZE);
            pause(5);
            graphicsContext.setFill(Color.LIGHTCYAN);
            graphicsContext.fillRect(0, 0, 600, 400);
            offSet = offSet + 1;
        }

        // ***** PAUSE
        pause(1000);

        // ***** MULTIPLE EXPLOSIONS
        //       Note: Contains a nested while loop
        count = 0;
        while (count < NUM_EXPLOSIONS)
        { // outer loop - once per explosion
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            red = (int) (Math.random() * 128) + 127;
            green = (int) (Math.random() * 128) + 127;
            blue = (int) (Math.random() * 128) + 127;

            offSet = 0;
            while (offSet < MAX_SIZE)
            { // inner loop moves the particles for each explosion
                graphicsContext.setFill(Color.rgb(red, green, blue));
                graphicsContext.fillOval(x + offSet, y + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x + offSet, y - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x - offSet, y + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x - offSet, y - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x, y + offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x, y - offSet, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x + offSet, y, PARTICLE_SIZE, PARTICLE_SIZE);
                graphicsContext.fillOval(x - offSet, y, PARTICLE_SIZE, PARTICLE_SIZE);
                pause(5);
                graphicsContext.setFill(Color.GRAY);
                graphicsContext.fillRect(0, 0, 600, 400);
                offSet = offSet + 1;
            }
            count = count + 1;
            pause(50);
        }
        pause(1000);
        System.exit(0);
    }

    public static void pause(int duration) { try {Thread.sleep(duration);} catch (InterruptedException ex) {} }
    @Override
    public void stop() { System.exit(0); }
    public static void main(String[] args) { launch(args); }
}

