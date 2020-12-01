import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

// Les 3 piliers de la gestion d'�v�nements "clics"
// 1- la classe doit annoncer qu'elle respecte le contrat "ActionListener" : implements ActionListener
// 2- pour respecter ce contrat, elle doit contenir une m�thode actionPerformed(ActionEvent)
// 3- et indiquer quels composants sont "g�r�s" (par addActionListener() )

class Fenetre extends JFrame implements ActionListener
{
	JButton quitter, autre;

	Fenetre(String aTitle)
	{
		setTitle(aTitle);
		quitter = new JButton("Exit");
		// Informer mon bouton du gestionnaire � qui il doit transmettre les actions..:
		quitter.addActionListener(this);
		/*getContentPane().*/add(quitter, "North");
		autre = new JButton("cliquez-moi");
		autre.addActionListener(this);
		add(autre, "South");
	}

	// D�finit le comportement en cas d'action:
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(quitter))
		{
			System.out.println (quitter.getText());
			System.out.println (ae.getActionCommand());
			System.exit(0);//arr�te d�finitivement l'application
		}
		else // forc�ment l'autre
		{
			autre.setText("ouch !");
			setTitle("�a fait mal !");
			System.out.println ("Ouille");
		}
			
	}
}

public class Exemple06Swing
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 6 - Swing");
		f.pack();
		f.setVisible(true);
	}
}
