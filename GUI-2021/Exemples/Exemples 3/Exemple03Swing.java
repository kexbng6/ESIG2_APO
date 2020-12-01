
import java.awt.FlowLayout;

import javax.swing.*;


class Fenetre extends JFrame 
{
	JButton ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		super(unTitre);
		//setTitle(unTitre);

		// Changer le Layout Manager par défaut
		/*getContentPane().*/setLayout(new FlowLayout());

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
//		add(new JButton("*"));
//		add(new JButton("?"));
	}
}

public class Exemple03Swing
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 3 - Swing");
		f.pack();
		f.setVisible(true);
	}
}