package World_App;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Door {

    private double x, y;
    private double height;

    public Door(double x, double y, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, height / 2, height);
    }
}
