import java.util.ArrayList;

public class PC extends Ordinateur {
    public ArrayList<Moniteur> listeMoniteurs;
    public ArrayList<String> portsVideoSortie;

    public PC(int ANNEE_COURANTE, String marque, double prixHT, int anneeAchat, ArrayList<Moniteur> listeMoniteurs, ArrayList<String> portsVideoSortie) {
        super(ANNEE_COURANTE, marque, prixHT, anneeAchat);
        this.listeMoniteurs = listeMoniteurs;
        this.portsVideoSortie = portsVideoSortie;
    }

    public void ajouteMoniteur(Moniteur moni){
       listeMoniteurs.add(moni);
    }

    public boolean isPortAvailable(String port){

        return false;
    }
}
