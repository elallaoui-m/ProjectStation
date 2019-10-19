package Java.Elallaoui.ProjetStation;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GasTruck extends Car {



    public GasTruck(int x, int y, GasContainer gasContainer) {
        super(x, y, gasContainer);
    }

    @Override
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
