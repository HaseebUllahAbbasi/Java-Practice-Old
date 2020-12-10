package Main_Pakcage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates and returns the scene for the first view.
 *
 * @author 　Xinyi Sun
 * @version alpha
 */
public class SceneThree implements ViewMaker {
    private ViewThreeController imc;
    private ImageView iv1;
    public static List<ImageData> imageDataList  = new ArrayList<>();
    public static List<MyImageView> dragImageViewList  = new ArrayList<>();
    private Stage stage;
    View view;
    /**
     * Must inject a stage
     */
    public SceneThree(Stage theStage, View view) {
        this.stage = theStage;
        this.view = view;
        iv1 = new ImageView();
        imc = new ViewThreeController(this.stage);
        ImageData imageData1 = new ImageData("commonMilkweed.png", 5);
        ImageData imageData2 = new ImageData("pool.png", 4);
        ImageData imageData3 = new ImageData("fence.png", 6);
        imageDataList.add(imageData1);
        imageDataList.add(imageData2);
        imageDataList.add(imageData3);
        
    }

    @Override
    public Scene getScene() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.setStyle("-fx-background-color: lightblue;");


        GridPane left = new GridPane();
        left.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        pane.add(left, 0, 0, 20, 100);
        left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        GridPane rightTop = new GridPane();
        rightTop.setStyle("-fx-background-color: white;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        pane.add(rightTop, 25, 0, 90, 20);
        rightTop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        for (int i = 0; i < 6; i++) {
            Image im1 = new Image("file: C:\\Users\\PeaceSeeker\\Documents\\IdeaProjects\\fiver_season_check\\src\\Main_Pakcage\\commonMilkweed.png");
            ImageView iv1 = new ImageView();
            iv1.setImage(im1);
            iv1.setPreserveRatio(true);
            iv1.setFitHeight(100);
            iv1.setFitWidth(150);
            rightTop.add(iv1, i, 0);
        }


        GridPane rightCenter = new GridPane();
        rightCenter.setMouseTransparent(true);
        rightCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        pane.add(rightCenter, 25, 20, 90, 75);
        rightCenter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        int imageSize = imageDataList.size();
        for (int i = 0; i < imageSize; i++) {
            ImageData imageData = imageDataList.get(i);
            for (int j = 0; j < imageData.getNum(); j++) 
            {
                System.out.println(imageData.getPath());
                Image im1 = new Image(getClass().getResourceAsStream(imageData.getPath()));
//                Image im1 = new Image(imageData.getPath());
                MyImageView iv1 = new MyImageView();
                iv1.setStyle("-fx-background-color: black;");
                iv1.setImage(im1);
                iv1.setPreserveRatio(true);
                iv1.setFitWidth(150);
                iv1.setFitHeight(150);
                imc.setHandlerForDrag(iv1, rightCenter);
                left.add(iv1, 0, i);
            }
        }




        HBox rightBottom = new HBox();
        rightBottom.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
        pane.add(rightBottom, 25, 95, 90, 5);
        rightBottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label label = new Label("Your Location");
        TextField textField = new TextField();
        Button button = new Button("next page");
		
		 Controller controller = new Controller();
//		 button.setOnMousePressed(e -> controller.handleOnPressNextSix(e, this.stage,view));
		 button.setOnMousePressed(e -> controller.goFour(e, this.stage));

        rightBottom.getChildren().addAll(label,textField,button);
        rightBottom.setSpacing(20);
        return new Scene(pane, 850, 700);
    }
}
