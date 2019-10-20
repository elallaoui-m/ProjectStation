package Java.Elallaoui.ProjetStation;

import static java.lang.Thread.sleep;

public class GasContainer implements Runnable{

    int gasAmount;
    boolean isEmpty;
    MainWindows myframe;


    public GasContainer(MainWindows myframe) {

        gasAmount = 100;
        isEmpty = false;
        this.myframe = myframe;

    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void refillGaz()
    {

        setGasAmount(100);
        isEmpty = false;


    }



    public void fillCar(int wantedGaz)
    {
        gasAmount-=wantedGaz;
        if (gasAmount<0)
        {
            gasAmount = 0;
            isEmpty = true;
        }
    }

    @Override
    public void run() {

        DrawTruckThread drawTruckThread = new DrawTruckThread(myframe,10,this);
        drawTruckThread.start();

        while (true)
        {
            if (gasAmount == 100)
                drawTruckThread.stop();
            break;
        }

    }
}
