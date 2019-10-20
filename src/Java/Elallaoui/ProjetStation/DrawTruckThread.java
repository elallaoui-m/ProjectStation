package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DrawTruckThread extends DrawCarThread {

    public DrawTruckThread(MainWindows myFrame, int delay, GasContainer gasContainer) {
        this.myFrame = myFrame;
        this.delay = delay;
        this.gasContainer = gasContainer;
        newCar = myFrame.carRoad;

    }


    /**
     * Runnable respnsable de l'animation de camion de gasoil
     * chaque passage provoque le remplissage du reservoir de gasoil
     */
    @Override
    public void run() {

        gasContainer.refillGaz();
        newCar.getTruck().x = 0;


        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    newCar.getTruck().move();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                newCar.repaint();

            }
        });

        timer.start();

        synchronized (DrawCarThread.obj) {
            obj.notifyAll();

        }


    }
}
