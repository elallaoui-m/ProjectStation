package Java.Elallaoui.ProjetStation;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Truck extends Car {
    public Truck(int x, int y, GasContainer gasContainer) {
        super();

        this.x = x;
        this.y = y;
        this.gasContainer = gasContainer;



        try {
            car = ImageIO.read(new File("truck_image.png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void move() throws IOException {

        if(x == D_W / 2) {

                System.out.println("Gas refiled");

        }

            x += INCREMENT;

    }
}
