class DemoAveugle
{
	public static void main(String[] args)
	{
		System.out.println("Coucou");
		System.out.println("il y a "+args.length+" arguments sur la ligne de commande qui sont : ");
		for (String s : args)
			System.out.println(s);
	}
	
}