package Main_Pakcage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * The Third Page View
 * 
 *@author 　Ruoxi Jin
 * @version alpha
 */

public class SceneSix implements ViewMaker {
	
	private Stage theStage;
	View view;
	private ImageView iv1;
    public static List<ImageData> imageDataList;
    public static List<MyImageView> dragImageViewList;
    private ViewSixController imc;
	/** Must inject a stage */
	public SceneSix(Stage theStage, View view) {
		this.theStage = theStage;
		this.view = view;
		iv1 = new ImageView();
        imc = new ViewSixController(this.theStage);
        imageDataList = new ArrayList<>();
        dragImageViewList = new ArrayList<>();
        ImageData imageData1 = new ImageData("commonMilkweed.png", 5);
        ImageData imageData2 = new ImageData("commonMilkweed.png", 4);
        ImageData imageData3 = new ImageData("commonMilkweed.png", 3);
        ImageData imageData4 = new ImageData("commonMilkweed.png", 2);
		ImageData imageData5 = new ImageData("commonMilkweed.png", 5);
		ImageData imageData6 = new ImageData("commonMilkweed.png", 4);
		ImageData imageData7 = new ImageData("commonMilkweed.png", 3);
		ImageData imageData8 = new ImageData("commonMilkweed.png", 2);
        imageDataList.add(imageData1);
        imageDataList.add(imageData2);
        imageDataList.add(imageData3);
        imageDataList.add(imageData4);
		imageDataList.add(imageData5);
		imageDataList.add(imageData6);
		imageDataList.add(imageData7);
		imageDataList.add(imageData8);
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
        rightTop.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;" + "-fx-padding: 2");
        pane.add(rightTop, 25, 0, 90, 10);
        rightTop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label title = new Label("Garden");
        rightTop.getChildren().addAll(title);

        GridPane rightCenter = new GridPane();
        rightCenter.setMouseTransparent(true);
        rightCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");

        for (MyImageView myImageView : SceneThree.dragImageViewList) {
            myImageView.setTranslateX(myImageView.getOffsetX());
            myImageView.setTranslateY(myImageView.getOffsetY());
            rightCenter.add(myImageView, 0, 0);
        }
        pane.add(rightCenter, 25, 10, 90, 90);
        rightCenter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        int colIndex = 0;
        int i = 0;
        for (ImageData imageData : imageDataList) {
            for (int j = 0; j < imageData.getNum(); j++) {
                Image im1 = new Image(getClass().getResourceAsStream(imageData.getPath()));
//                Image im1 = new Image(imageData.getPath());

                MyImageView iv1 = new MyImageView();
                iv1.setImage(im1);
                iv1.setPreserveRatio(true);
                iv1.setFitWidth(50);
                iv1.setFitHeight(50);
                imc.setHandlerForDrag(iv1, rightCenter);
                left.add(iv1, colIndex, i);
            }
            if (colIndex == 0) {
            	colIndex = 1;
			} else {
            	colIndex = 0;
            	i++;
			}
        }
        return new Scene(pane, 850, 700);
	}

}