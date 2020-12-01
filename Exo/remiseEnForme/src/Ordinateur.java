public class Ordinateur {
    public int ANNEE_COURANTE;
    public String marque;
    public double prixHT;
    public int anneeAchat;

    public Ordinateur(int ANNEE_COURANTE, String marque, double prixHT, int anneeAchat) {
        this.ANNEE_COURANTE = ANNEE_COURANTE;
        this.marque = marque;
        this.prixHT = prixHT;
        this.anneeAchat = anneeAchat;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "ANNEE_COURANTE=" + ANNEE_COURANTE + ", marque='" + marque + '\'' + ", prixHT=" + prixHT + ", anneeAchat=" + anneeAchat;
    }
}
