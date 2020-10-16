package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    ArrayList<Integer> list = new ArrayList<Integer>();
    Random random = new Random();
    int size_of_list = 1;
    int user_inputs = 1;
    @FXML Button button_1;
    @FXML Button button_2;
    @FXML Button button_3;
    @FXML Button button_4;
    Button[] buttons = new Button[4];
    int score = 0;
    public void generate()
    {
        for(int i=0; i<size_of_list; i++)
        {
            list.add(random.nextInt(4));
        }
        size_of_list++;
        System.out.println(list.toString());
        // start_thread();
    }
    public void start_thread() throws InterruptedException
    {
        //for(int i=0; i<size_of_list-1; i++)
        {
            int number = list.get(0);
            String color = buttons[0].getStyle();
            //if(color.equals("-fx-background-color:  #d6f5d6"))
            {
                buttons[0].setStyle("-fx-background-color:  #28a428");
            }
            Thread.sleep(2000);

            buttons[0].setStyle("-fx-background-color:  #d6f5d6");
        }

    }
    public void btn_on_status()
    {

    }
    public void btn_restore()
    {

    }
    public void pressed(ActionEvent ae)
    {
        String name  = ((Button) (ae.getSource())).getText();

        /*
        if(Integer.getInteger(name)==list.get(user_inputs))
        {
            //list.remove(user_inputs);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Your Score was "+score+ " !\n Wanna Try Again", ButtonType.YES, ButtonType.NO);
            if (alert.getResult() == ButtonType.YES)
            {
                System.out.println("About to be restarted");
            }
            else
            {
                System.out.println("System is about to Exit");
            }

        }

         */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        button_1.setStyle("-fx-background-color:  #d6f5d6");
        button_2.setStyle("-fx-background-color:   #ffc299");
        button_3.setStyle("-fx-background-color:   #99b3ff");
        button_4.setStyle("-fx-background-color:   #ffffcc");

        buttons[0] = button_1;
        buttons[1] = button_2;
        buttons[2] = button_3;
        buttons[3] = button_4;

    }
}
