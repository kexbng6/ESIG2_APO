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
	JButton run = new JButton("Cacher I-Voir A");

	//d�finir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelDuBas = new JPanel(myCardLayout);

	int codePanel = 0;
	
	
	MaDemo3Frame()
	{
		super("Question d'Hermann");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		run.addActionListener(this);
		add(run, "North");		
		
		pnlI.add(new JLabel("I-Le voici!"));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel("A-Le voil�!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("�a marche"));
		
		pnlE.add(new JLabel("Euh..."));
		//pour l'exemple un autre composant ici aussi
		pnlE.add(new JCheckBox("Demo3"));
		
		add(panelDuBas, "South");
		
		// add successifs sur le m�me panel
		// empil�s gr�ce au CardLayout
		// on ne voit que le premier
		panelDuBas.add(pnlI, "I"); // le deuxi�me argument sert � d�signer le panel
		panelDuBas.add(pnlA, "A");
		panelDuBas.add(pnlE, "E");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		codePanel++;
		if ( codePanel == 3 ) codePanel = 0;
		
		if ( codePanel == 0 ) 
		{
        	myCardLayout.show(panelDuBas, "I");// o� = 1er argument, quoi = 2�me
			run.setText("Cacher I-Voir A");
		}

        else if ( codePanel == 1 ) 
		{
        	myCardLayout.show(panelDuBas, "A");// o� = 1er argument, quoi = 2�me
			run.setText("Cacher A-Voir E");
		}
		else  //forc�ment codePanel == 2
		{
        	myCardLayout.show(panelDuBas, "E");// o� = 1er argument, quoi = 2�me			
        	run.setText("Cacher E-Voir I");
		}
	}
}