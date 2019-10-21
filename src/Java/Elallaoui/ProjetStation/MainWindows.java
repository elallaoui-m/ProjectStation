package Java.Elallaoui.ProjetStation;


import javax.swing.*;

/**
 * c'est la classe principale qui herite de JFrame et contient la fonctions main
 */

public class MainWindows extends JFrame {

    JProgressBar progressBar;
    JPanel progress;

    DrawCar carRoad;
    GasContainer gasContainer;

    Car car;
    Truck truck;


    MainWindows() {

        // parametre frame
        super("Gas Station");
        setSize(800, 580);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        gasContainer = new GasContainer(this);
        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.HORIZONTAL);

        progress = new JPanel();


        car = new Car(0, 450, gasContainer);
        truck = new Truck(-250, 370, gasContainer);
        carRoad = new DrawCar(car, truck);

        //add to jframe
        getContentPane().add(carRoad);


        carRoad.add(progressBar);

    }

    /**
     * Image panel pour la mettre une image comme backgroud d'un component
     * class ImagePanel extends JComponent {
     * private Image image;
     * public ImagePanel(Image image) {
     * this.image = image;
     * }
     *
     * @Override protected void paintComponent(Graphics g) {
     * super.paintComponent(g);
     * g.drawImage(image, 0, 0, this);
     * }
     * }
     */



    public static void main(String[] args) {
        MainWindows mainWindows = new MainWindows();
        mainWindows.setVisible(true);

        DrawCarThread thread1 = new DrawCarThread(mainWindows, 10, mainWindows.gasContainer);
        thread1.start();

    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }


    public JPanel getProgress() {
        return progress;
    }

    public JPanel getCarRoad() {
        return carRoad;
    }
}
