package FX_Practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HappyFaceAnimation extends Application {

   
    @Override
    public void start(Stage stage) {
        
        Canvas canvas = new Canvas(500, 500); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Happy Face Animation"); // window here
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Thread t = new Thread(() -> animate(gc));
        t.start();
    }

    public void animate(GraphicsContext gc) {
       
        for (int x = -210; x <= 510; x++) {
            gc.clearRect(0, 0, 500, 500);
            gc.setFont(Font.font("System", 30));
            gc.setLineWidth(1);
            gc.setStroke(Color.rgb(128, 0, 0));
            gc.strokeText("Happy Happy Happy Happy!", 10, 100);
            drawFace(gc, x, 50, Color.rgb(200, 100, 10));
            drawFace(gc, 190 - x, 180, Color.RED);
            drawFace(gc, 50, x, Color.GREEN);
            drawFace(gc, 150, 210 - x, Color.YELLOW);
            pause(10);
        }
       
       
    }

    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

   
    public void drawFace(GraphicsContext gc, double x, double y, Color color) {
        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.fillOval(x, y, 200, 200);
        gc.strokeOval(x, y, 200, 200);
        gc.setFill(Color.WHITE);
        gc.fillOval(x + 55, y + 50, 10, 20);
        gc.fillOval(x + 130, y + 50, 10, 20);
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3.5);
        gc.strokeArc(x + 50, y + 110, 100, 50, 180, 180, ArcType.OPEN);
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
