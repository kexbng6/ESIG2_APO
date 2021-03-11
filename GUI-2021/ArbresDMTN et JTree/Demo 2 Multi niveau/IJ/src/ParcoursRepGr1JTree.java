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
		FenetreParcours f = new FenetreParcours("Exemple affichage répertoires avec JTree",
				                         "C:\\ESIGUsers\\Intel");
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

 //       parcoursUnNiveau(répDépart);
		
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(répDépart);
//		parcoursUnNiveau(répDépart, racine);
		
		parcoursTousLesNiveaux(répDépart, racine);

		JTree jt = new JTree(racine);
		add(new JScrollPane(jt));

		System.out.println("Nom de fichier/répertoire le plus long "+nomPluslong(racine));
        System.out.println("Hauteur de l'arbre : "+ racine.getDepth());
	}

	private String nomPluslong(DefaultMutableTreeNode noeudCourant)
	{
		String nomFichier = ((File)noeudCourant.getUserObject()).getName();

		for (int numFils = 0; numFils < noeudCourant.getChildCount(); numFils++)
		{
			DefaultMutableTreeNode fils = (DefaultMutableTreeNode)noeudCourant.getChildAt(numFils);
			if ( ((File)fils.getUserObject()).isDirectory() )
			{
				String nomPlusLongFils = nomPluslong(fils);
				if (  nomPlusLongFils.length() > nomFichier.length() )
					nomFichier = nomPlusLongFils;
			}
			String nomFichierFils = ((File)fils.getUserObject()).getName();
			if ( nomFichierFils.length() > nomFichier.length() )
				nomFichier = nomFichierFils;
		}
		return nomFichier;
	}

//	//quel répertoire contient le plus d'éléments directs
//	private DefaultMutableTreeNode maxElem(DefaultMutableTreeNode noeudCourant)
//	{
//		DefaultMutableTreeNode r = noeudCourant;//on suppose que le max "est" le noeuid courant
//		int max = noeudCourant.getChildCount();
//
//		for (int numFils = 0; numFils < noeudCourant.getChildCount(); numFils++)
//		{
//			DefaultMutableTreeNode fils = (DefaultMutableTreeNode)noeudCourant.getChildAt(numFils);
//			if ( max < fils.getChildCount() )
//			{
//				max = fils.getChildCount();
//				r = fils;
//			}
//
//		}
//	}



	public static void parcoursUnNiveau(File rép)
    {
        File[] listeFichiers = rép.listFiles();

        for (int i = 0; i < listeFichiers.length; i++)
        {
            if ( listeFichiers[i].isDirectory() )
                System.out.println(listeFichiers[i]);
            else
                System.out.println(listeFichiers[i]);
        }
    }

    public static void parcoursUnNiveau(File rép, DefaultMutableTreeNode noeudParent)
    {
     	File[] listeFichiers = rép.listFiles();
    	
    	for (int i = 0; i < listeFichiers.length; i++) 
    	{
    		if ( listeFichiers[i].isDirectory() )
    			noeudParent.add(new DefaultMutableTreeNode(listeFichiers[i]));
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
    			DefaultMutableTreeNode noeudEnfant = new DefaultMutableTreeNode(/*"REP "+*/fich);
    			noeudParent.add(noeudEnfant);
    			parcoursTousLesNiveaux(fich, noeudEnfant);//appel récursif
    		}
    		else
				noeudParent.add(new DefaultMutableTreeNode(/*"FIC "+*/fich));
    	}
    }
 }