package Java.Elallaoui.ProjetStation;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Car {
    protected static final int D_W = 800;
    protected static final int D_H = 400;
    protected static final int INCREMENT = 5;
    int x, y;
    int rand;
    GasContainer gasContainer ;

    protected   Image car;

    public  Car()
    {

    }

    public Car(int x, int y,GasContainer gasContainer) {
        this.x = x;
        this.y = y;
        this.gasContainer = gasContainer;

         rand = (int) (Math.random()*4);
        try {
            car = ImageIO.read(new File("new_car_image_"+rand+".png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawCar(Graphics g) {
        g.drawImage(car,x,y,null);
    }

    public void move() throws IOException {

        if(x == D_W / 2) {
            try {
                gasContainer.fillCar((int) (Math.random()*50));
                synchronized (DrawCarThread.obj)
                {
                    DrawCarThread.obj.wait(1500);
                }
                System.out.println("gas left = "+gasContainer.getGasAmount()+"%");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (x == 0-car.getWidth(null) ) {
            x = D_W+car.getWidth(null)/2;
            rand = (int) (Math.random()*4);
            car = car = ImageIO.read(new File("new_car_image_"+rand+".png" ));



        } else {
            x -= INCREMENT;

        }



    }
}
