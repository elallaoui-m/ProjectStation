package Java.Elallaoui.ProjetStation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawGasStation extends JPanel {

    public DrawGasStation() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("gasStation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(myImage,0,0,null);
    }
}
