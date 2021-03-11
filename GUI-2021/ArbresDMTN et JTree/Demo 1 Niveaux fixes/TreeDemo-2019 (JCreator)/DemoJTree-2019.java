//largement inspir� de Treedemo.java

//va chercher des donn�es dans le r�pertoire data
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
			       implements TreeSelectionListener // pour g�rer les clics sur le JTree
{
	private static final String DOSSIER_DONNEES = "data\\";
	private JTree arboAffich�e;// pour afficher un arbre quelconque
	private JEditorPane pageHTML; // pour afficher des pages HTML
	
    public DemoJTreeFen(String titre) 
    {
	    super(titre);

	    //Cr�ation des noeuds
	    // cr�ation d'un arbre limit� � la racine qui sera compl�t� par cr�erNoeuds()
	    DefaultMutableTreeNode racine = new DefaultMutableTreeNode("The Java Series");
	    cr�erNoeuds(racine);
	
	    //Cr�ation du composant qui permet d'afficher l'arbre
	    arboAffich�e = new JTree(racine);
	    configurationDuJTree();
	    
	    //Un JScrollPane pour avoir des barres de d�filement autour du JTree
	    JScrollPane voletJTree = new JScrollPane(arboAffich�e);
	
		configurationDeLaPageHTML();
		
	    //Un JScrollPane pour avoir des barres de d�filement autour de la page HTML
	    JScrollPane voletHTML = new JScrollPane(pageHTML);
		
		configAffichageADeuxVolets(voletJTree, voletHTML);
		affichageDeLaPageDeD�part();
	}
	
	
	private void cr�erNoeuds(DefaultMutableTreeNode racine) 
	{
		DefaultMutableTreeNode cat�gorie; // il y a 3 cat�gories en tout
		DefaultMutableTreeNode livre; // il y a diff�rents nombres de livres selon
		                              // la cat�gorie
		/////////////////////////                             
		// premi�re cat�gorie
        cat�gorie = new DefaultMutableTreeNode("Books for Java Programmers");
        racine.add(cat�gorie); // Premier fils de la racine
        
		// premier livre de la premi�re cat�gorie
        livre = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial: A Short Course on the Basics",
                                                        "tutorial.html"));
        cat�gorie.add(livre);// premier fils du premier fils de la racine


        livre = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial Continued: The Rest of the JDK",
                                                        "tutorialcont.html"));
        cat�gorie.add(livre);// deuxi�me fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs",
                                                        "swingtutorial.html"));
        cat�gorie.add(livre);// troisi�me fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("Effective Java Programming Language Guide",
	                                                    "bloch.html"));
        cat�gorie.add(livre);// quatri�me fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Programming Language", 
        	                                            "arnold.html"));
        cat�gorie.add(livre);// cinqui�me fils du premier fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Developers Almanac",
                                                        "chan.html"));
        cat�gorie.add(livre);// sixi�me fils du premier fils de la racine


		/////////////////////////                             
		// deuxi�me cat�gorie
        cat�gorie = new DefaultMutableTreeNode("Books for Java Implementers");
        racine.add(cat�gorie); // Deuxi�me fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification",
                                                        "vm.html"));
        cat�gorie.add(livre);// premier fils du deuxi�me fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification",
                                                        "jls.html"));
        cat�gorie.add(livre);// second fils du deuxi�me fils de la racine

        
 		/////////////////////////                             
		// troisi�me cat�gorie
        cat�gorie = new DefaultMutableTreeNode("Livres Java en fran�ais");
        racine.add(cat�gorie); // Troisi�me fils de la racine

        livre = new DefaultMutableTreeNode(new BookInfo("Java 2 : notions fondamentales", ""));
        cat�gorie.add(livre);// unique fils du troisi�me fils de la racine
    }
	
	private void configAffichageADeuxVolets(JScrollPane voletJTree, JScrollPane voletHTML)
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//	/**/JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	    splitPane.setTopComponent(voletJTree); // Top = � gauche en cas de HORIZONTAL_SPLIT
	    splitPane.setBottomComponent(voletHTML); // Bottom = � droite en cas de HORIZONTAL_SPLIT
	
	    Dimension minimumSize = new Dimension(100, 50);
	    voletHTML.setMinimumSize(minimumSize);
	    voletJTree.setMinimumSize(minimumSize);
	    splitPane.setDividerLocation(250); 
	
	    splitPane.setPreferredSize(new Dimension(500, 300));//(100, 100)); 
	    
	    //poser le JSplitPane sur la fen�tre
	    add(splitPane);
	}
	
    /* conform�ment � l'interface TreeSelectionListener  */
    public void valueChanged(TreeSelectionEvent e)
    {
        DefaultMutableTreeNode noeud = (DefaultMutableTreeNode)arboAffich�e.getLastSelectedPathComponent();

        if ( noeud != null ) 
        {       
// la m�thode getUserObject() r�cup�re l'info sur le noeud 
// (ici une instance de BookInfo)
// **� condition** qu'on ait cliqu� sur une feuille
			System.out.println ("Le noeud a "+noeud.getChildCount()+" enfants");
	// si on a cliqu� sur un livre, c'est la page correspondante qui est affich�e
	        Object nodeInfo = noeud.getUserObject();
	        if ( noeud.isLeaf() )// si c'est une feuille, c'est un livre
	        //if ( noeud instanceof BookInfo ) // autre fa�on de faire
	        {
	            BookInfo livre = (BookInfo)nodeInfo;
	            afficherPageHTML(livre.bookURL);
	            System.out.println (livre.bookURL);
	        } 
	        else // sinon la page de d�part et nodeInfo est une String
	        {
	        	affichageDeLaPageDeD�part();
	        	System.out.println (nodeInfo +" a "+((String)nodeInfo).length()+" caract�res");
	        }
        }
    }
	
	private void affichageDeLaPageDeD�part()
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
            System.err.println("URL mal form�e: " + url);
        }
	}
 
	
	private void configurationDuJTree()
	{
		// pour indiquer que le JTree ne permet qu'une s�lection � la fois
	    arboAffich�e.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    //mise en place du surveillant (listener) de clics sur le JTree
	    arboAffich�e.addTreeSelectionListener(this);
	
		//les diff�rents types de lignes de JTree
	    // valeurs possible : "Angled" (par d�faut), "Horizontal" et "None"
	    String  lineStyle = "Angled"; //"Horizontal";//"None"; //
	    arboAffich�e.putClientProperty("JTree.lineStyle", lineStyle);
	}
	
	private void configurationDeLaPageHTML()
	{
		//cr�ation du volet HTML
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
	    { 	//sert � l'affichage des noeuds du JTree
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
	  	
	  	
		// meilleure mani�re d'afficher une fen�tre
		// surtant dans des contextes multi-thread
		// mais moins intuitive car elle utilise une classe anonyme
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                cr�erEtAfficherFen�tre();
        	}
        });
      }
     
      private static void cr�erEtAfficherFen�tre() 
      {
        DemoJTreeFen fen�tre = new DemoJTreeFen("D�monstration de JTree");

        fen�tre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen�tre.pack();
        fen�tre.setVisible(true);
      }

}
