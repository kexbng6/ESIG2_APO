import javax.swing.*;

class Fenetre extends JFrame 
{
	JButton ok, quitter, editer, /*annuler,*/ autre;
	java.awt.Button annuler;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Ajout et positionnement à l'aide du BorderLayout 
		// 5 positions possibles :
		ok = new JButton("OK");
		/*getContentPane().*/add(ok, "North");
		quitter = new JButton("Quitter");
		/*getContentPane().*/add(quitter, "South");
		editer = new JButton("Editer");
		/*getContentPane().*/add(editer, "East");
		annuler = new java.awt.Button("Annuler");
		/*getContentPane().*/add(annuler, "West");
		autre = new JButton("Autre");
		/*getContentPane().*/add(autre, "Center");
	}
}


public class Exemple02MixSwingAWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 2 - Swing");
		f.pack();
		f.setVisible(true);
	}
}