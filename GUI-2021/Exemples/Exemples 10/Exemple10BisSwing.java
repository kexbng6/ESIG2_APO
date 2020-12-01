import java.awt.event.*;
import javax.swing.*;


class Fenetre extends JFrame implements ActionListener 
{
	JButton ok, cancel;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//EXIT_ON_CLOSE ferme l'application
		//DISPOSE_ON_CLOSE ne ferme que la fen�tre
		
		/* avec cette m�thode, il n'est plus n�cessaire 
		   - d'impl�menter l'interface WindowListener
		   - d'ajouter un WindowListener � la fen�tre
		*/

		ok = new JButton("OK");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		ok.addActionListener(this);
		
		cancel = new JButton("cancel");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		cancel.addActionListener(this);

		setLayout(new java.awt.FlowLayout());
		
		/*getContentPane().*/add(ok, "East");
		/*getContentPane().*/add(new JLabel("milieu"), "Center" );
		/*getContentPane().*/add(cancel, "West");
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(ok))
		{
			if ( getTitle().endsWith("***") )
				dispose();// ferme la fen�tre sans toucher les �ventuelles autres s'il y en a
			else
				System.exit(0);// ferme toutes les fen�tres de l'�pplication et l'application elle-m�me
		}
		else if (ae.getSource().equals(cancel))
		{
			System.out.println("rien � faire...");
		}

	}
}


class Exemple10BisSwing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 10bis - Swing");
		f.pack();
		f.setVisible(true);
		
		Fenetre g = new Fenetre("Exemple 10bis - Swing-***");
		g.pack();
		g.setVisible(true);
	}
}
