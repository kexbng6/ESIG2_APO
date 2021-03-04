
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FenExa20 extends JFrame
{
    private static File repDep = new File ("Poisson");
    //ne pas oublier d'appeler initRacine(repDep); dans le constructeur de la fenêtre !!
    HashMap<String, ArrayList<String>> exemples = new HashMap<>();
    //ne pas oublier d'appeler initExemples(repDep); dans le constructeur de la fenêtre !!







///////////////////////////////////////////////////
// UTILISER MAIS ME PAS MODIFIER CE QUI SUIT!! ////
///////////////////////////////////////////////////

    private void initExemples(File rep)//initialise la HashMap exeéples
    {
        for ( File f : rep.listFiles() )
            if ( f.isFile() )
                ajoutDansExemples(f.getParentFile().getName(), f.getName().substring(0, f.getName().indexOf('.')));
            else
                initExemples(f);
    }

    private void ajoutDansExemples(String famille, String exemple)// complément à initExemples
    {
        ArrayList<String> liste = exemples.get(famille);
        if ( liste == null )
            liste = new ArrayList<String>();
        liste.add(exemple);
        exemples.put(famille, liste);
    }

    private DefaultMutableTreeNode initRacine(File repDep) //crée l'arbre à afficher par le JTreee
    {
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode(repDep.getName());
        File[] listeFichiers1 = repDep.listFiles();
        for ( int numRepNiv1 = 0; numRepNiv1 < compterSousRepertoire(repDep); numRepNiv1++)
        {
            DefaultMutableTreeNode filsNiv1 = new DefaultMutableTreeNode(listeFichiers1[numRepNiv1].getName());
            racine.add(filsNiv1);
            File[] listeFichiers2 = listeFichiers1[numRepNiv1].listFiles();
            for ( int numRepNiv2 = 0; numRepNiv2 < compterSousRepertoire(listeFichiers1[numRepNiv1]); numRepNiv2++)
            {
                DefaultMutableTreeNode filsNiv2 = new DefaultMutableTreeNode(listeFichiers2[numRepNiv2].getName());
                filsNiv1.add(filsNiv2);
                File[] listeFichiers3 = listeFichiers2[numRepNiv2].listFiles();
                for ( int numRepNiv3 = 0; numRepNiv3 < compterSousRepertoire(listeFichiers2[numRepNiv2]); numRepNiv3++)
                {
                    DefaultMutableTreeNode filsNiv3 = new DefaultMutableTreeNode(listeFichiers3[numRepNiv3].getName());
                    filsNiv2.add(filsNiv3);
                }
            }
        }
        return racine;
    }

    private DefaultMutableTreeNode trouverFamille(String nomFamille, DefaultMutableTreeNode noeud)
    {
        if ( nomFamille.equals(noeud.getUserObject()))
            return noeud;
        else
            for ( int num = 0; num < noeud.getChildCount(); num++ )
            {
                DefaultMutableTreeNode dmtn = trouverFamille(nomFamille, (DefaultMutableTreeNode) noeud.getChildAt(num));
                if ( dmtn != null )
                    return dmtn;
            }
        return null;
    }

    private int compterSousRepertoire(File repDep)//utulisé par initRacine()
    {
        int nb = 0;
        for ( File f : repDep.listFiles() )
            if ( f.isDirectory() )
                nb++;
        return nb;
    }

    private void afficheDansLog(JTextArea log, String message)
    {
        log.append(message+System.lineSeparator());
    }
}
