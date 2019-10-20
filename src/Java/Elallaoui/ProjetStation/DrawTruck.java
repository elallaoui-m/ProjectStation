package Java.Elallaoui.ProjetStation;

import java.awt.*;

public class DrawTruck extends DrawCar {

    public DrawTruck(int x, int y, GasContainer gasContainer) {
        super();

        this.x = x;
        this.y = y;

        car= new Truck(x,y,gasContainer);
        setSize(500,200);
        setBackground(Color.darkGray);
    }
}
