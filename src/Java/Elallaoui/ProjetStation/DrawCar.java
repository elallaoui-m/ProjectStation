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

    public DrawCar() {
    }

    public DrawCar(int x, int y, GasContainer gasContainer) {
        this.x = x;
        this.y = y;

        car= new Car(x,y,gasContainer);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("gasStation_prime.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(myImage,0,0,null);
        car.drawCar(g);

    }

    public Car getCar() {
        return car;
    }
}
