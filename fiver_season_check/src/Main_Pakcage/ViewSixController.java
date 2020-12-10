package Main_Pakcage;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Controller for {@link ViewTwo}.
 * 
 * @author Ruoxi Jin
 * @version alpha
 */
public class ViewSixController {
	
	private Stage stage;
	
	/** Must inject a stage */
	public ViewSixController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	

	public void drag(MouseEvent event, GridPane container) {
		//if (DEBUG) System.out.println("ic mouse drag");
		MyImageView n = (MyImageView) event.getSource();
		Bounds boundsInLocal = n.getBoundsInParent();
		Bounds boundsInParent = container.getBoundsInParent();
		double maxX = boundsInParent.getMaxX();
		double maxY = boundsInParent.getMaxY();
		double px = n.getTranslateX() + event.getX();
		double py = n.getTranslateY() + event.getY();
		if ((px + n.getFitWidth() <=  maxX) && (py + n.getFitHeight() + n.getOriginMinY() <= maxY)) {
			n.setTranslateX(n.getTranslateX() + event.getX());
			n.setTranslateY(n.getTranslateY() + event.getY());
		}
	}

	public void setHandlerForDrag(MyImageView iv1, GridPane container) {
		iv1.setOnMouseDragged(event -> drag(event, container));
	}
}
