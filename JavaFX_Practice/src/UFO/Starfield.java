package UFO;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Create the starfield 
 *
 * @author Abdus Sattar Mia
 */
public class Starfield {

    private int width, height; // size of star field
    private Star[] stars; // array of stars

    
    public Starfield(int width, int height, int numStars) {
        this.width = width;
        this.height = height;
        stars = new Star[numStars];
        for (int i = 0; i < stars.length; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
           
            stars[i] = new Star((int) (Math.random() * width), (int) (Math.random() * height), Color.rgb(r, g, b));
        }
    }

   
    public void twinkle() {
        Star twinkled = stars[(int) (Math.random() * stars.length)];
        int scale = (int) (Math.random() * 255);
        twinkled.setColor(Color.rgb(scale, scale, scale));
    }

    
    public void draw(GraphicsContext g) {
        // wipe out the screen
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, width, height);
        // draw each star
        for (Star star : stars) {
            star.draw(g);
        }
    }

}
