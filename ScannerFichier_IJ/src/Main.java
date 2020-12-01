import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Lecture par mots :");
        System.out.println("-------------------------");
        lectureParMots();
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("Lecture par lignes :");
        System.out.println("-------------------------");
        lectureParLignes();
    }

    private static void lectureParLignes()
    {
        try
        {
            Scanner flux = new Scanner(new File("DataScanner.txt"));
            while ( flux.hasNext() )
            {
                String ligne = flux.nextLine();
                System.out.println (ligne);
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Erreur fichier " + fnfe);
            fnfe.printStackTrace();
        }
    }

    public static void lectureParMots()
    {
        try
        {
            Scanner flux = new Scanner(new File("DataScanner.txt"));
            while ( flux.hasNext() )
            {
                String mot = flux.next();
                System.out.println (mot);
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Erreur fichier " + fnfe);
            fnfe.printStackTrace();
        }
    }
}
