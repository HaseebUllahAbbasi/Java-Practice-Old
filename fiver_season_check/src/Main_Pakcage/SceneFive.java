package Main_Pakcage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Creates and returns the scene for the first view.
 *
 * @author 　Xinyi Sun
 * @version alpha
 */
public class SceneFive implements ViewMaker {
    private Stage stage;
    View view;

    public SceneFive(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    @Override
    public Scene getScene() {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s5.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ViewFiveController viewFiveController = loader.getController();
            viewFiveController.stage = stage;
            return  scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
