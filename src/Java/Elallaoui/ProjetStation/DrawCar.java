package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.*;

public class DrawCar extends JPanel  {

    int x,y;
    Car car;

    public DrawCar(int x, int y,GasContainer gasContainer) {
        this.x = x;
        this.y = y;

        car= new Car(x,y,gasContainer);
        setSize(500,200);
        //setBackground(Color.darkGray);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        car.drawCar(g);

    }

    public Car getCar() {
        return car;
    }
}
