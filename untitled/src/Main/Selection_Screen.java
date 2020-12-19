package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Selection_Screen
{
    @FXML TextField rows;
    @FXML TextField columns;

    public void increase_rows(ActionEvent actionEvent)
    {
        int row = (Integer.parseInt(rows.getText())+1);
        if(row<10)
            rows.setText(String.valueOf(row));
    }

    public void decrease_rows(ActionEvent actionEvent)
    {
        int row = (Integer.parseInt(rows.getText())-1);
        if(row>0)
            rows.setText(String.valueOf(row));

    }

    public void increase_col(ActionEvent actionEvent)
    {
        int col = (Integer.parseInt(columns.getText())+1);
        if(col<10)
            columns.setText(String.valueOf(col));
    }

    public void decrease_col(ActionEvent actionEvent)
    {
        int col = (Integer.parseInt(columns.getText())-1);
        if(col>0)
            columns.setText(String.valueOf(col));

    }

    public void game_screen(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Game_Screen.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void exit_game(ActionEvent actionEvent)
    {
        System.exit(1);
    }

    public void high_scores(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("High_Scores.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
