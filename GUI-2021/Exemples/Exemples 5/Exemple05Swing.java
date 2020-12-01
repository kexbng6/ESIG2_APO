import javax.swing.*;
import java.awt.GridLayout; /* pour un des exemples */
import java.awt.BorderLayout; /* pour un des exemples */

class Fenetre extends JFrame 
{
	JButton ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Utilisation d'un JPanel:
		//JPanel p = new JPanel(); // FlowLayout par défaut
		//JPanel p = new JPanel(new BorderLayout());
		JPanel p = new JPanel();
		
		// ajout des boutons au JPanel
		ok = new JButton("OK");
		p.add(ok);
		quitter = new JButton("Quitter");
		p.add(quitter);
		editer = new JButton("Editer");
		p.add(editer);
		annuler = new JButton("Annuler");
		p.add(annuler);
		autre = new JButton("Autre");
		autre.setEnabled(false);
		p.add(autre);
		
		// ajout du JPanel à la JFrame
		/*getContentPane().*/add(p, "North");
		
		//autres composants sur la JFrame mais pas dans le JPanel
		JTextField t=new JTextField("Voyons", 100);
		/*getContentPane().*/add(t, "South");
		
		
		/* Il est possible de poser des barres de défilement sur un TextField aussi
		JScrollPane jsp0 = new JScrollPane(t, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
										     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jsp0, "South");
		*/
		
		JTextArea ta = new JTextArea();
		//ta.setText("Pas touche !");
		//ta.setEditable(false); // pour n'avoir qu'un affichage par programme
		//ta.setLineWrap(true);
		/* pour afficher avec des barres de défilement */
		JScrollPane jsp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
											  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(jsp, "Center");
		
		/*getContentPane().*///add(ta, "Center");// sans barre de défilement
	}
}


public class Exemple05Swing
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 5 - Swing");
		f.pack();
		f.setVisible(true);
	}
}
