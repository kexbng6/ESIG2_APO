import java.awt.*;

class Fenetre extends Frame //subclassing
{
	Button ok;

	Fenetre(String unTitre)
	{
		super(unTitre); // ou setTitle(unTitre), qui revient au même ici
		ok = new Button("OK");
		add(ok); // ajout direct du composant sur la Frame
	}
}

public class Exemple01AWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 1 - AWT");
		
		f.pack(); // plus simple que setLocation + setSize, par exemple avec :
//		f.setLocation(100, 100);
//		f.setSize(50, 75);
		f.setVisible(true);

//		Fenetre g = new Fenetre("Exemple 1 (bis) - AWT");
//		
//		g.pack(); // plus simple que setLocation + setSize, par exemple avec :
//		//f.setSize(300, 300);
//		//f.setLocation(100, 100);
//		g.setVisible(true);

	}
}
