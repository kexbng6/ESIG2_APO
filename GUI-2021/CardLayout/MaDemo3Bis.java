import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MaDemo3
{
	public static void main (String[] args) 
    {
		MaDemo3Frame mdf = new MaDemo3Frame();
		mdf.pack();
		mdf.setVisible(true);
    }
}

class MaDemo3Frame extends JFrame implements ActionListener
{
	JPanel pnlI = new JPanel();
	JPanel pnlA = new JPanel();
	JPanel pnlE = new JPanel();
	
	String[] listeLabels = {"I-Le voici!", "A-Le voilà!", "Euh..."};
	
	JButton run = new JButton("Choisir l'affichage");

	//définir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelDuBas = new JPanel(myCardLayout);

	MaDemo3Frame()
	{
		super("Question d'Hermann et de Jonas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		run.addActionListener(this);
		add(run, "North");		
		
		pnlI.add(new JLabel(listeLabels[0]));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel( listeLabels[1]));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("ça marche"));
		
		pnlE.add(new JLabel(listeLabels[2]));
		//pour l'exemple un autre composant ici aussi
		pnlE.add(new JCheckBox("Demo3"));
		
		add(panelDuBas, "South");
		
		// add successifs sur le même panel
		// empilés grâce au CardLayout
		// on ne voit que le premier
		panelDuBas.add(pnlI, "I"); // le deuxième argument sert à désigner le panel
		panelDuBas.add(pnlA, "A");
		panelDuBas.add(pnlE, "E");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// null pour centrer au milieu de l'écran quelle que soit la position de la fenêtre
		// this pour centrer au lieu de la fenêtre elle-même
		String réponse = (String)JOptionPane.showInputDialog(null /*this*/, "Choisissez votre affichage", "Petite question", JOptionPane.QUESTION_MESSAGE, null, listeLabels, listeLabels[0]);
				
		if ( réponse == null )
			;//rien à changer car l'utilisateur n'a rien demandé
		else if ( réponse.equals(listeLabels[0]) ) 
		{
        	myCardLayout.show(panelDuBas, "I");// où = 1er argument, quoi = 2ème
		}
        else if ( réponse.equals(listeLabels[1]) ) 
		{
        	myCardLayout.show(panelDuBas, "A");// où = 1er argument, quoi = 2ème
		}
		else  //forcément réponse.equals(listeLabels[2])
		{
        	myCardLayout.show(panelDuBas, "E");// où = 1er argument, quoi = 2ème			
		}
	}
}