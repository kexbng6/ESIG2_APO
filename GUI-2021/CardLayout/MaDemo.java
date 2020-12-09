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
	JButton run = new JButton("Cacher I-Voir A");

	//définir un layoutManager de type CardLayout
	//et lui donner un nom
	CardLayout myCardLayout = new CardLayout();
	JPanel panelDuBas = new JPanel(myCardLayout);

	boolean onOff = true;
	
	
	MaDemoFrame()
	{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		run.addActionListener(this);
		add(run, "North");		
		
		pnlI.add(new JLabel("I-Le voici!"));
		//pour l'exemple un autre composant
		pnlI.add(new JButton("test"));
		
		pnlA.add(new JLabel("A-Le voilà!"));
		//pour l'exemple un autre composant ici aussi
		pnlA.add(new JTextField("ça marche"));
		
		add(panelDuBas, "South");
		
		// add successifs sur le même panel
		// empilés grâce au CardLayout
		// on ne voit que le premier
		panelDuBas.add(pnlI, "I"); // le deuxième argument sert à désigner le panel
		panelDuBas.add(pnlA, "A");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		onOff = !onOff;
		if ( onOff ) 
		{
        	myCardLayout.show(panelDuBas, "I");// où = 1er argument, quoi = 2ème
			run.setText("Cacher I-Voir A");
		}

        else
		{
        	myCardLayout.show(panelDuBas, "A");// où = 1er argument, quoi = 2ème
			run.setText("Cacher A-Voir I");
		}
	}
}