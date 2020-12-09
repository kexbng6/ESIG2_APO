import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

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
	
	String[] listeLabels = new String[3]; //{"I-Le voici!", "A-Le voil�!", "Euh..."};
	
	JButton run = new JButton("Choisir l'affichage");

	//d�finir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelDuBas = new JPanel(myCardLayout);

	MaDemo3Frame()
	{
		super("Question d'Hermann et de Jonas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		run.addActionListener(this);
		add(run, "North");		
		
		pnlI.add(new JLabel("I-Le voici!"));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel( "A-Le voil�!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("�a marche"));
		
		pnlE.add(new JLabel("Euh..."));
		//pour l'exemple un autre composant ici aussi
		pnlE.add(new JCheckBox("Demo3"));
		
		add(panelDuBas, "South");
		
		ArrayList<String> listeTexte = new ArrayList<>();
		listerComposants(pnlI, listeTexte);
		listerComposants(pnlA, listeTexte);
		listerComposants(pnlE, listeTexte);
		listeLabels = (String[])(listeTexte.toArray(new String[listeTexte.size()]));
		
		// add successifs sur le m�me panel
		// empil�s gr�ce au CardLayout
		// on ne voit que le premier
		panelDuBas.add(pnlI, "I"); // le deuxi�me argument sert � d�signer le panel
		panelDuBas.add(pnlA, "A");
		panelDuBas.add(pnlE, "E");
	}
	
	private static void listerComposants(JPanel jp, ArrayList<String> listeTexte)
	{
		
		Component[] liste = jp.getComponents();
		for ( Component comp : liste )
			if ( comp.getClass().getName().toString().equals("javax.swing.JLabel") )
				listeTexte.add(((JLabel)comp).getText());
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// null pour centrer au milieu de l'�cran quelle que soit la position de la fen�tre
		// this pour centrer au lieu de la fen�tre elle-m�me
		String r�ponse = (String)JOptionPane.showInputDialog(null /*this*/, "Choisissez votre affichage", "Petite question", JOptionPane.QUESTION_MESSAGE, null, listeLabels, listeLabels[0]);
				
		if ( r�ponse == null )
			;//rien � changer car l'utilisateur n'a rien demand�
		else if ( r�ponse.equals(listeLabels[0]) ) 
		{
        	myCardLayout.show(panelDuBas, "I");// o� = 1er argument, quoi = 2�me
		}
        else if ( r�ponse.equals(listeLabels[1]) ) 
		{
        	myCardLayout.show(panelDuBas, "A");// o� = 1er argument, quoi = 2�me
		}
		else  //forc�ment r�ponse.equals(listeLabels[2])
		{
        	myCardLayout.show(panelDuBas, "E");// o� = 1er argument, quoi = 2�me			
		}
	}
}