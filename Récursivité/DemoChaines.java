class DemoChaines
{
	public static void main (String[] args)
    {
    	
	   	String pasJuste = "Je suis dipl�m�e� ESSIG";
//    	System.out.println (pasJuste.indexOf("S"));//=20
 





 
  
    	//Comment supprimer le caract�re en position 20 ?
    	
    	//premi�re solution : prendre les cha�nes avant et apr�s puis les concat�ner
    	//cette solution n'utilise que la classe String
    	int posCarASupprimer = pasJuste.indexOf("S");
    	String avant = pasJuste.substring(0, posCarASupprimer);//caract�res de 0 � posCarAsupprimer -1 (ne pas oublier MOINS UN)
    	String apr�s = pasJuste.substring(posCarASupprimer+1);////caract�res de posCarAsupprimer+1 jusqu'� la fin
    	String corrig�1 = avant+apr�s;
    	System.out.println (corrig�1);
    	
    	

    	
//    	//deuxi�me solution : supprimer le caract�re gr�ce � une m�thode de StringBuilder OU StringBuffer
		StringBuilder sb = new StringBuilder(pasJuste);
    	//StringBuffer sb = new StringBuffer(pasJuste);
    	sb.deleteCharAt(posCarASupprimer);
    	String corrig�2 = sb.toString();
    	System.out.println (corrig�2);
    	
    	//les versions courtes
    	System.out.println (pasJuste.substring(0, posCarASupprimer)+pasJuste.substring(posCarASupprimer+1));
    	System.out.println (new StringBuilder(pasJuste).deleteCharAt(posCarASupprimer).toString());
   
    }
}