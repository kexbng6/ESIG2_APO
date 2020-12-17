import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BinApoFen extends JFrame implements ActionListener
{
    public static final int TAILLE_GRILLE = 8;
    public static final File REP_DEPART = new File("Grilles");
    public JButton lireBtn, figerBtn, enregistrerBtn, resoudreBtn, partie_IIBtn, testBtn, razBtn, quitterBtn;
    public JTextArea log;
    public JFileChooser fc;

    BinApoPanel[][] grille = new BinApoPanel[TAILLE_GRILLE][TAILLE_GRILLE];

    BinApoFen(String titre)
    {
        super(titre);

        JPanel zoBtnHaut = new JPanel();
        JPanel zoBtnBas = new JPanel();


        lireBtn = new JButton("Lire");
        lireBtn.addActionListener(this);
        zoBtnHaut.add(lireBtn);

        figerBtn = new JButton("Figer");
        figerBtn.addActionListener(this);
        figerBtn.setEnabled(false);
        zoBtnHaut.add(figerBtn);

        enregistrerBtn = new JButton("Enregistrer");
        enregistrerBtn.addActionListener(this);
        enregistrerBtn.setEnabled(false);
        zoBtnHaut.add(enregistrerBtn);


        resoudreBtn = new JButton("Resoudre");
        resoudreBtn.addActionListener(this);
        resoudreBtn.setEnabled(false);
        zoBtnHaut.add(resoudreBtn);

        partie_IIBtn = new JButton("Partie II");
        partie_IIBtn.addActionListener(this);
        zoBtnBas.add(partie_IIBtn);

        testBtn = new JButton("Tester");
        testBtn.addActionListener(this);
        zoBtnBas.add(testBtn);

        razBtn = new JButton("RAZ");
        razBtn.addActionListener(this);
        zoBtnBas.add(razBtn);

        quitterBtn = new JButton("Quitter");
        quitterBtn.addActionListener(this);
        zoBtnBas.add(quitterBtn);


        add(zoBtnHaut, "North");//BorderLayout.PAGE_START);//propre � 1.4
        add(zoBtnBas, "South");//BorderLayout.CENTER);//propre � 1.4


        log = new JTextArea(5,5);
        add(log);
        log.setEditable(false);

        fc = new JFileChooser("../");
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lireBtn) {
            int returnVal = fc.showOpenDialog(null);//null centre sur l'�cran
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                figerBtn.setEnabled(true);
                enregistrerBtn.setEnabled(true);
                resoudreBtn.setEnabled(true);
                log.setText(file.toString());





            }
        }
    }
}