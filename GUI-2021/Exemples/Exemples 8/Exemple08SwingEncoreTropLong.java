import javax.swing.*;
import java.awt.event.*;

class Fenetre extends JFrame implements ActionListener
{
	JButton ok;

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);

		// Informer la fenetre que c'est une instance de WindowKiller
		// qui s'occupe des WindowEvent :
		addWindowListener(new WindowKiller());

		ok=new JButton("OK");
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

/* La classe WindowAdapter (fournie par sun) impl�mente WindowListener 
 * en donnant un corps vide � chacune de 7 m�thodes � d�finir 
 * pour impl�menter cette interface.
 *
 * WindowKiller (vous pouvez choisir un autre nom) h�rite de WindowAdapter
 * et se contente de red�finir la m�thode qui nous int�resse, ici windowClosing()
 */
class WindowKiller extends WindowAdapter ///autre exemple : MouseMotionAdapter
{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
}


public class Exemple08SwingEncoreTropLong
{
	public static void main (String [] args)
	{
		Fenetre f=new Fenetre("Exemple 8 - Swing");
		f.pack();
		f.setVisible(true);
	}
}
