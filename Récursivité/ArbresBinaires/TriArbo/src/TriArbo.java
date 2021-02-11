public class TriArbo
{
    public static void main(String[] args)
    {
        int[] tab = {777, 142, 666, 208, 27, 93, 12, 66, 888, 799, 800, 890 };

        Arbre a = new Arbre();
        a.parcours(); //affiche Arbre vide

        for ( int v : tab )
        {
            a.ajouter(v);
        }

        a.parcours(); // affiche les nombres dans l'ordre
        System.out.println();
        System.out.println("Nombre de noeuds : "+a.compteurNoeud()+" =?="+tab.length);
        System.out.println("somme des valeurs portées par les feuilles : "+a.sommeFeuille());
    }
}
