package img_drag;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller
{
    @FXML
    ImageView img = new ImageView();
    public void pressed(MouseEvent mouseEvent)
    {
        if(mouseEvent.getX()<550&&mouseEvent.getY()<280&&mouseEvent.getX()>20&&mouseEvent.getY()>10)
        {
            img.setX(mouseEvent.getX()-70);
            img.setY(mouseEvent.getY()-20);
        }

    }
    public void rlz(MouseEvent mouseEvent)
    {
        if(mouseEvent.getX()<550&&mouseEvent.getY()<280&&mouseEvent.getX()>20&&mouseEvent.getY()>10)
        {
            img.setX(mouseEvent.getX()-70);
            img.setY(mouseEvent.getY()-20);
        }
    }
}
