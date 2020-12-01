import java.awt.GridLayout; 
import javax.swing.*;


class Fenetre extends JFrame 
{
	static final int NB_BOUTONS = 5; // d�claration d'une constante de type int
	JButton[] mesBoutons = new JButton[NB_BOUTONS]; // mes boutons est un tableau de Button
	String[] mesTitres = {"OK", "Quitter", "Editer", "Annuler", "Autre"};

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);

		// Changer le Layout "Manager par d�faut" � GridLayout:
		// D�finition d'un "Grid" de n lignes et 3 colonnes:
		///*getContentPane().*/setLayout(new java.awt.FlowLayout());
		/*getContentPane().*/setLayout(new java.awt.GridLayout(0, 3));// GridLayout(1, 0));
	
		for (int numBouton = 0; numBouton < mesBoutons.length; numBouton++)
		{  
//			mesBoutons[numBouton] = new JButton(mesTitres[numBouton]);
//		    /*getContentPane().*/add(mesBoutons[numBouton]);
//		    //si gestion d'�v�nements : mesBoutons[numBouton].addActionListener(this);
		}
		
		
		for (JButton jb : mesBoutons)
		{
			jb = new JButton("*"); //il faut recr�er une variable de pseudopilotage pour pouvoir �crire mesTitres[numBouton]
			add(jb);
		}
			
	}
}


public class Exemple04terSwing
{
	public static void main (String [] args)
	{
		Fenetre f=new Fenetre("Exemple04 bis - Swing");
		f.pack();
		f.setVisible(true);
	}
}
