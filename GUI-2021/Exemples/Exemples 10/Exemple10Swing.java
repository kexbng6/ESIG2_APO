import java.awt.event.*;
import javax.swing.*;


class Fenetre extends JFrame implements ActionListener 
{
	JButton ok, cancel;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // différence avec DISPOSE_ON_CLOSE
		/* avec cette méthode, il n'est plus nécessaire 
		   - d'implémenter l'interface WindowListener
		   - d'ajouter un WindowListener à la fenêtre
		*/

		ok = new JButton("OK");
		// Informer mon bouton du gestionnaire à qui il doit transmettre les actions..:
		ok.addActionListener(this);
		
		cancel = new JButton("cancel");
		// Informer mon bouton du gestionnaire à qui il doit transmettre les actions..:
		cancel.addActionListener(this);

		/*getContentPane().*/add(ok, "East");
		add(new JLabel("milieu", SwingConstants.CENTER), "Center" );
		/*getContentPane().*/add(cancel, "West");
	}

	// Définit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource().equals(ok))
		{
			System.exit(0);
		}
		else if (ae.getSource().equals(cancel))
		{
			System.out.println("rien à faire...dans"+getTitle());
		}

	}
}


public class Exemple10Swing
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre("Exemple 10 - Swing");
		f.pack();
		f.setVisible(true);
		
		Fenetre g = new Fenetre("Exemple 10 - Swing-***");
		g.pack();
		g.setVisible(true);
	}
}
