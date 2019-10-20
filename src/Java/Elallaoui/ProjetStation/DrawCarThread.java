package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Thread qui lance l'annimation d'une voitre
 */

public class DrawCarThread extends Thread {

    public final static Object obj = new Object();
    protected MainWindows myFrame;
    protected DrawCar newCar;
    protected GasContainer gasContainer;
    int delay;

    public DrawCarThread() {
    }

    public DrawCarThread(MainWindows myFrame, int delay, GasContainer gasContainer) {
        this.myFrame = myFrame;
        this.newCar = myFrame.carRoad;
        this.delay = delay;
        this.gasContainer = gasContainer;
    }


    /**
     *  Au lancement de ce Runnable object, les voiture vont etre dessinee et anime l'une apres l'autre
     *  c'est le thead responsable de l'annimation des voitures
     *  chaque passage va provoque une demenution du reservoir de gasoil
     */
    @Override
    public void run() {
        super.run();

        gasContainer.fillCar((int) (Math.random() * 50) + 5);


        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                myFrame.progressBar.setValue(gasContainer.gasAmount);
                try {
                    newCar.getCar().move();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                newCar.validate();
                newCar.repaint();


                synchronized (obj) {
                    if (gasContainer.getGasAmount() < 10) {

                        try {

                            Thread thread = new Thread(gasContainer);
                            thread.start();
                            obj.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }


            }
        });

        timer.start();


    }
}
