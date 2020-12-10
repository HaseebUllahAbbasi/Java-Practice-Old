package Main_Pakcage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Second Page View
 * Let user choose to setup their garden
 * 
 * @author 　Weitong Sun
 * @version alpha
 */

public class SceneOne implements ViewMaker {
	
	private Stage theStage;
	View view;
	
	
	/** Must inject a stage */
	public SceneOne(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	@Override
	public Scene getScene() {
		
		//Page 2 stage & scene
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
	
		Scene theScene = new Scene(root,view.canvasHeight,view.canvasWidth);
		theScene.setFill(Color.INDIANRED); 
		theStage.setScene(theScene);
				
		//Add Text "garden designer"
		Text text = new Text();
		text.setFont(new Font(50));
		text.setX(50); 
		text.setY(100);
		text.setText("Setup your Garden");
		root.getChildren().addAll(text);
		text.setStrokeWidth(1);
		text.setStroke(Color.WHITE);
		
		//add text "Width"
		Text width = new Text();
		width.setFont(new Font(15));
		width.setX(50);
		width.setY(200);
		width.setText("Width: ");
		root.getChildren().addAll(width);
		//add text "Height"
		Text height = new Text();
		height.setFont(new Font(15));
		height.setX(50);
		height.setY(300);
		height.setText("Height: ");
		root.getChildren().addAll(height);
		/////////////////////////////////
		
		//input Width
		TextField widthIn = new TextField();  
		root.getChildren().addAll(widthIn);
		widthIn.setLayoutX(180);
		widthIn.setLayoutY(190);
		
		//input Height
		TextField heightIn = new TextField();  
		root.getChildren().addAll(heightIn);
		heightIn.setLayoutX(180);
		heightIn.setLayoutY(290);
		
		
		//Add setup button to go to next scene
		root.getChildren().addAll(view.setUp);
		view.setUp.setStyle("-fx-font-size: 40px");
		view.setUp.setStyle("-fx-background-color: #FFFFF0");
		view.setUp.setWrapText(true);
		view.setUp.setPrefSize(150, 150);
		view.setUp.relocate(400,400);
		
		return theScene;
	}

}

