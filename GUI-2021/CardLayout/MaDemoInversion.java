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

	//d�finir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelC�t�Haut = new JPanel(myCardLayout);
	JPanel panelC�t�Bas = new JPanel(myCardLayout);

	boolean onOff = false;
	
	
	MaDemoFrame()
	{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 2));//, 0, 5));
		
		run.addActionListener(this);
		add(run);
		
		JPanel panelC�t� = new JPanel(new GridLayout(2, 0));//, 5, 0));
		panelC�t�.add(panelC�t�Haut);
		panelC�t�.add(panelC�t�Bas);
		add(panelC�t�);
				
		pnlI.add(new JLabel("I-Le voici!"));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel("A-Le voil�!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("�a marche"));


		pnlIBis.add(new JLabel("IBis-Le voici!"));
		//pour l'exemple un autre composant
		pnlIBis.add(new JButton("testBis"));
		
		pnlABis.add(new JLabel("ABis-Le voil�!"));
		//pour l'exemple un autre composant ici aussi
		pnlABis.add(new JTextField("�a marche bis"));		
		// add successifs sur le m�me panel
		// empil�s gr�ce au CardLayout
		// on ne voit que le premier
		panelC�t�Haut.add(pnlI, "I"); // le deuxi�me argument sert � d�signer le panel
		panelC�t�Haut.add(pnlA, "A");
		
		panelC�t�Bas.add(pnlABis, "ABis");
		panelC�t�Bas.add(pnlIBis, "IBis"); 
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		onOff = !onOff;
		if ( onOff ) 
		{
        	myCardLayout.show(panelC�t�Bas, "IBis");// o� = 1er argument, quoi = 2�me
        	myCardLayout.show(panelC�t�Haut, "A");
		}

        else
		{
        	myCardLayout.show(panelC�t�Bas, "ABis");// o� = 1er argument, quoi = 2�me
        	myCardLayout.show(panelC�t�Haut, "I");
		}
	}
}