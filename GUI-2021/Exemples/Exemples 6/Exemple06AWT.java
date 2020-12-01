import java.awt.*;
import java.awt.event.*;

class Fenetre extends Frame implements ActionListener
{
	Button quitter;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		quitter = new Button("Exit");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions : c'est la fen�tre elle-m�me
		quitter.addActionListener(this);
		add(quitter);
	}

	// D�finit le comportement en cas d'action: c'est le gestionnaire d'�v�nement
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(quitter))
		{
			System.exit(0); //quitter
		}
	}
}

public class Exemple06AWT
{
	public static void main (String [] args)
	{
		Fenetre f=new Fenetre("Exemple 6 - AWT");
		f.pack();
		f.setVisible(true);
	}
}
