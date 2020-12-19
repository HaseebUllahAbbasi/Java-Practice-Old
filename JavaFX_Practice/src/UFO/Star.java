package UFO;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class to create a drawable "star".
 * 
 * @author Abdus Sattar Mia
 */
public class Star {

    private int x, y; // location
    private Color color; 

    
    public Star(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

   
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillOval(x, y, 2, 2);
    }

    
    public void setColor(Color color) {
        this.color = color;
    }
}
