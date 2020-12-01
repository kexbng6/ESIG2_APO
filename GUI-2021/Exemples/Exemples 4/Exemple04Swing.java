import java.awt.GridLayout;

import javax.swing.*;


class Fenetre extends JFrame 
{
	JButton ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Changer le Layout Manager par défaut à GridLayout
		// définition d'une grille (grid) de n lignes et 3 colonnes:
		/*getContentPane().*/setLayout(new GridLayout(0, 2));
		
		ok = new JButton("OK");
		/*getContentPane().*/add(ok);
		quitter = new JButton("Quitter");
		/*getContentPane().*/add(quitter);
		editer = new JButton("Editer");
		/*getContentPane().*/add(editer);
		annuler = new JButton("Annuler");
		/*getContentPane().*/add(annuler);
		autre = new JButton("Autre");
		/*getContentPane().*/add(autre);

//		JButton autre2 = new JButton("Autre2");
//		/*getContentPane().*/add(autre2);
//		JButton autre3 = new JButton("Autre3");
//		/*getContentPane().*/add(autre3);

	}
}


public class Exemple04Swing
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 4 - Swing");
		f.pack();
		f.setVisible(true);
	}
}