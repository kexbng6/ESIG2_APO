import javax.swing.JFileChooser;
import java.io.File;

class DemoTexteJFileChooser
{
	public static void main (String[] args) 
	{
		//JFileChooser jfc = new JFileChooser(); // par défaut s'ouvre dans (Mes) Documents
		JFileChooser jfc = new JFileChooser("G:\\ESIG Distribution\\2020_2021\\ESIG-2\\APO\\GUI-2021\\Exemples sélection fichiers");
		// s'ouvre directement dans ce répertoire : G:\\ESIG Distribution\\2018_2019\\ESIG-2\\APO\\GUI-2019\\Exemples sélection fichiers
		
		
		// par défaut c'est sélection simple de fichiers
		
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // pour ne sélectionner que des répertoires;
		//autres possibilités : JFileChooser.FILES_ONLY (par défaut) ou JFileChooser.FILES_AND_DIRECTORIES
		
		int actionUtilisateur = jfc.showOpenDialog(null); // null car hors interface graphique Open == Ouvrir (fichiers ou répertoires)
		/*int*/ actionUtilisateur = jfc.showSaveDialog(null); // null car hors interface graphique
		/*int*/ actionUtilisateur = jfc.showDialog(null, "Juste fais-le"); // Pour avoir autre chose ou Ouvrir ou Enregistrer
		
		if ( actionUtilisateur == JFileChooser.APPROVE_OPTION) // l'utilisateur a bien choisi qq chose
		{
			File fichierChoisi = jfc.getSelectedFile(); // dans le cas de la sélection simple - 1 seul fichier (ou répertoire)
			//File[] fichierChoisi = jfc.getSelectedFiles(); // dans le cas de la sélection multiple - plusieurs fichier (ou répertoire)
			System.out.println ("vous avez choisi : "+fichierChoisi);
			if ( fichierChoisi.isDirectory() )
				System.out.println ("C'est un répertoire (ou dossier)");
			else
				System.out.println ("C'est un simple fichier");
			System.out.println ();
		}
		else // sinon l'utilisateur a annulé
			System.out.println ("L'utilisateur a annulé");
	}
}