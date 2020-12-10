package Main_Pakcage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Starter Page View
 * Let user choose to whether start a new garden or choose a garden from template
 * 
 * @author 　Weitong Sun
 * @version alpha
 */

public class StarterView implements ViewMaker {
	
	private Stage theStage;
	View view;
	
	
	/** Must inject a stage */
	public StarterView(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	@Override
	public Scene getScene() {
		
		//Page 1 stage & scene
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
		//System.out.println("11111");
	
		Scene theScene = new Scene(root,view.canvasHeight,view.canvasWidth);
		//System.out.println("22222");
		theScene.setFill(Color.INDIANRED); 
		theStage.setScene(theScene);
				
		//Add Text "garden designer"
		Text text = new Text();
		text.setFont(new Font(50));
		text.setX(50); 
		text.setY(100);
		text.setText("Garden Designer");
		root.getChildren().addAll(text);
		text.setStrokeWidth(1);
		text.setStroke(Color.WHITE);
				
		//Add Text "Templates"
		Text text1 = new Text();
		text1.setFont(new Font(35));
		text1.setX(60); 
		text1.setY(430);	
		text1.setText("Garden Templates");
		root.getChildren().addAll(text1);
				
		/////////////////////////////////
		
		//add newGarden Button
		root.getChildren().addAll(view.newGarden);
		// CSS design for newGarden Button
		view.newGarden.setStyle("-fx-font-size: 40px");
		view.newGarden.setStyle("-fx-background-color: #FAEBD7");
		view.newGarden.setWrapText(true);
		view.newGarden.setPrefSize(275, 175);
		view.newGarden.relocate(80,150);
				
		//add newGarden Button
		root.getChildren().addAll(view.template);
		// CSS design for newGarden Button
		view.template.setStyle("-fx-font-size: 40px");
		view.template.setStyle("-fx-background-color: #FFFFF0");
		view.template.setWrapText(true);
		view.template.setPrefSize(230, 150);
		view.template.relocate(100,500);
		
		return theScene;
	}

}
