//gestion des �v�nements clic sur quitter par une sous-classe de JButton (MonBouton)
// mais le code (m�thode) � ex�cuter est dans la classe Fenetre

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Fenetre extends JFrame 
{
	MonBouton quitter;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		quitter = new MonBouton("Exit", this);
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		/*getContentPane().*/add(quitter);
	}

	void maMethodeAAppeler(String texte)
	{
		System.out.println ("Texte du bouton : "+texte);
	}

}

public class Exemple06QuaterSwing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 6 - Swing");
		f.pack();
		f.setVisible(true);
	}
}

// gestionnaire d'�v�nements dans la classe repr�sentant le bouton

class MonBouton extends JButton implements ActionListener
{
	Fenetre fen�treOrigine;	

	MonBouton(String texte, Fenetre fen�treOrigine)
	{
		super(texte);
		addActionListener(this); 
		// remplace 	quitter.addActionListener(quitter); dans Fenetre
		this.fen�treOrigine = fen�treOrigine;
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(this))
		{
			fen�treOrigine.maMethodeAAppeler(getText());
			System.exit(0);
		}
	}	
}