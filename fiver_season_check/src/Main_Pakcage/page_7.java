package Main_Pakcage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class page_7
{
    String winter_url = "file:/C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/src/Images/winter.jpg";
    String summer_url = "file:/C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/src/Images/summer.jpg";
    String autumn_url = "file:/C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/src/Images/autumn.jpg";
    String spring_url = "file:/C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/src/Images/spring.jpg";
    @FXML ImageView winter;
    @FXML ImageView summer;
    @FXML ImageView autumn;
    @FXML ImageView spring;

    public void winter(ActionEvent actionEvent)
    {
        winter.setImage(new Image(winter_url));
        summer.setImage(null);
        autumn.setImage(null);
        spring.setImage(null);
    }

    public void summer(ActionEvent actionEvent)
    {

        winter.setImage(null);
        summer.setImage(new Image(summer_url));
        autumn.setImage(null);
        spring.setImage(null);
    }

    public void spring(ActionEvent actionEvent) {

        winter.setImage(null);
        summer.setImage(null);
        autumn.setImage(null);
        spring.setImage(new Image(spring_url));
    }

    public void autumn(ActionEvent actionEvent) {

        winter.setImage(null);
        summer.setImage(null);
        autumn.setImage(new Image(autumn_url));
        spring.setImage(null);
    }

    public void next_page(ActionEvent actionEvent) throws IOException
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("page_9.fxml").openStream());

        Scene scene = new Scene(root);
        primaryStage.setTitle("Page 8");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
