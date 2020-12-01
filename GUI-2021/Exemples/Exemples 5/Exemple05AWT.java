import java.awt.*;

class Fenetre extends Frame 
{
	Button ok, quitter, editer, annuler, autre;

	public Fenetre(String unTitre)
	{
		setTitle(unTitre);

		// Utilisation d'un Panel:
		Panel p = new Panel();
		
		// ajout des boutons au Panel
		// disposition par défaut d'un Panel: FlowLayout
		// pour changer de dispositon :
		// par exemple 	
		//p.setLayout(new GridLayout(2,0));
		ok = new Button("OK");
		p.add(ok);
		quitter = new Button("Quitter");
		p.add(quitter);
		editer = new Button("Editer");
		p.add(editer);
		annuler = new Button("Annuler");
		p.add(annuler);
		autre = new Button("Autre");
		p.add(autre);
		
		// ajout du Panel à la Frame
		add(p, "North");
		
		//autres composants sur la Frame mais pas dans le Panel
		TextField t = new TextField();
		add(t, "South");
		
		TextArea ta = new TextArea("bonjour !");
		add(ta, "Center");
	}
}


public class Exemple05AWT
{
	public static void main (String[] args)
	{
		Fenetre f = new Fenetre("Exemple 5 - AWT");
		f.pack();
		f.setVisible(true);
	}
}

