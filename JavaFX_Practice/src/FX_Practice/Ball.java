package FX_Practice;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * @author Abdus Sattar
 */

public class Ball {

    private double x, y, xSpeed, ySpeed;
    private final int size;
    private final Color c;

    
    public Ball(double x, double y, double xSpeed, double ySpeed, int size, Color c) {
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
    }

    /**
     * Reverses the x direction by multiplying it by -1
     */
    public void bounceX() {
        xSpeed *= -1;
    }

    /**
     * Reverses the y direction by multiplying it by -1
     */
    public void bounceY() {
        ySpeed *= -1;
    }

    public void draw(GraphicsContext g) {
        g.setFill(c);
        g.fillOval((int) Math.round(x), (int) Math.round(y), size, size);
    }

    /**
     * @return the current x location
     */
    public double getX() {
        return x;
    }

    /**
     * @return the current y location
     */
    public double getY() {
        return y;
    }

    
    public int getSize() {
        return size;
    }

}
