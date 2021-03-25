import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class FenetreParcours extends JFrame
                                            implements TreeSelectionListener
{
    private JTree jt;
    private JTextArea partieDroite;
    static File repDepart;


    FenetreParcours(String titre, String nomRepDepart){
        super(titre);
        this.setDefaultCloseOperation(3);
        File repDepart = new File(nomRepDepart);
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode(repDepart);
        parcoursTousLesNiveaux(repDepart, racine);
        jt = new JTree(racine);
        jt.addTreeSelectionListener(this);

        JScrollPane voletJtree = new JScrollPane(jt);

        partieDroite = new JTextArea();

        configAffichageDeuxVolets(voletJtree, partieDroite);




    }

    private void configAffichageDeuxVolets(JScrollPane voletJtree, JTextArea partieDroite){
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setTopComponent(voletJtree);
        splitPane.setBottomComponent(partieDroite);
        splitPane.setDividerLocation(250);
        //poser le JSplitPane sur la fenêtre
        add(splitPane);
    }


    public static void parcoursTousLesNiveaux(File rép, DefaultMutableTreeNode noeudParent) {
        File[] var2 = rép.listFiles();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            File fich = var2[var4];
            if (fich.isDirectory()) {
                DefaultMutableTreeNode noeudEnfant = new DefaultMutableTreeNode(fich);
                noeudParent.add(noeudEnfant);
                parcoursTousLesNiveaux(fich, noeudEnfant);
            } else {
                noeudParent.add(new DefaultMutableTreeNode(fich));
//
            }
        }

    }


    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode noeud = (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();

        Object nodeInfo = noeud.getUserObject();
        System.out.println(nodeInfo);
        partieDroite.setText("");
        if ( noeud.isLeaf() )// si c'est une feuille, c'est un livre
        //if ( noeud instanceof BookInfo ) // autre façon de faire
        {
            try {
                Scanner sc = new Scanner(new File(String.valueOf(nodeInfo)));
                while (sc.hasNextLine()){
                    String ligne = sc.nextLine();
                    partieDroite.append(ligne );
                    partieDroite.append("\n");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else // sinon la page de départ et nodeInfo est une String
        {
            System.out.println ("marche pas");
        }

    }
}
