package Main_Pakcage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Third Page View
 *
 */

public class SceneTwo implements ViewMaker {
	
	private Stage theStage;
	View view;
	
	
	/** Must inject a stage */
	public SceneTwo(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
	}
	
	@Override
	public Scene getScene() {
		
		theStage.setTitle("Garden Designer");
		
		Group root = new Group();
		
		Scene theScene = new Scene(root,view.canvasHeight,view.canvasWidth);
		
		//theScene.setFill(Color.INDIANRED); 
		theStage.setScene(theScene);
				
		
		
		return theScene;
	}

}