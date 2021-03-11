//largement inspiré de Treedemo.java

//va chercher des données dans le répertoire data
import javax.swing.JFrame;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JOptionPane;
//import java.awt.GridLayout;

class DemoJTreeFen extends JFrame 
			       implements TreeSelectionListener // pour gérer les clics sur le JTree
{
	private static final String DOSSIER_DONNEES = "data\\";
	private JTree arboAffichée;// pour afficher un arbre quelconque
	private JEditorPane pageHTML; // pour afficher des pages HTML
	
    public DemoJTreeFen(String titre) 
    {
	    super(titre);

	    //Création des noeuds
	    // création d'un arbre limité à la racine qui sera complété par créerNoeuds()
	    DefaultMutableTreeNode racine = new DefaultMutableTreeNode("The Java Series");
	    créerNoeuds(racine);
	
	    //Création du composant qui permet d'afficher l'arbre
	    arboAffichée = new JTree(racine);
	    configurationDuJTree();
	    
	    //Un JScrollPane pour avoir des barres de défilement autour du JTree
	    JScrollPane voletJTree = new JScrollPane(arboAffichée);
	
		configurationDeLaPageHTML();
		
	    //Un JScrollPane pour avoir des barres de défilement autour de la page HTML
	    JScrollPane voletHTML = new JScrollPane(pageHTML);
		
		configAffichageADeuxVolets(voletJTree, voletHTML);
		affichageDeLaPageDeDépart();
	}
	
	
	private void créerNoeuds(DefaultMutableTreeNode racine) 
	{
		DefaultMutableTreeNode catégorie; // il y a 3 catégories en tout
		DefaultMutableTreeNode livre; // il y a différents nombres de livres selon
		                              // la catégorie
		/////////////////////////                             
		// première catégorie
        catégorie = new DefaultMutableTreeNode("Books for Java Programmers");
        racine.add(catégorie); // Premier fils de la racine
        
		// premier livre de la première catégorie
        livre = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial: A Short Course on the Basics",
                                                        "tutorial.html"));
        catégorie.add(livre);// premier fils du premier fils de la racine


        livre = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial Continued: The Rest of the JDK",
                                                        "tutorialcont.html"));
        catégorie.add(livre);// deuxième fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs",
                                                        "swingtutorial.html"));
        catégorie.add(livre);// troisième fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("Effective Java Programming Language Guide",
	                                                    "bloch.html"));
        catégorie.add(livre);// quatrième fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Programming Language", 
        	                                            "arnold.html"));
        catégorie.add(livre);// cinquième fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Developers Almanac",
                                                        "chan.html"));
        catégorie.add(livre);// sixième fils du premier fils de la racine


		/////////////////////////                             
		// deuxième catégorie
        catégorie = new DefaultMutableTreeNode("Books for Java Implementers");
        racine.add(catégorie); // Deuxième fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification",
                                                        "vm.html"));
        catégorie.add(livre);// premier fils du deuxième fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification",
                                                        "jls.html"));
        catégorie.add(livre);// second fils du deuxième fils de la racine

        
 		/////////////////////////                             
		// troisième catégorie
        catégorie = new DefaultMutableTreeNode("Livres Java en français");
        racine.add(catégorie); // Troisième fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("Java 2 : notions fondamentales", ""));
        catégorie.add(livre);// unique fils du troisième fils de la racine
    }
	
	private void configAffichageADeuxVolets(JScrollPane voletJTree, JScrollPane voletHTML)
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//	/**/JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	    splitPane.setTopComponent(voletJTree); // Top = à gauche en cas de HORIZONTAL_SPLIT
	    splitPane.setBottomComponent(voletHTML); // Bottom = à droite en cas de HORIZONTAL_SPLIT
	
	    Dimension minimumSize = new Dimension(100, 50);
	    voletHTML.setMinimumSize(minimumSize);
	    voletJTree.setMinimumSize(minimumSize);
	    splitPane.setDividerLocation(250); 
	
	    splitPane.setPreferredSize(new Dimension(500, 300));//(100, 100)); 
	    
	    //poser le JSplitPane sur la fenêtre
	    add(splitPane);
	}
	
    /* conformément à l'interface TreeSelectionListener  */
    public void valueChanged(TreeSelectionEvent e)
    {
        DefaultMutableTreeNode noeud = (DefaultMutableTreeNode)arboAffichée.getLastSelectedPathComponent();

        if ( noeud != null ) 
        {       
// la méthode getUserObject() récupère l'info sur le noeud 
// (ici une instance de BookInfo)
// **à condition** qu'on ait cliqué sur une feuille
			System.out.println ("Le noeud a "+noeud.getChildCount()+" enfants");
	// si on a cliqué sur un livre, c'est la page correspondante qui est affichée
	        Object nodeInfo = noeud.getUserObject();
	        if ( noeud.isLeaf() )// si c'est une feuille, c'est un livre
	        //if ( noeud instanceof BookInfo ) // autre façon de faire
	        {
	            BookInfo livre = (BookInfo)nodeInfo;
	            afficherPageHTML(livre.bookURL);
	            System.out.println (livre.bookURL);
	        } 
	        else // sinon la page de départ et nodeInfo est une String
	        {
	        	affichageDeLaPageDeDépart();
	        	System.out.println (nodeInfo +" a "+((String)nodeInfo).length()+" caractères");
	        }
        }
    }
	
	private void affichageDeLaPageDeDépart()
	{
		BookInfo livreBidon = new BookInfo(null, "TreeDemoHelp.html");
		afficherPageHTML(livreBidon.bookURL);
	}
	
	private void afficherPageHTML(URL url)
	{
		try
		{
            if (url != null)
                pageHTML.setPage(url);
            else //l'URL est null
				pageHTML.setText("Fichier introuvable");
        } 
        catch (IOException e) 
        {
            System.err.println("URL mal formée: " + url);
        }
	}
 
	
	private void configurationDuJTree()
	{
		// pour indiquer que le JTree ne permet qu'une sélection à la fois
	    arboAffichée.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    //mise en place du surveillant (listener) de clics sur le JTree
	    arboAffichée.addTreeSelectionListener(this);
	
		//les différents types de lignes de JTree
	    // valeurs possible : "Angled" (par défaut), "Horizontal" et "None"
	    String  lineStyle = "Angled"; //"Horizontal";//"None"; //
	    arboAffichée.putClientProperty("JTree.lineStyle", lineStyle);
	}
	
	private void configurationDeLaPageHTML()
	{
		//création du volet HTML
	    pageHTML = new JEditorPane();
	    pageHTML.setEditable(false);
	}
	
    private class BookInfo
    {
    	public String bookName;
    	public URL bookURL = null;

    	public BookInfo(String book, String filename) 
    	{
        	bookName = book;
        	if ( filename.equals("") ) 
        		// pour montrer qu'on peut avoir un autre protocole que file:/
        		try 
        		{
        			bookURL = new URL("https://www.google.ch");	
        		}	
        		catch (MalformedURLException e)
        		{
        			System.out.println (e);
        		}
        	else
        		bookURL = DemoJTreeFen.class.getResource(DOSSIER_DONNEES+filename);
        	if (bookURL == null)
        	   	System.err.println("Fichier introuvable "+ filename);
    	}

	    public String toString() 
	    { 	//sert à l'affichage des noeuds du JTree
	        return bookName;
	        //return bookName+"->"+bookURL;
	    }
	}
}

class DemoJTree
{
	  public static void main(String[] args)
	  {
	  	//demande du look and feel voulu
	  	String[] listeLAF = { "Swing Metal", "Windows Classic" };
	  	if ( 1 == JOptionPane.showOptionDialog(null, "choissisez le look and feel", "Choix du look and feel du JTree", 
	  		                                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, listeLAF, listeLAF[0]))
            try 
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) 
            {
                System.err.println("Couldn't use system look and feel.");
            }
	  	
	  	
		// meilleure manière d'afficher une fenêtre
		// surtant dans des contextes multi-thread
		// mais moins intuitive car elle utilise une classe anonyme
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                créerEtAfficherFenêtre();
        	}
        });
      }
     
      private static void créerEtAfficherFenêtre() 
      {
        DemoJTreeFen fenêtre = new DemoJTreeFen("Démonstration de JTree");

        fenêtre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenêtre.pack();
        fenêtre.setVisible(true);
      }

}
