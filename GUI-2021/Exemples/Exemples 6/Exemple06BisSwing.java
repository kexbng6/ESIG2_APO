//gestion des �v�nements clic sur quitter par une autre classe (GestionClic)

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.*;

class Fenetre extends JFrame 
{
	JButton quitter;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		quitter = new JButton("Exit");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		quitter.addActionListener(new GestionClic(quitter));
		/*getContentPane().*/add(quitter);
	}


}

public class Exemple06BisSwing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 6 - Swing");
		f.pack();
		f.setVisible(true);
	}
}

// gestionnaire d'�v�nements dans une classe � part

class GestionClic implements ActionListener
{
	JButton bouton;
	
	GestionClic(JButton b)
	{
		bouton = b;
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(bouton))
		{
			System.out.println (bouton.getText());
			System.out.println (ae.getActionCommand());// cette fa�on de faire n'utilise pas bouton
			System.exit(0);
		}
	}	
}