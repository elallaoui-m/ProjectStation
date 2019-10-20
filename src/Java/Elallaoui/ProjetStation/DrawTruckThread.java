package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DrawTruckThread extends DrawCarThread {

    public DrawTruckThread(MainWindows myFrame, int delay, GasContainer gasContainer) {
        this.myFrame = myFrame;
        this.delay =  delay;
        this.gasContainer = gasContainer;
        newCar = myFrame.truckRoad;

    }


    @Override
    public void run() {

        gasContainer.refillGaz();
        newCar.getCar().x = 0;


        Timer timer = new Timer(delay, new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                try {
                    newCar.getCar().move();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                newCar.repaint();

            }
        });

        timer.start();

        synchronized (DrawCarThread.obj)
        {
            obj.notifyAll();

        }


    }
}
