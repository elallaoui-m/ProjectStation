package Java.Elallaoui.ProjetStation;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
c'est la classe principale qui herite de JFrame et contient la fonctions main

 */

public class MainWindows extends JFrame {

    JProgressBar progressBar;
    JPanel progress;
    //JPanel gasStation;
    DrawGasStation gasStation;
    DrawCar carRoad;
    DrawTruck truckRoad;
    GasContainer gasContainer;




    MainWindows()
    {

        // parametre frame
        super("Gas Station");
        setSize(1422,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        //setLayout(new FlowLayout());


        gasContainer = new GasContainer(this);
        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.HORIZONTAL);
        //progressBar.setSize(200,200);


        gasStation = new DrawGasStation();

        progress = new JPanel();


        carRoad = new DrawCar(0,600,gasContainer);
        truckRoad = new DrawTruck(-300,600,gasContainer);



        //add to jframe
        getContentPane().add(carRoad);
        //getContentPane().add(gasStation);
        //getContentPane().add(truckRoad);


        gasStation.setLayout(new FlowLayout());
        //gasStation.setBackground(Color.red);
        gasStation.add(progressBar);



       /*BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gasStation.add(new ImagePanel(myImage));*/



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



    /**
     *
     *Image panel pour la mettre une image comme backgroud d'un component
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
    }*/



    public static void main(String[] args) {
        MainWindows mainWindows = new MainWindows();
        mainWindows.setVisible(true);

       DrawCarThread thread1 = new DrawCarThread(mainWindows,10,mainWindows.gasContainer);
       thread1.start();

    }
}
