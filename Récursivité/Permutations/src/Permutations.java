public class Permutations
{
    public static void main(String[] args)
    {
            afficherPermut("ABCD", "");

    }

    private static void afficherPermut(String s, String prefixe)
    {
        if ( s.length() <= 1 )
            System.out.println(prefixe+s);
        else
        {
            for (int pos = 0; pos < s.length(); pos++)
            {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(pos);
                afficherPermut(sb.toString(), prefixe + s.charAt(pos));
            }
        }
    }
}
