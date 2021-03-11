
class CopieSurTriArbo
{
	static final int[] tabEnt = { 15, 115, 21, 35, 105, 10, 137, 8, 23};//{7, 31, 500, 5, 28, 50, -94, -12, -42, 6, -178, 2, 0, 30};
	
	public static void main (String[] args)
    {
    	ArbreBinaire arbo = new ArbreBinaire();
    	
    	for(int nombre : tabEnt)
    		arbo.ajouter(nombre);
    	
    	System.out.println ("Original (avant)");
    	arbo.afficher();

//		// copie superficielle (shallow copy)
//		// arbo et copie désignent le même endroit en mémoire	
//		ArbreBinaire copie = arbo;
//		copie.racine.filsDroit.valeur = 32;

		//copie "vraie" profonde (deep copy)
		ArbreBinaire copieVraie = arbo.copierArbre();    	
		copieVraie.racine.filsDroit.valeur = 32;
		
		System.out.println (); System.out.println ("Copie vraie");
		copieVraie.afficher();

    	System.out.println (); System.out.println ("Original (après)");
    	arbo.afficher();
//    	System.out.println ("--");
//    	copie.afficher();
    }
}

class Noeud
{
	int valeur;
	Noeud filsGauche, filsDroit;
	
	Noeud(int valeur)
	{
		this.valeur = valeur;
		filsGauche = null;
		filsDroit = null;
	}
	
	public String toString()
	{
		return valeur+"";
	}
	
	void afficher()
	{
		if ( filsGauche != null )
			filsGauche.afficher();
		System.out.println (valeur);
		if ( filsDroit != null )
			filsDroit.afficher();		
	}
	
	void ajouter(int nombre)
	{
		if ( nombre < valeur )
			if ( filsGauche == null )
				filsGauche = new Noeud(nombre);
			else
				filsGauche.ajouter(nombre);
		else
			if ( filsDroit == null )
				filsDroit = new Noeud(nombre);
			else
				filsDroit.ajouter(nombre);
	}
	
	Noeud copierNoeud()
	{
		Noeud copie = new Noeud(valeur);
		if ( filsGauche != null )
			copie.filsGauche = filsGauche.copierNoeud();
		if ( filsDroit != null )
			copie.filsDroit = filsDroit.copierNoeud();
		return copie;
	}
}

class ArbreBinaire
{
	Noeud racine;
	
	ArbreBinaire()
	{
		racine = null;
	}
	
	boolean estVide()
	{
		return racine == null;
	}
	
	void afficher()// de la classe ArbreBinaire
	{
		if ( estVide() )
			System.out.println ("Arbre vide !");
		else
			racine.afficher();//affichage dans la classe Noeud
	}
	
	void ajouter(int nombre)//de la classe ArbreBinaire
	{
		if ( estVide() )
			racine = new Noeud(nombre);
		else
			racine.ajouter(nombre);//ajout dans la classe Noeud
	}
	
	ArbreBinaire copierArbre()
	{
		if ( estVide() )
		{
			ArbreBinaire copie = new ArbreBinaire();
			return copie;
		}
		else
		{
			ArbreBinaire copie = new ArbreBinaire();
			copie.racine = racine.copierNoeud();
			return copie;
		}
		//version courte et condensée
//		ArbreBinaire copie = new ArbreBinaire();
//		if ( !estVide() )
//			copie.racine = racine.copierNoeud();
//		return copie;
	}
}
