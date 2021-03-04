class DemoChaines
{
	public static void main (String[] args)
    {
    	
	   	String pasJuste = "Je suis diplômé·e· ESSIG";
//    	System.out.println (pasJuste.indexOf("S"));//=20
 





 
  
    	//Comment supprimer le caractère en position 20 ?
    	
    	//première solution : prendre les chaînes avant et après puis les concaténer
    	//cette solution n'utilise que la classe String
    	int posCarASupprimer = pasJuste.indexOf("S");
    	String avant = pasJuste.substring(0, posCarASupprimer);//caractères de 0 à posCarAsupprimer -1 (ne pas oublier MOINS UN)
    	String après = pasJuste.substring(posCarASupprimer+1);////caractères de posCarAsupprimer+1 jusqu'à la fin
    	String corrigé1 = avant+après;
    	System.out.println (corrigé1);
    	
    	

    	
//    	//deuxième solution : supprimer le caractère grâce à une méthode de StringBuilder OU StringBuffer
		StringBuilder sb = new StringBuilder(pasJuste);
    	//StringBuffer sb = new StringBuffer(pasJuste);
    	sb.deleteCharAt(posCarASupprimer);
    	String corrigé2 = sb.toString();
    	System.out.println (corrigé2);
    	
    	//les versions courtes
    	System.out.println (pasJuste.substring(0, posCarASupprimer)+pasJuste.substring(posCarASupprimer+1));
    	System.out.println (new StringBuilder(pasJuste).deleteCharAt(posCarASupprimer).toString());
   
    }
}