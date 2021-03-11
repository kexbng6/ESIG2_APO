import java.io.File;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;




class ParcoursRepGr1JTree
{
	public static void main (String [] args)
	{
		FenetreParcours f = new FenetreParcours("Exemple affichage répertoires avec JTree", "C:\\ESIGUsers\\DocOracle");
		f.pack();
		f.setVisible(true);
	}
}

class FenetreParcours extends JFrame
{
	static File répDépart; //= "C:\\ESIGUsers\\IBM\\RFT_Workspace\\.metadata";
	
	FenetreParcours(String titre, String nomRepDépart)
	{
		super(titre);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		File répDépart = new File(nomRepDépart);
		
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(répDépart);
		//parcoursUnNiveau(répDépart, racine);
		
		parcoursTousLesNiveaux(répDépart, racine);
		JTree jt = new JTree(racine);
		add(new JScrollPane(jt));
		
		
	}
    
    public static void parcoursUnNiveau(File rép, DefaultMutableTreeNode noeudParent)
    {
     	File[] listeFichiers = rép.listFiles();
    	
    	for (int i = 0; i < listeFichiers.length; i++) 
    	{
    		if ( listeFichiers[i].isDirectory() )
    			noeudParent.add(new DefaultMutableTreeNode("REP "+listeFichiers[i]));
    		else
    			noeudParent.add(new DefaultMutableTreeNode("FIC "+listeFichiers[i]));
    	}
    }
    
    public static void parcoursTousLesNiveaux(File rép, DefaultMutableTreeNode noeudParent)
    {
    	for ( File fich : rép.listFiles())
    	{
    		if ( fich.isDirectory() )
    		{
    			DefaultMutableTreeNode noeudEnfant = new DefaultMutableTreeNode("REP "+fich);
    			noeudParent.add(noeudEnfant);
    			parcoursTousLesNiveaux(fich, noeudEnfant);//appel récursif
    		}
    		else
				noeudParent.add(new DefaultMutableTreeNode("FIC "+fich));
    	}
    }
 }