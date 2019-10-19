package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DrawCarThread extends Thread{

    MainWindows myFrame;
    DrawCar newCar;
    GasContainer gasContainer;
    public final static Object obj = new Object();

    int delay;

    public DrawCarThread(MainWindows myFrame , int delay,GasContainer gasContainer) {
        this.myFrame = myFrame;
        this.newCar = new DrawCar(0,20,gasContainer);
        myFrame.add(newCar);
        this.delay =  delay;
        this.gasContainer = gasContainer;
    }


    @Override
    public void run() {
        super.run();

        gasContainer.fillCar((int) (Math.random()*50));
        myFrame.getProgressBar().setValue(gasContainer.gasAmount);

        Timer timer = new Timer(delay, new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                try {
                    newCar.getCar().move();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                newCar.repaint();


                    synchronized (obj)
                    {
                        if (gasContainer.getGasAmount() < 10)
                        {
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
