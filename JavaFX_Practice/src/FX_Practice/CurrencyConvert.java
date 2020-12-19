package FX_Practice;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class CurrencyConvert extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 100); // Set canvas Size in Pixels
        root.getChildren().add(canvas);  //Add canvas to the stage
        stage.setScene(scene);   //set scene
        stage.setTitle("CAD to Pound Sterling"); // Window title
        GraphicsContext gc = canvas.getGraphicsContext2D();  // object for 2d graphics

        // YOUR STUFF GOES HERE
        final double RATE = 0.57; // 1 CAD = 0.57 British Pound

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an amount in CAD: $");
        double cad = sc.nextDouble();
        double uk = cad * RATE;
        String output = String.format("$%.2f = £%.2f", cad, uk);

        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 600, 100);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("System", 40));
        gc.fillText(output, 20, 55);    //display output string

        gc.setLineWidth(10);
        gc.setStroke(Color.DARKGREY);
        gc.strokeLine(10, 10, 590, 10); //top line
        gc.strokeLine(10, 70, 590, 70);  //bottom line

        //stage
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
