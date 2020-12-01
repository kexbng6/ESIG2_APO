import javax.swing.JOptionPane;

class HelloJOptionPane
{
	public static void main (String[] args) 
	{
		unSeulTour();
		//enBoucle();
	}
	
	static void unSeulTour()
	{
		String réponse = JOptionPane.showInputDialog(null, "Comment t'appelles-tu ?", "Bonjour !", JOptionPane.QUESTION_MESSAGE);
		if ( réponse != null )
		{
			String réponseAge = JOptionPane.showInputDialog(null, "Quel âge as-tu ?", "Bonjour "+réponse, JOptionPane.QUESTION_MESSAGE);
			if ( réponseAge != null )
			{
				int confirmation = JOptionPane.showConfirmDialog(null, "Donc tu es "+réponse+" et tu as "+réponseAge+" ans ", 
					                                                   "A confirmer", JOptionPane.YES_NO_OPTION);
				if ( confirmation == JOptionPane.YES_OPTION )
					JOptionPane.showMessageDialog(null, "OK !", "C'est tout bon", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Même joueur joue encore...", "Aïe !", JOptionPane.WARNING_MESSAGE);
			}
		}		
	}
	
	static void enBoucle()
	{
		String réponse = null;
		String réponseAge = null;
		do
		{
			réponse = JOptionPane.showInputDialog(null, "Comment t'appelles-tu ?", "Bonjour !", JOptionPane.QUESTION_MESSAGE);
			if ( réponse != null )
			{
				réponseAge = JOptionPane.showInputDialog(null, "Quel âge as-tu ?", "Bonjour "+réponse, JOptionPane.QUESTION_MESSAGE);	
			}
		}
		while ( réponseAge == null );
		int confirmation = JOptionPane.showConfirmDialog(null, "Donc tu es "+réponse+" et tu as "+réponseAge+" ans ", 
			                                                   "A confirmer", JOptionPane.YES_NO_OPTION);
		if ( confirmation == JOptionPane.YES_OPTION )
			JOptionPane.showMessageDialog(null, "OK !", "C'est tout bon", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Même joueur joue encore...", "Aïe !", JOptionPane.WARNING_MESSAGE);
				
	}
}