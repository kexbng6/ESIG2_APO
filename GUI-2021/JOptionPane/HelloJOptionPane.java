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
		String r�ponse = JOptionPane.showInputDialog(null, "Comment t'appelles-tu ?", "Bonjour !", JOptionPane.QUESTION_MESSAGE);
		if ( r�ponse != null )
		{
			String r�ponseAge = JOptionPane.showInputDialog(null, "Quel �ge as-tu ?", "Bonjour "+r�ponse, JOptionPane.QUESTION_MESSAGE);
			if ( r�ponseAge != null )
			{
				int confirmation = JOptionPane.showConfirmDialog(null, "Donc tu es "+r�ponse+" et tu as "+r�ponseAge+" ans ", 
					                                                   "A confirmer", JOptionPane.YES_NO_OPTION);
				if ( confirmation == JOptionPane.YES_OPTION )
					JOptionPane.showMessageDialog(null, "OK !", "C'est tout bon", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "M�me joueur joue encore...", "A�e !", JOptionPane.WARNING_MESSAGE);
			}
		}		
	}
	
	static void enBoucle()
	{
		String r�ponse = null;
		String r�ponseAge = null;
		do
		{
			r�ponse = JOptionPane.showInputDialog(null, "Comment t'appelles-tu ?", "Bonjour !", JOptionPane.QUESTION_MESSAGE);
			if ( r�ponse != null )
			{
				r�ponseAge = JOptionPane.showInputDialog(null, "Quel �ge as-tu ?", "Bonjour "+r�ponse, JOptionPane.QUESTION_MESSAGE);	
			}
		}
		while ( r�ponseAge == null );
		int confirmation = JOptionPane.showConfirmDialog(null, "Donc tu es "+r�ponse+" et tu as "+r�ponseAge+" ans ", 
			                                                   "A confirmer", JOptionPane.YES_NO_OPTION);
		if ( confirmation == JOptionPane.YES_OPTION )
			JOptionPane.showMessageDialog(null, "OK !", "C'est tout bon", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "M�me joueur joue encore...", "A�e !", JOptionPane.WARNING_MESSAGE);
				
	}
}