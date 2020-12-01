public class Moniteur extends Ordinateur {
    public int tailleEnPouces;
    public int resolutionEnPixels;

    public Moniteur(int ANNEE_COURANTE, String marque, double prixHT, int anneeAchat, int tailleEnPouces, int resolutionEnPixels) {
        super(ANNEE_COURANTE, marque, prixHT, anneeAchat);
        this.tailleEnPouces = tailleEnPouces;
        this.resolutionEnPixels = resolutionEnPixels;
    }


}
