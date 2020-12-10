package pkgMain;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * @version alpha version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is Controller class. 
 * The controller processes and responds to events, 
 * typically user actions, and may invoke changes on the model
 */

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
			System.out.print("go to page#2");
		});
        
        theStage.show();
    }

}
