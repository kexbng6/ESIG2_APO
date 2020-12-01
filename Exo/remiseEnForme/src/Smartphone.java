public class Smartphone extends Ordinateur {
    public int resolutionEnPixels;
    public boolean compatible5g;

    public Smartphone(int ANNEE_COURANTE, String marque, double prixHT, int anneeAchat, int resolutionEnPixels, boolean compatible5g) {
        super(ANNEE_COURANTE, marque, prixHT, anneeAchat);
        this.resolutionEnPixels = resolutionEnPixels;
        this.compatible5g = compatible5g;
    }


}
