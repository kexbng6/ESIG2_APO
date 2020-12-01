import java.awt.event.*;
import javax.swing.*;


class Fenetre extends JFrame implements ActionListener 
{
	JButton ok;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* avec cette m�thode, il n'est plus n�cessaire 
		   - d'impl�menter l'interface WindowListener
		   - d'ajouter un WindowListener � la fen�tre
		*/

		ok = new JButton("OK");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		ok.addActionListener(this);
		
		/*getContentPane().*/add(ok);
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(ok))
		{
			System.exit(0);
		}

	}
}

class Exemple09Swing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 9 - Swing");
		f.pack();
		f.setVisible(true);
	}
}
