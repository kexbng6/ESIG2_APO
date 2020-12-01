import java.awt.*;
import java.awt.event.*;

class Fenetre extends Frame implements ActionListener, WindowListener 
{
	Button ok;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);

		// Informer la fenetre que c'est elle-m�me qui s'occupe des WindowEvent:
		addWindowListener(this);

		ok = new Button("OK");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		ok.addActionListener(this);

		add(ok);
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(ok))
		{
			System.exit(0);
		}
	}

	// Si je veux traiter la "petite croix", je proc�de comme pour le bouton,
	// j'implemente un WindowListener.
	// MAIS: Il y a sept m�thodes � impl�menter!
	//
	// R�alisation stupide
	// --------------------

	public void windowOpened(WindowEvent we)
	{	// vide, mais impl�ment�
	}
	
	public void windowClosed(WindowEvent we)
	{	// vide, mais impl�ment�
	}
	
	public void windowIconified(WindowEvent we)
	{	// vide, mais impl�ment�
		// System.out.println ("petit, petit");
	}
	
	public void windowDeiconified(WindowEvent we)
	{	// vide, mais impl�ment�
		// System.out.println ("me revoil�");
	}
	
	public void windowActivated(WindowEvent we)
	{	// vide, mais impl�ment�
	}
	
	public void windowDeactivated(WindowEvent we)
	{	// vide, mais impl�ment�
	}
	
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}


public class Exemple07AWTVraimentTropLong
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 7 - AWT");
		f.pack();
		f.setVisible(true);
	}
}
