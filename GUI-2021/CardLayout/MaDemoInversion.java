import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MaDemo
{
	public static void main (String[] args) 
    {
		MaDemoFrame mdf = new MaDemoFrame();
		mdf.pack();
		mdf.setVisible(true);
    }
}

class MaDemoFrame extends JFrame implements ActionListener
{
	JPanel pnlI = new JPanel();
	JPanel pnlA = new JPanel();
	JPanel pnlIBis = new JPanel();
	JPanel pnlABis = new JPanel();
	JButton run = new JButton("Inverser");

	//définir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelCôtéHaut = new JPanel(myCardLayout);
	JPanel panelCôtéBas = new JPanel(myCardLayout);

	boolean onOff = false;
	
	
	MaDemoFrame()
	{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 2));//, 0, 5));
		
		run.addActionListener(this);
		add(run);
		
		JPanel panelCôté = new JPanel(new GridLayout(2, 0));//, 5, 0));
		panelCôté.add(panelCôtéHaut);
		panelCôté.add(panelCôtéBas);
		add(panelCôté);
				
		pnlI.add(new JLabel("I-Le voici!"));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel("A-Le voilà!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("ça marche"));


		pnlIBis.add(new JLabel("IBis-Le voici!"));
		//pour l'exemple un autre composant
		pnlIBis.add(new JButton("testBis"));
		
		pnlABis.add(new JLabel("ABis-Le voilà!"));
		//pour l'exemple un autre composant ici aussi
		pnlABis.add(new JTextField("ça marche bis"));		
		// add successifs sur le même panel
		// empilés grâce au CardLayout
		// on ne voit que le premier
		panelCôtéHaut.add(pnlI, "I"); // le deuxième argument sert à désigner le panel
		panelCôtéHaut.add(pnlA, "A");
		
		panelCôtéBas.add(pnlABis, "ABis");
		panelCôtéBas.add(pnlIBis, "IBis"); 
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		onOff = !onOff;
		if ( onOff ) 
		{
        	myCardLayout.show(panelCôtéBas, "IBis");// où = 1er argument, quoi = 2ème
        	myCardLayout.show(panelCôtéHaut, "A");
		}

        else
		{
        	myCardLayout.show(panelCôtéBas, "ABis");// où = 1er argument, quoi = 2ème
        	myCardLayout.show(panelCôtéHaut, "I");
		}
	}
}