import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        JPanel droite = new JPanel(new BorderLayout());


        JPanel gauche = new JPanel();
        JPanel zoGauche = new JPanel();

        zoGauche.setLayout(new GridLayout(TAILLE_GRILLE, TAILLE_GRILLE));

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                grille[i][j] = new BinApoPanel(-1, i, j);
                zoGauche.add(grille[i][j]);
            }
        }

        gauche.add(zoGauche, "West");

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


        droite.add(zoBtnHaut, "North");//BorderLayout.PAGE_START);//propre � 1.4
        droite.add(zoBtnBas, "South");//BorderLayout.CENTER);//propre � 1.4


        log = new JTextArea(5,5);
        JScrollPane scrollo = new JScrollPane(log);
        droite.add(scrollo);
        log.setEditable(false);


        add(gauche,"West");
        add(droite,"East");

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


                    try (Scanner sc = new Scanner(file)) {

                        int ligne = 0;

                        while (sc.hasNextLine()) {
                            int colonne = 0;
                            String line = sc.nextLine();
                            Scanner sc2 = new Scanner(line);
                                while (sc2.hasNext()){
                                    int val = Integer.parseInt(sc.nextLine());
                                    grille[ligne][colonne].setValeur(val);
                                    colonne++;
                                }
                                ligne++;

                            //System.out.println(plan);
                        }
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("fichier non trouvé.. flute de zut =(");
                    }





            }
        }
    }
}