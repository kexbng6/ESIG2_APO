import java.awt.*;


class Fenetre extends Frame 
{
	Button ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Changer le Layout Manager par défaut
		// Utilisation du FlowLayout :
		setLayout(new FlowLayout());

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


public class Exemple03AWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 3 - AWT");
		f.pack();
		f.setVisible(true);
	}
}
