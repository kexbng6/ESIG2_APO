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
		FenetreParcours f = new FenetreParcours("Exemple affichage r�pertoires avec JTree", "C:\\ESIGUsers\\DocOracle");
		f.pack();
		f.setVisible(true);
	}
}

class FenetreParcours extends JFrame
{
	static File r�pD�part; //= "C:\\ESIGUsers\\IBM\\RFT_Workspace\\.metadata";
	
	FenetreParcours(String titre, String nomRepD�part)
	{
		super(titre);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		File r�pD�part = new File(nomRepD�part);
		
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(r�pD�part);
		//parcoursUnNiveau(r�pD�part, racine);
		
		parcoursTousLesNiveaux(r�pD�part, racine);
		JTree jt = new JTree(racine);
		add(new JScrollPane(jt));
		
		
	}
    
    public static void parcoursUnNiveau(File r�p, DefaultMutableTreeNode noeudParent)
    {
     	File[] listeFichiers = r�p.listFiles();
    	
    	for (int i = 0; i < listeFichiers.length; i++) 
    	{
    		if ( listeFichiers[i].isDirectory() )
    			noeudParent.add(new DefaultMutableTreeNode("REP "+listeFichiers[i]));
    		else
    			noeudParent.add(new DefaultMutableTreeNode("FIC "+listeFichiers[i]));
    	}
    }
    
    public static void parcoursTousLesNiveaux(File r�p, DefaultMutableTreeNode noeudParent)
    {
    	for ( File fich : r�p.listFiles())
    	{
    		if ( fich.isDirectory() )
    		{
    			DefaultMutableTreeNode noeudEnfant = new DefaultMutableTreeNode("REP "+fich);
    			noeudParent.add(noeudEnfant);
    			parcoursTousLesNiveaux(fich, noeudEnfant);//appel r�cursif
    		}
    		else
				noeudParent.add(new DefaultMutableTreeNode("FIC "+fich));
    	}
    }
 }