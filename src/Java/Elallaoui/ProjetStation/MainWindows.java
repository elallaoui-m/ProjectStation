package Java.Elallaoui.ProjetStation;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MainWindows extends JFrame {

    JProgressBar progressBar;
    JPanel progress;
    JPanel gasStation;
    JPanel gasStationback;
    JPanel carRoad;




    MainWindows()
    {
        super("Gas Station");
        setSize(800,500);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

         progress = new JPanel();
         gasStation = new JPanel();
        gasStationback = new JPanel();
        carRoad = new JPanel();


        progress.setBackground(Color.BLUE);
        gasStationback.setBackground(Color.cyan);
        gasStation.setBackground(Color.red);


        progress.setSize(500,50);





        getContentPane().add(gasStation);


        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.HORIZONTAL);
        progress.add(progressBar);



       BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(new ImagePanel(myImage));



    }




    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JPanel getProgress() {
        return progress;
    }

    public JPanel getGasStation() {
        return gasStation;
    }

    public JPanel getCarRoad() {
        return carRoad;
    }

    public void setCarRoad(JPanel carRoad) {
        this.carRoad = carRoad;
    }

       class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }


    public static void main(String[] args) {
        MainWindows mainWindows = new MainWindows();
        mainWindows.setVisible(true);

        GasContainer gasContainer = new GasContainer();
       DrawCarThread thread1 = new DrawCarThread(mainWindows,10,gasContainer);
       thread1.start();

    }
}
