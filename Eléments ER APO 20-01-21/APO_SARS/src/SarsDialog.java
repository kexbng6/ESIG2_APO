import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class SarsDialog extends JDialog
{
    private static String MESSAGE_OUBLI = "Vous avez oublié d'appeler assign()";
    private static String valArg = MESSAGE_OUBLI;

    String[] tabValeurs = {"40", "60", "80", "100", "120",
            "-40", "-60", "-80", "-100", "-120",
            "30", "45", "60", "75", "90",
            "-30", "-45", "-60", "-75", "-90",
            "", "", "0", "", "" };
    ArrayList<String> listeValeurs = new ArrayList<String>(Arrays.asList(tabValeurs));

    SarsDialog(String title)
    {
        super((Frame)null, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    static String yield(String title)
    {
        DialogueSaisie ds = new DialogueSaisie(title);
        ds.pack();
        ds.setLocationRelativeTo(null);
        ds.setVisible(true);
        String result = valArg;
        valArg = MESSAGE_OUBLI;
        return result;
    }

    void assign(String v)
    {
        valArg = v;
    }
}
