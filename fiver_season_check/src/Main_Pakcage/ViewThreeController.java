package Main_Pakcage;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Controller for {@link SceneThree}.
 *
 * @author Xinyi Sun
 * @version alpha
 */
public class ViewThreeController {

    private Stage stage;

    /**
     * Must inject a stage
     */
    public ViewThreeController(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        this.stage = stage;
    }


    public void drag(MouseEvent event, GridPane container) {
        //if (DEBUG) System.out.println("ic mouse drag");
        MyImageView n = (MyImageView) event.getSource();
        Bounds boundsInLocal = n.getBoundsInParent();
        double curNodeMinX = boundsInLocal.getMinX();
        double curNodeMinY = boundsInLocal.getMinY();
        if (SceneThree.dragImageViewList.indexOf(n) < 0) {
            n.setOriginMinX(curNodeMinX);
            n.setOriginMinY(curNodeMinY);
            SceneThree.dragImageViewList.add(n);
            System.out.println(SceneThree.dragImageViewList);
        }

        //System.out.println("node:"+curNodeMinX+":"+curNodeMinY);
        Bounds boundsInParent = container.getBoundsInParent();
        double maxX = boundsInParent.getMaxX();
        double maxY = boundsInParent.getMaxY();
        double minX = boundsInParent.getMinX();
        double mixY = boundsInParent.getMinY();
        //System.out.println("container_min:"+minX+" : "+mixY);
        //System.out.println("container_max:"+maxX+" : "+maxY);
        double px = n.getTranslateX() + event.getX();
        double py = n.getTranslateY() + event.getY();
        //System.out.println("posi:"+px+" : "+py);
        //System.out.println("eventXY:"+event.getX()+" : "+event.getY());
        if ((px + n.getFitWidth() <=  maxX) && (py + n.getFitHeight() + n.getOriginMinY() <= maxY)) {
            n.setOffsetX(curNodeMinX - minX);
            n.setOffsetY(curNodeMinY - mixY);
            n.setTranslateX(n.getTranslateX() + event.getX());
            n.setTranslateY(n.getTranslateY() + event.getY());
        }
    }

    public void setHandlerForDrag(MyImageView iv1, GridPane container) {
        iv1.setOnMouseDragged(event -> drag(event, container));
    }
}
