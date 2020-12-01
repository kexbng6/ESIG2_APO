import javax.swing.*;

class Fenetre extends JFrame 
{
	JButton ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Ajout et positionnement à l'aide du BorderLayout 
		// JFrame est en BorderLayout par défaut
		// 5 positions possibles :
		ok = new JButton("OK");
		/*getContentPane().*/add(ok, "North");
		quitter = new JButton("Quitter");
		/*getContentPane().*/add(quitter, "South");
		editer = new JButton("Editer");
		/*getContentPane().*/add(editer, "East");
		annuler = new JButton("Annuler");
		/*getContentPane().*/add(annuler, "West");
		autre = new JButton("Autre");
		/*getContentPane().*/add(autre, "Center");
	}
}


public class Exemple02Swing 
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 2 - Swing");
		f.pack();
		f.setVisible(true);
	}
}