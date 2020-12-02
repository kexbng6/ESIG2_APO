import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListItems {
    public ArrayList<Item> listeItems;

    public ListItems(ArrayList<Item> listeItems) {
        this.listeItems = listeItems;
    }

    public static ArrayList<Item> afficheQuestion(File nomFichier){
        ArrayList<Item> list = new ArrayList<>();
        int cptId = 1;
        try {
            Scanner scan = new Scanner(new File(String.valueOf(nomFichier)));
            while (scan.hasNextLine())
            {
                String question = scan.nextLine();
                // System.out.println(cptId + ". " + question);
                String reponse = scan.nextLine();
                Item objet = new Item(question, reponse, cptId);

                list.add(objet);
                cptId++;
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

}
