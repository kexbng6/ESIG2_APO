import java.awt.*;


class Fenetre extends Frame 
{
	static final int NB_BOUTONS = 5; // déclaration d'une constante de type int
	Button[] mesBoutons = new Button[NB_BOUTONS]; // mes boutons est un tableau de Button
	String[] mesTitres = {"OK", "Quitter", "Editer", "Annuler", "Autre"};

	public Fenetre(String aTitle)
	{
		setTitle(aTitle);

		// Changer le Layout "Manager par défaut" à GridLayout:
		// Définition d'un "Grid" de n lignes et 3 colonnes:
		setLayout(new GridLayout(0, 3));

		for (int numBouton = 0; numBouton < mesBoutons.length; numBouton++)
		{  
			mesBoutons[numBouton] = new Button(mesTitres[numBouton]);
		    add(mesBoutons[numBouton]);
		}
	}
}


public class Exemple04bisAWT
{
	public static void main (String [] args)
	{
		Fenetre f=new Fenetre("Exemple04 bis - AWT");
		f.pack();
		f.setVisible(true);
	}
}
