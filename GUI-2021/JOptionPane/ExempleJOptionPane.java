import javax.swing.JOptionPane;



class ExempleJOptionPane
{
	public static void main(String[] arg)
	{
	// d�monstration des diff�rents cas possibles :
	
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
		JOptionPane.showMessageDialog(null, "ERROR", "D�mo", JOptionPane.ERROR_MESSAGE); 
		JOptionPane.showMessageDialog(null, "INFORMATION", "D�mo", JOptionPane.INFORMATION_MESSAGE); 
		JOptionPane.showMessageDialog(null, "WARNING", "D�mo", JOptionPane.WARNING_MESSAGE); 
		JOptionPane.showMessageDialog(null, "QUESTION", "D�mo", JOptionPane.QUESTION_MESSAGE); 
		JOptionPane.showMessageDialog(null, "PLAIN", "D�mo", JOptionPane.PLAIN_MESSAGE); 
	}
	
	static void confirmDialog() // sans gestion de la valeur de retour
	{
		JOptionPane.showConfirmDialog(null, "mon message", "ma D�mo", JOptionPane.YES_NO_OPTION);
		JOptionPane.showConfirmDialog(null, "mon message", "ma D�mo", JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	static void confirmDialogAvecTestDeLaValeurDeRetour()
	{
		int returnValue = JOptionPane.showConfirmDialog(null, "mon message", "ma D�mo", JOptionPane.YES_NO_CANCEL_OPTION);
		switch ( returnValue )
		{
			case JOptionPane.YES_OPTION : System.out.println("oui ou Ok"); break;
			//�quivalent � JOptionPane.OK_OPTION 
			case JOptionPane.NO_OPTION : System.out.println("non"); break;
			case JOptionPane.CANCEL_OPTION : System.out.println("cancel"); break;
 			case JOptionPane.CLOSED_OPTION : System.out.println("closed"); break;
		}
	}
	
	static void inputDialogDeBase()
	{
		String s = JOptionPane.showInputDialog(null, "Entrez une valeur", "Saisir ici");
		if ( s == null )
			System.out.println("l'utilisateur n'a pas valid�");
		else
			if ( s.equals("") )
				System.out.println ("l'utilisateur a saisi une cha�ne vide");
			else
				System.out.println(s);
	}
	
	static void inputDialogAvecListBox()
	{
		Object[] valeursPossibles = { "Um", "Dois", "Tr�s" };
		Object valeurChoisie = 
		    JOptionPane.showInputDialog(null, "Votre choix",
			    					   "D�mo de saisie",
									   JOptionPane.INFORMATION_MESSAGE, 
									   null,
									   valeursPossibles, 
									   valeursPossibles[1]); // le dernier param�tre = valeur par d�faut, null prend la premi�re*/
		if ( valeurChoisie == null )
			System.out.println("l'utilisateur n'a pas valid�");
		else
			//System.out.println(valeurChoisie);//valeurChoisie est de type Object � cause de showInputDialog								   
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
			System.out.println("l'utilisateur n'a pas valid�");
		else
			System.out.println ("Bouton num�ro "+returnValue+" dont le texte �tait "+options[returnValue]);
	}
}