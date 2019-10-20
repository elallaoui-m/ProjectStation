package Java.Elallaoui.ProjetStation;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MainWindows extends JFrame {

    JProgressBar progressBar;
    JPanel progress;
    JPanel gasStation;
    JPanel gasStationback;
    DrawCar carRoad;
    DrawTruck truckRoad;
    GasContainer gasContainer;




    MainWindows()
    {
        super("Gas Station");
        setSize(800,500);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));


        gasContainer = new GasContainer(this);
        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.VERTICAL);


        progress = new JPanel();
        gasStationback = new JPanel();
        gasStation = new JPanel();
        carRoad = new DrawCar(0,20,gasContainer);
        truckRoad = new DrawTruck(-300,20,gasContainer);

        gasStation.setLayout(new BorderLayout());
        gasStation.add(gasStationback,BorderLayout.LINE_START);
        gasStation.add(progress,BorderLayout.LINE_END);
        progress.add(progressBar);




        getContentPane().add(carRoad);
        getContentPane().add(gasStation);
        getContentPane().add(truckRoad);








/*       BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(new ImagePanel(myImage));*/



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


       DrawCarThread thread1 = new DrawCarThread(mainWindows,10,mainWindows.gasContainer);
       thread1.start();

    }
}
