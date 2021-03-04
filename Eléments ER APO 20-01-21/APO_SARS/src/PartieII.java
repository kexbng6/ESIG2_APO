import java.io.File;

public class PartieII
{
    public static final File REP_RENDUS = new File("Rendus");

    public static void main(String[] args)
    {

    }

    public static String findExtension(File f)
    {
        if ( f != null )
        {
            String s = f.getName();
            int posDernierPoint = s.lastIndexOf('.');
            if ( posDernierPoint == -1 ) // le fichier n'a pas d'extension
                return "";
            else
                return s.substring(posDernierPoint+1).toLowerCase();
        }
        return "";
    }
}
