package Main;

import Ships.BattleShip;
import Ships.Carrier;
import Ships.Ship;
import Ships.SubMarine;
import javafx.scene.control.Button;

public class Button_Structure
{
    boolean touchable = true;
    Button button;
    Ship ship;
    boolean contains_ship = false;
    public void set_ship(Ship ship)
    {
        this.ship = ship;
    }
    public boolean check()
    {
        if(ship==null)
            return false;
        return true;
    }
    void set_button(Button button)
    {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Button_Structure{" +
                "touchable=" + touchable +
                ", contains_ship=" + contains_ship +
                '}'+" "+ship;
    }

    public boolean destroy(Button button_1)
    {

        if(touchable)
        {
            touchable = false;
            if(ship.decrease_size())
            {
                System.out.println(ship.get_size());
                if(ship instanceof Carrier)
                {
                    button_1.setStyle("-fx-background-color: pink");
                }
                if(ship instanceof BattleShip)
                {
                    button_1.setStyle("-fx-background-color: lightgreen");
                }
                if(ship instanceof SubMarine)
                {
                    button_1.setStyle("-fx-background-color: yellow");
                }
                if(ship instanceof SubMarine)
                {
                    button_1.setStyle("-fx-background-color: white");
                }
                return true;
            }
        }
        return false;
    }
}
