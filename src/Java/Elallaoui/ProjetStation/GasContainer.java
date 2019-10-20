package Java.Elallaoui.ProjetStation;

/**
 * class responsable de la gestion du reservoir de gasoil
 */
public class GasContainer implements Runnable {

    int gasAmount; //Quantite
    boolean isEmpty;
    MainWindows myframe; //Fram principale


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

    public void refillGaz() {

        setGasAmount(100);
        isEmpty = false;


    }


    /**
     *
     * @param wantedGaz Quantite de gas volue par une voiture
     *                  la quantite sera soustraire de la quantite existee dans le reservoir
     */
    public void fillCar(int wantedGaz) {
        gasAmount -= wantedGaz;
        if (gasAmount < 0) {
            gasAmount = 0;
            isEmpty = true;
        }
    }

    /**
     * le Runnable responsable de l'appel a la camion du gasoil apres atteindre la minimum du gasoil
     * dans le reservoir
     * ce thread est appele dans la fonction run() de la class DrawCarThread
     */
    @Override
    public void run() {

        DrawTruckThread drawTruckThread = new DrawTruckThread(myframe, 10, this);
        drawTruckThread.start();



    }
}
