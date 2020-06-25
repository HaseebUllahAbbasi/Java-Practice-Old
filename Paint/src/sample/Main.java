package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);

        gc.setLineWidth(1);
        scene.setOnMousePressed(e-> {
            gc.beginPath();
            gc.lineTo(e.getSceneX(),e.getSceneY());
            gc.stroke();
            System.out.println(" "+e.getSceneX()+" "+e.getSceneY());
        });
        colorPicker.setValue(Color.BLACK);
        colorPicker.setOnAction(e->{
            gc.setStroke(colorPicker.getValue());
        });

        slider.setMin(0);
        slider.setMax(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(e->{
            double value = slider.getValue();
            String val = String.format("%.1f",value);
            label.setText(val);
            gc.setLineWidth(value);


        });


        scene.setOnMouseDragged(e->{
            gc.lineTo(e.getSceneX(),e.getSceneY());
            gc.stroke();
            System.out.println(" "+e.getSceneX()+" "+e.getSceneY());
        });
        pane.getChildren().addAll(canvas,gridPane);

        gridPane.addRow(0,colorPicker,slider,label);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20,0,0,0));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    Label  label = new Label("1.0");
    Slider slider = new Slider();
    GraphicsContext gc;
    GridPane gridPane = new GridPane();

    ColorPicker colorPicker = new ColorPicker();
    Canvas canvas = new Canvas(800,500);
    StackPane pane = new StackPane();
    Scene scene = new Scene(pane,800,500);


    public static void main(String[] args) {
        launch(args);
    }
}
