package World_App;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;


public class VillageAppTest extends Application {

   
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(800, 500); // Set canvas Size in Pixels
        stage.setTitle("The World of Two Villages"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // CODE STARTS HERE 
        gc.setFill(Color.rgb(155, 202, 100)); // Set background color 
        gc.fillRect(0, 0, 800, 500); //Set background canvas size

        Village v1 = new Village("Silver Village", 40, 40, (int) (Math.random() * 20 + 80)); //Create an object for top village
        Village v2 = new Village("Diamond Village", 100, 300, (int) (Math.random() * 30 + 95)); //Create an object for bottom village
        House king = new House(600, 180);  //Create an object for King's house

        v1.draw(gc);  //Call draw method for top village
        v2.draw(gc);  //Call draw method for bottom village
        king.draw(gc); //Call draw method for Emperor's house
        
        gc.setFill(Color.RED); 
        gc.fillText("King's House", 600, 380);

        // CODE STOPS HERE
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
