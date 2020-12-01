import javax.swing.*;
import java.awt.event.*;

class Fenetre extends JFrame implements ActionListener
{
	JButton ok;

	public Fenetre(String aTitle)
	{
		//si vous ne voulez pas que la fen�tre soit toujours ferm�e
		// il ***faut*** utiliser
		//    DO_NOTHING_ON_CLOSE
		// comme op�ration de fermeture par d�faut
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// ne pas utiliser  --- qui est le comportement par d�faut
		//    setDefaultCloseOperation(HIDE_ON_CLOSE);
		// si on ne veut pas toujours la fermeture car la fen�tre reste cach�e
		// dans les cas o� on ne confirme pas la fermeture
		
		// ne pas utiliser 
		// 	  setDefaultCloseOperation(EXIT_ON_CLOSE);
		// si on ne veut pas toujours la fermeture car alors la fen�tre est ***toujours** ferm�e
		// quelle que soit la r�ponse � la question sur la fermeture
		
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

/* cf. explications dans Exemple08AWT
 */
class WindowKiller extends WindowAdapter
{
		public void windowClosing(WindowEvent we)
		{
			int r = JOptionPane.showConfirmDialog(null, "Stop ou encore ???", "Votre attention svp", JOptionPane.OK_CANCEL_OPTION);
			if ( r == JOptionPane.OK_OPTION )
				System.exit(0);
		}
}


public class Exemple08SwingPasSiLongAvecQuestion
{
	public static void main (String [] args)
	{
		Fenetre f=new Fenetre("Exemple 8 - Swing");
		f.pack();
		f.setVisible(true);
	}
}
