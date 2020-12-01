import java.awt.*;

class Fenetre extends Frame 
{
	Button ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Ajout des boutons
		// positionnement par défaut à l'aide du BorderLayout 
		// 5 positions possibles (par défaut au centre) :
		ok = new Button("OK");
		add(ok, "North");
		quitter = new Button("Quitter");
		add(quitter, "South");
		editer = new Button("Editer");
		add(editer, "East");
		autre = new Button("Autre");
		add(autre, "Center");
		annuler = new Button("Annuler");
		add(annuler, "West");
	}
}


public class Exemple02AWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 2 - AWT");
		f.pack();
		f.setVisible(true);
	}
}
