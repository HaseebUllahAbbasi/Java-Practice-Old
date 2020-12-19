package World_App;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Village {
    
    private double x, y;
    private double size;
    private String name;
    private Color color;
    
    private House bHouse, mHouse, sHouse;

    
    public Village(String name, int x, int y, double size) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        //Random number for producing random color
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 101);
        int B = (int) (Math.random() * 256);
        //Random number for producing random space between two houses
        int space = (int) (Math.random() * 20 + 20);

        bHouse = new House(x, y, size, Color.rgb(R, G, B));
        mHouse = new House(x += size + space, y + size / 3, 2 * size / 3, Color.rgb(R, G, B));
        sHouse = new House(x += 2 * size / 3 + space, y + size / 2, size / 2, Color.rgb(R, G, B));
        //Set occupants in each house
        bHouse.setOccupants((int) (Math.random() * 4 + 8));
        mHouse.setOccupants((int) (Math.random() * 4 + 6));
        sHouse.setOccupants((int) (Math.random() * 3 + 5));
    }

   
    public void draw(GraphicsContext gc) {

        bHouse.draw(gc);
        mHouse.draw(gc);
        sHouse.draw(gc);
        //Calculate total population, size of the house. 
        int population = bHouse.getOccupants() + mHouse.getOccupants() + sHouse.getOccupants();
        double villSize = (20 * bHouse.getSize() + 20 * mHouse.getSize() + 20 * sHouse.getSize() + 20 * x) / 100;
        gc.strokeText("" + name + ": Size - " + Math.round(villSize) + "m, Population - " + population, x, (y + size + 20) );

    }
}
