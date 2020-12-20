package FX_Practice;

import javafx.animation.TranslateTransition; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.stage.Stage; 
import javafx.util.Duration; 
         
public class TranslateTransit extends Application { 
   @Override 
   public void start(Stage stage) {  
      //Drawing a Circle 
      Circle circle = new Circle(); 
      
      //Setting the position of the circle 
      circle.setCenterX(150.0f); 
      circle.setCenterY(335.0f); 
      
      //Setting the radius of the circle 
      circle.setRadius(60.0f); 
      
      //Setting the color of the circle 
      circle.setFill(Color.BROWN); 
      
      //Setting the stroke width of the circle 
      circle.setStrokeWidth(20); 
       
      //Creating Translate Transition 
      TranslateTransition translateTransition = new TranslateTransition(); 
      
      //Setting the duration of the transition  
      translateTransition.setDuration(Duration.millis(1000)); 
      
      //Setting the node for the transition 
      translateTransition.setNode(circle); 
      
      //Setting the value of the transition along the x axis. 
      translateTransition.setByY(-300); 
      
      //Setting the cycle count for the transition 
      translateTransition.setCycleCount(500); 
      
      //Setting auto reverse value to false 
      translateTransition.setAutoReverse(false); 
      
      //Playing the animation 
      translateTransition.play(); 
         
      //Creating a Group object  
      Group root = new Group(circle); 
      Scene scene = new Scene(root, 700, 500);
      stage.setTitle("Translate transition example"); 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}