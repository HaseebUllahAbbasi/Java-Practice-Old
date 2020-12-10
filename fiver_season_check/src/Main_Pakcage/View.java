package Main_Pakcage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


/**
 * @version alpha version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is View class. 
 * The view is the visual representation of the data
 */

public class View{
	
	private Model model;
	
	// value of the height and width of screen
	int canvasHeight = 1200;
	int canvasWidth = 800;
	//Canvas canvas = new Canvas(canvasHeight, canvasWidth);
	
	//TODO I feel like This should be an botton array
	Button newGarden = new Button("New Garden");
	Button template = new Button("Template One");
	Button setUp = new Button("Next");
	////////////////////////////////////////////
	
	/** Holds the various scenes to switch between */
	private static Map<SceneName, Scene> scenes = new HashMap<>();
	
	
	
	public View(Stage theStage) {
//		
//		//Page 1 stage & scene
//		theStage.setTitle("Garden Designer");
//		
//		Group root = new Group();
//		
//		Scene theScene = new Scene(root,canvasHeight,canvasWidth);
//		theScene.setFill(Color.INDIANRED); 
//		theStage.setScene(theScene);
//		
//		//Add Text "garden designer"
//		Text text = new Text();
//		text.setFont(new Font(50));
//		text.setX(50); 
//		text.setY(100);
//		text.setText("Garden Designer");
//		root.getChildren().addAll(text);
//		text.setStrokeWidth(1);
//		text.setStroke(Color.WHITE);
//		
//		//Add Text "Templates"
//		Text text1 = new Text();
//		text1.setFont(new Font(35));
//		text1.setX(60); 
//		text1.setY(430);	
//		text1.setText("Garden Templates");
//		root.getChildren().addAll(text1);
//		
//		/////////////////////////////////
//		
//		//add newGarden Button
//		root.getChildren().addAll(newGarden);
//		// CSS design for newGarden Button
//		newGarden.setStyle("-fx-font-size: 40px");
//		newGarden.setStyle("-fx-background-color: #FAEBD7");
//		newGarden.setWrapText(true);
//		newGarden.setPrefSize(275, 175);
//		newGarden.relocate(80,150);
//		
//		//add newGarden Button
//		root.getChildren().addAll(template);
//		// CSS design for newGarden Button
//		template.setStyle("-fx-font-size: 40px");
//		template.setStyle("-fx-background-color: #FFFFF0");
//		template.setWrapText(true);
//		template.setPrefSize(230, 150);
//		template.relocate(100,500);
//				
		
	}
	
	
	
	
	//getter and setter
	public int getWidth() {
		return canvasWidth;
	}

	public int getHeight() {
		return canvasHeight;
	}
	
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
		

}
