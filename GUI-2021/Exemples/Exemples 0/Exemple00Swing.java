import javax.swing.*;

class  Exemple00Swing
{
	static void afficheSwing()
	{	
		JFrame jf = new JFrame("Voici le titre");
		jf.setSize(300, 300);
		jf.setLocation(100, 100);
		//jf.getContentPane().setBackground(java.awt.Color.CYAN);
		//jf.setBackground(java.awt.Color.CYAN);
		// getContentPane obligatoire ici !!
		jf.setVisible(true);
	}

	static void afficheSwingWindow() //intérêt limité
	{	
		JWindow f = new JWindow();// pas de titre possible !
		f.setSize(300, 300);
		f.setLocation(100, 100);
		f.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enfin du graphique");
		afficheSwing();
		//afficheSwingWindow();
	}
}
