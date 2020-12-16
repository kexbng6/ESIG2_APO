import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinApoFen extends JFrame implements ActionListener
{
    public static final int TAILLE_GRILLE = 8;
    public static final File REP_DEPART = new File("Grilles");
    public JButton LireBtn, FigerBtn, EnregistrerBtn, ResoudreBtn, Partie_IIBtn, TesterBtn, RAZBtn, QuitterBtn;
    public JTextArea log;

    BinApoPanel[][] grille = new BinApoPanel[TAILLE_GRILLE][TAILLE_GRILLE];

    BinApoFen(String titre)
    {
        super(titre);

        JPanel zoBtnHaut = new JPanel();
        JPanel zoBtnBas = new JPanel();


        LireBtn = new JButton("Lire");
        LireBtn.addActionListener(this);
        zoBtnHaut.add(LireBtn);

        FigerBtn = new JButton("Figer");
        FigerBtn.addActionListener(this);
        FigerBtn.setEnabled(false);
        zoBtnHaut.add(FigerBtn);

        EnregistrerBtn = new JButton("Enregistrer");
        EnregistrerBtn.addActionListener(this);
        EnregistrerBtn.setEnabled(false);
        zoBtnHaut.add(EnregistrerBtn);


        ResoudreBtn = new JButton("Resoudre");
        ResoudreBtn.addActionListener(this);
        ResoudreBtn.setEnabled(false);
        zoBtnHaut.add(ResoudreBtn);

        Partie_IIBtn = new JButton("Partie II");
        Partie_IIBtn.addActionListener(this);
        zoBtnBas.add(Partie_IIBtn);

        TesterBtn = new JButton("Tester");
        TesterBtn.addActionListener(this);
        zoBtnBas.add(TesterBtn);

        RAZBtn = new JButton("RAZ");
        RAZBtn.addActionListener(this);
        zoBtnBas.add(RAZBtn);

        QuitterBtn = new JButton("Quitter");
        QuitterBtn.addActionListener(this);
        zoBtnBas.add(QuitterBtn);


        add(zoBtnHaut, "North");//BorderLayout.PAGE_START);//propre � 1.4
        add(zoBtnBas, "South");//BorderLayout.CENTER);//propre � 1.4


        log = new JTextArea(5,5);
        add(log);
        log.setEditable(false);
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

    private void afficher(JTextArea log, String message)
    {
        log.append(message+System.lineSeparator());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
