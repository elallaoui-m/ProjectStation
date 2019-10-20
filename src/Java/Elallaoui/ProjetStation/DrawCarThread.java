package Java.Elallaoui.ProjetStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DrawCarThread extends Thread{

    protected MainWindows myFrame;
    protected DrawCar newCar;
    protected  GasContainer gasContainer;
    public final static Object obj = new Object();

    int delay;

    public DrawCarThread() {
    }

    public DrawCarThread(MainWindows myFrame , int delay, GasContainer gasContainer) {
        this.myFrame = myFrame;
        this.newCar = myFrame.carRoad;
        this.delay =  delay;
        this.gasContainer = gasContainer;
    }


    @Override
    public void run() {
        super.run();

        gasContainer.fillCar((int) (Math.random()*50));


        Timer timer = new Timer(delay, new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                myFrame.progressBar.setValue(gasContainer.gasAmount);
                try {
                    newCar.getCar().move();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                newCar.validate();
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
