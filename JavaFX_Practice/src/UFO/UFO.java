package UFO;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * An example of an object that can draw and move itself.
 *
 * @author Abdus Sattar Mia
 */
public class UFO {

    private double x, y, xSpeed, ySpeed;
    private final int size;
    private final Color c;

   
    public UFO(double x, double y, double xSpeed, double ySpeed, int size, Color c) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
        this.c = c;
    }

    /**
     * Increment x and y using the values of xSpeed and ySpeed
     */
    public void moveOneStep() {
        x += xSpeed;
        y += ySpeed;
        if (Math.random() < 0.01) {
            ySpeed *= -1;
        }
        if (Math.random() < 0.01) {
            xSpeed *= -1;
        }
    }

    
    public void draw(GraphicsContext g) {
        g.setFill(c);
        g.fillOval(x, y, size * 5, size);
        g.fillRect(x + size * 3.0 / 2, y - size / 2.0, size * 2, size);
    }

}
