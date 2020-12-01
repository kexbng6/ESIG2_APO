import java.awt.*; 

class  Exemple00AWT
{
	static void afficheAWT()
	{	
		Frame f = new Frame("Voici le titre");
		f.setSize(300, 600);
		f.setLocation(30, 10);
		f.setBackground(Color.BLUE);
		f.setVisible(true);
    }
      

	static void afficheAWTWindow() // intérêt très limité
	{	
		Window f = new Window(new Frame());
		f.setSize(300, 300);
		f.setLocation(100, 200);
		f.setBackground(Color.YELLOW);
		f.setVisible(true);
	}

 
	public static void main(String[] args) 
	{
		System.out.println("Enfin du graphique");
		afficheAWT();
		//afficheAWTWindow();
	}
	// A RETENIR : différence entre Window et Frame en AWT
}
