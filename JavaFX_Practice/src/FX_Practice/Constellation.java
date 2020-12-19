package FX_Practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Constellation extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(730, 430); // Set canvas Size in Pixels
        stage.setTitle("Night Sky"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //***Code block for a dark blue night sky
        gc.setFill(Color.rgb(0, 0, 21, 1.0));
        gc.fillRect(10, 10, 700, 400);
        //LOOP for generating stars
        for (int i = 1; i <= 700; i++) {
            int xi = (int) (Math.random() * 691 + 10); //Randmoly produced x-coordinate for star
            int yi = (int) (Math.random() * 390 + 10);  //Randmoly produced y-coordinate for star
            int hi = (int) (Math.random() * 3 + 1);   // Height for star
            gc.setFill(Color.WHITE);
            gc.fillOval(xi, yi, hi, hi);   //Randomly generated stars
        }

        //***Code block for an interaction for user input
        Scanner SC = new Scanner(System.in);
        final int X0 = 100;
        final int Y0 = 100;
        int X, Y, choice;

        int previousX = X0;
        int previousY = Y0;
        //do-while LOOP started. 
        do {
            System.out.println("Please enter X between 10 and 700; Y between 0 and 400 for star.");
            X = SC.nextInt(); //User's first valaue will be stores in X
            Y = SC.nextInt(); //User's second valaue will be stores in Y

            //User input validation
            if (X < 10 || X > 700 || Y < 10 || Y > 400) {
                System.out.println("Out of range! Please try again");
            } else {
                gc.setFill(Color.rgb(247, 120, 121));
                gc.fillOval(previousX, previousY, 6, 6); //Produce circle/star with old X, Y value
                gc.fillOval(X, Y, 6, 6);  //Produce circle/star with new X, Y value

                gc.setStroke(Color.RED);
                gc.strokeLine(previousX + 3, previousY + 3, X + 3, Y + 3); //Connecting center of the starts (circles)

                previousX = X;
                previousY = Y;
            }
            //Asking if user want to exit or continue
            System.out.println("Please type 0 to exit or any number to continue");
            choice = SC.nextInt();  //Store integer value in choice variable

            //Code block for a tittle of constellation and program credential 
            if (choice == 0) {
                Scanner input = new Scanner(System.in);
                System.out.println("Give a title of your constellation.");
                String titleName = input.nextLine(); //User title will be stored in the varible 'titleName'
                //Title of constellation 
                gc.setFont(new Font("Monotype Corsiva", 48)); //font set for title
                gc.setStroke(Color.CORAL);    //title color
                gc.strokeText(titleName, 320, 70);
                gc.setFill(Color.CORAL);    //title color
                gc.fillText(titleName, 320, 70);
                
                gc.setFont(new Font("Times New Roman", 14)); 
                gc.setStroke(Color.rgb(204, 255, 51));
                gc.strokeText("Program by Haseeb Ullah.", 500, 380);
                gc.setFill(Color.rgb(204, 255, 51));
                gc.fillText("Program by Haseeb Ullah.", 500, 380);

            }
        } while (choice != 0);

        //***Code block for connecting the last star with first one
        gc.setStroke(Color.RED);
        gc.strokeLine(X0 + 3, Y0 + 3, previousX + 3, previousY + 3);

        FileWriter fw = new FileWriter("src/FX_Practice/moon_1.txt");
        fw.write(1);
        fw.close();
        Image moon = new Image("@../mars.jpg");
        gc.drawImage(moon, 520, 70, 40, 40);

        Image mars = new Image("moon.jpg");
        gc.drawImage(mars, 150, 270, 25, 30);

        stage.show();  //Showing stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
