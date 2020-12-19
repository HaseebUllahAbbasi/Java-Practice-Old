package World_App;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class House {

    private double x, y;
    private double size;
    private int occupants;
    private Color color;
    private Door door;
    private Window window;

    public House(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        door = new Door(x + size / 2, y + size / 2, size / 2);
        window = new Window(x + size / 10, y + size / 10, size / 4);
    }

    public House(double x, double y) {
        this.x = x;
        this.y = y;
        occupants = 1;
        size = 180;
        color = Color.rgb(255, 153, 102);
        door = new Door(x + size / 2, y + size / 2, size / 2);
        window = new Window(x + size / 10, y + size / 10, size / 4);

    }

    public void setOccupants(int n) {
        occupants = n;
    }

    public int getOccupants() {
        return occupants;
    }

    public double getSize() {
        return size;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
        door.draw(gc);
        window.draw(gc);

    }
}
