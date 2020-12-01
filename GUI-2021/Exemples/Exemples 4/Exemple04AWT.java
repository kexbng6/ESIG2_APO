import java.awt.*;

class Fenetre extends Frame 
{
	Button ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Changer le Layout Manager par défaut à GridLayout
		// définition d'une grille (grid) de 3 lignes et n colonnes:
		 setLayout(new GridLayout(3, 0));
		// définition d'une grille (grid) de n lignes et 3 colonnes:
		//setLayout(new GridLayout(0, 3));
		
		
		ok = new Button("OK");
		add(ok);
		quitter = new Button("Quitter");
		add(quitter);
		editer = new Button("Editer");
		add(editer);
		annuler = new Button("Annuler");
		add(annuler);
		autre = new Button("Autre");
		add(autre);
	}
}


public class Exemple04AWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 4 - AWT");
		f.pack();
		f.setVisible(true);
	}
}

