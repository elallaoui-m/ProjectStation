package Java.Elallaoui.ProjetStation;

import static java.lang.Thread.sleep;

public class GasContainer implements Runnable{

    int gasAmount;
    boolean isEmpty;


    public GasContainer() {

        gasAmount = 100;
        isEmpty = false;
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
        synchronized (DrawCarThread.obj)
        {
             setGasAmount(100);
                isEmpty = false;

                DrawCarThread.obj.notify();

        }

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
        refillGaz();
    }
}
