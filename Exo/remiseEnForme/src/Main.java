import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void lireDonnees1(String nomFichier){
        System.out.println('\n' + "Partie 1------------");
//        ArrayList<String> nbMots = new ArrayList<>();
        int nbMots = 0;
        try (Scanner sc = new Scanner(new File(nomFichier))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner sc2 = new Scanner(line);


                while (sc2.hasNext()) {
                    System.out.println(sc2.next());
                    nbMots ++;
                }
            }
            System.out.println(nbMots);
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichier non trouvé.. flute de zut =(");
        }
    }

    public static void lireDonnees2(String nomFichier){
        System.out.println('\n' + "Partie 2------------");
//        ArrayList<String> nbMots = new ArrayList<>();
        int nbLigne = 0;
        try (Scanner sc = new Scanner(new File(nomFichier))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner sc2 = new Scanner(line);
                nbLigne ++;

                while (sc2.hasNext()) {
                    System.out.println(sc2.next());
                }

            }
            System.out.println(nbLigne);
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichier non trouvé.. flute de zut =(");
        }

    }

    public static void main(String[] args) {
        lireDonnees1("data.txt");
    }
}