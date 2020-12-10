package Main_Pakcage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFiveController {

    public Stage stage;

    Controller controller = new Controller();

    public void back(MouseEvent mouseEvent) {
        FXMLLoader loader = FxUtils.getLoader("/fxml/s4.fxml");
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ViewFourController viewFourController = loader.getController();
            viewFourController.init();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
