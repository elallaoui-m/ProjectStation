package Java.Elallaoui.ProjetStation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  JPanel pour le dessin de la voiture
 */
public class DrawCar extends JPanel  {

    int x,y;
    Car car;
    Truck truck;

    public DrawCar() {
    }

    public DrawCar(Car car,Truck truck) {
        this.x = x;
        this.y = y;

        this.car = car;
        this.truck = truck;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("image_station.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(myImage,0,0,null);
        car.drawCar(g);
        truck.drawCar(g);

    }

    public Car getCar() {
        return car;
    }
    public Truck getTruck() {
        return truck;
    }
}
