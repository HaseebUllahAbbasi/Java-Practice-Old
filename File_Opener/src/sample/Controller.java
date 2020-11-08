package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller
{
    @FXML
    TextField command;
    Stage primaryStage;
    File file;

    @FXML
    Label status_label;
    @FXML
    Label address;

    public void initlize()
    {
        //btn.setOnAction(e->{btn.setText(txt.getText());});
    }
    public void set_attribute(ActionEvent ae)
    {
    //    btn.setText(txt.getText());
    }

    public void show_dialog(ActionEvent actionEvent)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel File", "*.xlsx")
                ,new FileChooser.ExtensionFilter("Excel Old File", "*.xls")
        );
        if(file==null)
        {
            file =fileChooser.showOpenDialog(primaryStage);
            status_label.setText("file is loaded");
            address.setText(file.getAbsolutePath());
        }
        else
        {
            System.out.println("this is error");
        }


    }

    public void open_excel(ActionEvent actionEvent) throws IOException {

        Runtime runtime = Runtime.getRuntime();
        try
        {
            System.out.println(file.getAbsolutePath());

            String set_path = "set path=\"C:\\Program Files\\Microsoft Office\\Office15\";";
            runtime.exec(new String[]{"cmd.exe","/c","start "+set_path + "excel"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(ActionEvent actionEvent)
    {

    }
}
