package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Chose_Ship_Placement
{
    @FXML RadioButton random;
    @FXML RadioButton using_filing;
    private Alert alert;

    public void back_to_screen(ActionEvent actionEvent) throws IOException
    {

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Selection_Screen.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void apply(ActionEvent actionEvent)
    {
        if(using_filing.isSelected())
        {
            Game_Screen.random_data = false;
            alert = new Alert(Alert.AlertType.INFORMATION, "Now Ships Placement is Done Using Filing", ButtonType.OK);
            alert.showAndWait();
        }
        else
        {
            alert = new Alert(Alert.AlertType.INFORMATION, "Now Ships Placement is Done Randomly", ButtonType.OK);
            alert.showAndWait();
            Game_Screen.random_data = true;
        }

    }
}
