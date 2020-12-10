package Main_Pakcage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version alpha version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is Controller class. 
 * The controller processes and responds to events, 
 * typically user actions, and may invoke changes on the model
 */

/*
public class Controller extends Application
{
	//data fields hold Model and View
	private Model model;
	private View view;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
	public void start(Stage theStage) {
        view = new View(theStage);
		model = new Model(view.getWidth(), view.getHeight());
		view.setModel(model);
		
		
		
		view.newGarden.setOnAction(e -> {
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("page_7.fxml"));
				Scene scene = new Scene(root);
				theStage.setScene(scene);
				theStage.setTitle("Page 7");
				theStage.show();
			} catch (IOException exception)
			{
				exception.printStackTrace();
			}


		});
        
        theStage.show();
    }

}
*/

public class Controller extends Application implements ViewMaker {
	//data fields hold Model and View
	private Model model;
	private View view;

///////////////////////////////


	/** Holds the various scenes to switch between */
	public static Map<SceneName, Scene> scenes = new HashMap<>();



	public static void main(String[] args) {
		launch(args);
	}

	//method to change scene when pressed
	public void handleOnPressNewGarden(MouseEvent event, Stage theStage) {
		theStage.setScene(scenes.get(SceneName.SCENE1));
	}

	public void handleOnPressNext(MouseEvent event, Stage theStage) {
		theStage.setScene(scenes.get(SceneName.SCENE3));
	}

	public  void goFour(MouseEvent event, Stage theStage){
		theStage.setScene(scenes.get(SceneName.SCENE4));
	}

	public   void goFive(MouseEvent event, Stage theStage){
		theStage.setScene(scenes.get(SceneName.SCENE5));
	}

	public void handleOnPressNextSix(MouseEvent event, Stage theStage, View view) {
		theStage.setScene(new SceneSix(theStage,view).getScene());
	}




	//////////////////////////////////////////////////////////////////////////

	@Override
	public void start(Stage theStage)
	{
		view = new View(theStage);
		model = new Model(view.getWidth(), view.getHeight());
		view.setModel(model);


		// Create and store all scenes up front
		scenes.put(SceneName.MAIN, new StarterView(theStage,view).getScene());
		scenes.put(SceneName.SCENE1, new SceneOne(theStage,view).getScene());
		scenes.put(SceneName.SCENE2, new SceneTwo(theStage,view).getScene());
		scenes.put(SceneName.SCENE3, new SceneThree(theStage,view).getScene());
		scenes.put(SceneName.SCENE4, new SceneFour(theStage,view).getScene());
		scenes.put(SceneName.SCENE5, new SceneFive(theStage,view).getScene());


		scenes.put(SceneName.SCENE6, new SceneSix(theStage,view).getScene());

		//set start Scene
		theStage.setScene(scenes.get(SceneName.MAIN));
		/////////////////////////////////////////////////////////////////////////

		//change to SCENE1 when press New Garden
		view.newGarden.setOnMousePressed(e -> handleOnPressNewGarden(e, theStage));
		view.setUp.setOnMousePressed(e -> handleOnPressNext(e, theStage));



		///ignore this
		view.template.setOnAction(e -> {
			System.out.print("go to template page");
		});

		theStage.show();
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return null;
	}

}
