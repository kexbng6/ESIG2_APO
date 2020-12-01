import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListItems {
    public ArrayList<Item> listeItems;

    public ListItems(ArrayList<Item> listeItems) {
        this.listeItems = listeItems;
    }

    public static void afficheQuestion(String nomFichier){
        ArrayList<Item> list = new ArrayList<>();
        int cptId = 0;
        try {
            Scanner scan = new Scanner(new File(nomFichier));
            while (scan.hasNextLine())
            {
                String question = scan.nextLine();
                System.out.println(question);
                String reponse = scan.nextLine();
                Item objet = new Item(question, reponse, cptId);

                list.add(objet);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
