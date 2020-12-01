import javax.swing.*;


class Fenetre extends JFrame // toujours subclassing
{
	JButton ok;
	
	Fenetre(String unTitre)
	{
		setTitle(unTitre); // super(unTitre); va bien aussi
		ok = new JButton("OK");
    	add(ok);
		
		/* anciennement getContentPane().add(ok);*/ // ajout du composant au contentPane
		// appel à getContentPane() facultatif depuis JDK 1.5
		// ou bien
		// java.awt.Container monContentPane = getContentPane();
		// monContentPane.add(ok);
	}
}

public class Exemple01Swing
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 1 - Swing");
		f.pack(); // plus simple setLocation + setSize
		f.setVisible(true);
	}
}
