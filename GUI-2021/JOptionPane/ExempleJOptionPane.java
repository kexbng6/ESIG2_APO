import javax.swing.JOptionPane;



class ExempleJOptionPane
{
	public static void main(String[] arg)
	{
	// démonstration des différents cas possibles :
	
//JOptionPane.showMessageDialog(null, "On y va ?", "ALORS...", JOptionPane.PLAIN_MESSAGE); 
	
		// messageDialog();
		// confirmDialog();
		// confirmDialogAvecTestDeLaValeurDeRetour();
		// inputDialogDeBase();
		// inputDialogAvecListBox();
			optionDialog();
	}
	
	static void messageDialog()
	{
		JOptionPane.showMessageDialog(null, "ERROR", "Démo", JOptionPane.ERROR_MESSAGE); 
		JOptionPane.showMessageDialog(null, "INFORMATION", "Démo", JOptionPane.INFORMATION_MESSAGE); 
		JOptionPane.showMessageDialog(null, "WARNING", "Démo", JOptionPane.WARNING_MESSAGE); 
		JOptionPane.showMessageDialog(null, "QUESTION", "Démo", JOptionPane.QUESTION_MESSAGE); 
		JOptionPane.showMessageDialog(null, "PLAIN", "Démo", JOptionPane.PLAIN_MESSAGE); 
	}
	
	static void confirmDialog() // sans gestion de la valeur de retour
	{
		JOptionPane.showConfirmDialog(null, "mon message", "ma Démo", JOptionPane.YES_NO_OPTION);
		JOptionPane.showConfirmDialog(null, "mon message", "ma Démo", JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	static void confirmDialogAvecTestDeLaValeurDeRetour()
	{
		int returnValue = JOptionPane.showConfirmDialog(null, "mon message", "ma Démo", JOptionPane.YES_NO_CANCEL_OPTION);
		switch ( returnValue )
		{
			case JOptionPane.YES_OPTION : System.out.println("oui ou Ok"); break;
			//équivalent à JOptionPane.OK_OPTION 
			case JOptionPane.NO_OPTION : System.out.println("non"); break;
			case JOptionPane.CANCEL_OPTION : System.out.println("cancel"); break;
 			case JOptionPane.CLOSED_OPTION : System.out.println("closed"); break;
		}
	}
	
	static void inputDialogDeBase()
	{
		String s = JOptionPane.showInputDialog(null, "Entrez une valeur", "Saisir ici");
		if ( s == null )
			System.out.println("l'utilisateur n'a pas validé");
		else
			if ( s.equals("") )
				System.out.println ("l'utilisateur a saisi une chaîne vide");
			else
				System.out.println(s);
	}
	
	static void inputDialogAvecListBox()
	{
		Object[] valeursPossibles = { "Um", "Dois", "Três" };
		Object valeurChoisie = 
		    JOptionPane.showInputDialog(null, "Votre choix",
			    					   "Démo de saisie",
									   JOptionPane.INFORMATION_MESSAGE, 
									   null,
									   valeursPossibles, 
									   valeursPossibles[1]); // le dernier paramètre = valeur par défaut, null prend la première*/
		if ( valeurChoisie == null )
			System.out.println("l'utilisateur n'a pas validé");
		else
			//System.out.println(valeurChoisie);//valeurChoisie est de type Object à cause de showInputDialog								   
			System.out.println(((String)valeurChoisie).length());								   
									
	}
	
	static void optionDialog()
	{
		Object[] options = { "Okay", "CANCELLED", "OUAIS", "NOPE"};
		int returnValue = JOptionPane.showOptionDialog(null, 
									 "Cliquer sur OK pour continuer", 
									 "Attention",
									 JOptionPane.DEFAULT_OPTION, 
									 JOptionPane.WARNING_MESSAGE,
									 null, 
									 options,
									 options[1]);
		
		if ( returnValue == JOptionPane.CLOSED_OPTION )
			System.out.println("l'utilisateur n'a pas validé");
		else
			System.out.println ("Bouton numéro "+returnValue+" dont le texte était "+options[returnValue]);
	}
}