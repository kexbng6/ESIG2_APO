//gestion des événements clic sur quitter par une sous-classe de JButton (MonBouton)


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Fenetre extends JFrame 
{
	MonBouton quitter;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		quitter = new MonBouton("Exit");
		// Informer mon bouton du gestionnaire à qui il doit transmettre les actions..:
		/*getContentPane().*/add(quitter);
	}


}

public class Exemple06TerSwing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 6 - Swing");
		f.pack();
		f.setVisible(true);
	}
}

// gestionnaire d'événements dans la classe représentant le bouton

class MonBouton extends JButton implements ActionListener
{

	MonBouton(String texte)
	{
		super(texte);
		addActionListener(this); 
		// remplace 	quitter.addActionListener(this); dans Fenetre
	}

	// Définit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(this))
		{
			System.out.println (getText());
			System.exit(0);
		}
	}	
}