package Main_Pakcage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneFour implements ViewMaker {
    private Stage stage;
    View view;

    public SceneFour(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    @Override
    public Scene getScene() {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ViewFourController viewFourController = loader.getController();
            viewFourController.stage = this.stage;
            viewFourController.init();
            return  scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
