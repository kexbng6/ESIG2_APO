import javax.swing.JFileChooser;
import java.io.File;

class DemoTexteJFileChooser
{
	public static void main (String[] args) 
	{
		//JFileChooser jfc = new JFileChooser(); // par d�faut s'ouvre dans (Mes) Documents
		JFileChooser jfc = new JFileChooser("G:\\ESIG Distribution\\2020_2021\\ESIG-2\\APO\\GUI-2021\\Exemples s�lection fichiers");
		// s'ouvre directement dans ce r�pertoire : G:\\ESIG Distribution\\2018_2019\\ESIG-2\\APO\\GUI-2019\\Exemples s�lection fichiers
		
		
		// par d�faut c'est s�lection simple de fichiers
		
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // pour ne s�lectionner que des r�pertoires;
		//autres possibilit�s : JFileChooser.FILES_ONLY (par d�faut) ou JFileChooser.FILES_AND_DIRECTORIES
		
		int actionUtilisateur = jfc.showOpenDialog(null); // null car hors interface graphique Open == Ouvrir (fichiers ou r�pertoires)
		/*int*/ actionUtilisateur = jfc.showSaveDialog(null); // null car hors interface graphique
		/*int*/ actionUtilisateur = jfc.showDialog(null, "Juste fais-le"); // Pour avoir autre chose ou Ouvrir ou Enregistrer
		
		if ( actionUtilisateur == JFileChooser.APPROVE_OPTION) // l'utilisateur a bien choisi qq chose
		{
			File fichierChoisi = jfc.getSelectedFile(); // dans le cas de la s�lection simple - 1 seul fichier (ou r�pertoire)
			//File[] fichierChoisi = jfc.getSelectedFiles(); // dans le cas de la s�lection multiple - plusieurs fichier (ou r�pertoire)
			System.out.println ("vous avez choisi : "+fichierChoisi);
			if ( fichierChoisi.isDirectory() )
				System.out.println ("C'est un r�pertoire (ou dossier)");
			else
				System.out.println ("C'est un simple fichier");
			System.out.println ();
		}
		else // sinon l'utilisateur a annul�
			System.out.println ("L'utilisateur a annul�");
	}
}