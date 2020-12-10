package Main_Pakcage;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Set;

public class ViewFourController {
    @FXML
    private Pane imgPane;


    public Stage stage;

    Controller controller = new Controller();

    public  void init(){
        Set<Node> imageViews = imgPane.lookupAll("ImageView");
        Iterator<Node> iterator = imageViews.iterator();
        while (iterator.hasNext()){
            ImageView imageView = (ImageView) iterator.next();
            imageView.setOnMouseClicked(e->{

                System.out.println(1111);
                controller.goFive(e,stage);
            });
        }
    }

}
