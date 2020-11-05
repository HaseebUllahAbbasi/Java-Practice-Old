package img_drag;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class Controller
{
    int count = 0;
    @FXML ImageView img = new ImageView();

    public void pressed(MouseEvent mouseEvent)
    {
        System.out.println("method is called of pressed "+count);

        if(mouseEvent.getX()<550&&mouseEvent.getY()<280&&mouseEvent.getX()>20&&mouseEvent.getY()>10)
        {
            img.setX(mouseEvent.getX()-70);
            img.setY(mouseEvent.getY()-20);
        }
    }
    public void release(MouseEvent mouseEvent)
    {
        System.out.println("method is called of release "+count);

        if(mouseEvent.getX()<550&&mouseEvent.getY()<280&&mouseEvent.getX()>20&&mouseEvent.getY()>10)
        {
            img.setX(mouseEvent.getX()-70);
            img.setY(mouseEvent.getY()-20);
        }
    }

    public void drag_detected(MouseEvent event)
    {
        System.out.println(((Node)event.getSource()).toString());
        System.out.println("drag_detected : ");
    }

    public void drag_done(DragEvent event)
    {
        System.out.println(((Node)event.getSource()).toString());
        System.out.println("drag done ");
    }

    public void drag_droped(DragEvent event)
    {
        System.out.println("drag dropped");
        System.out.println(((Node)event.getSource()).toString());
    }

    public void drag_entered(DragEvent event)
    {
        System.out.println("drag entered");
        System.out.println(((Node)event.getSource()).toString());
    }

    public void drag_exited(DragEvent event) {
        System.out.println("drag exited");
        System.out.println(((Node)event.getSource()).toString());
    }

    public void mouse_drag_entered(MouseDragEvent event) {
        System.out.println("mouse drag entered");
        System.out.println(((Node)event.getSource()).toString());
    }

    public void mouse_drag_exit(MouseDragEvent event)
    {
        System.out.println("mouse drag exited");
        System.out.println(((Node)event.getSource()).toString());
    }

    public void drag_released(MouseDragEvent event)
    {
        System.out.println("drag_released moous");
        System.out.println(((Node)event.getSource()).toString());
    }
}
