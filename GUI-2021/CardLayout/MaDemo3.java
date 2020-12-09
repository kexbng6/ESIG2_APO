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

	//définir un layoutManager de type CardLayout
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
		
		pnlA.add(new JLabel("A-Le voilà!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("ça marche"));
		
		pnlE.add(new JLabel("Euh..."));
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
		codePanel++;
		if ( codePanel == 3 ) codePanel = 0;
		
		if ( codePanel == 0 ) 
		{
        	myCardLayout.show(panelDuBas, "I");// où = 1er argument, quoi = 2ème
			run.setText("Cacher I-Voir A");
		}

        else if ( codePanel == 1 ) 
		{
        	myCardLayout.show(panelDuBas, "A");// où = 1er argument, quoi = 2ème
			run.setText("Cacher A-Voir E");
		}
		else  //forcément codePanel == 2
		{
        	myCardLayout.show(panelDuBas, "E");// où = 1er argument, quoi = 2ème			
        	run.setText("Cacher E-Voir I");
		}
	}
}