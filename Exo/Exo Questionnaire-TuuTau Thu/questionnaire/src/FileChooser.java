import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/*
 * FileChooserDemo.java is a 1.4 application that uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */

class FileChooser extends JFrame implements ActionListener
{
    private static final String NEWLINE = System.lineSeparator(); // "\n" sous Windows
    private JButton openButton, saveButton;
    private JTextArea log;
    private JFileChooser fc;

    public FileChooser(String titre)
    {
        super(titre);
        //setLayout(new BorderLayout());

        //Create and set up the content pane.
        //getContentPane().setOpaque(true);

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);//5 = nb de lignes, 20 = nb de colonnes
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(true);
        JScrollPane logScrollPane = new JScrollPane(log);
        // pour l'exemple logScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Create a file chooser
        //en param�tre le r�pertoire par d�faut
        // fc = new JFileChooser("C:\\ESIGUsers");
        fc = new JFileChooser("../questionnaire");

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //fc.setMultiSelectionEnabled(true);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Ouvrir un fichier...",
                createImageIcon("../images/Open16.gif"));
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Enregistrer un fichier...",
                createImageIcon("../images/Save16.gif"));
        saveButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, "North");//BorderLayout.PAGE_START);//propre � 1.4
        add(logScrollPane, "South");//BorderLayout.CENTER);//propre � 1.4
    }


    public void actionPerformed(ActionEvent e)
    {
        //Handle open button action.
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(null);//null centre sur l'�cran
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                // log.append("Opening: " + file.getName() + "." + NEWLINE);
                for (Item i: ListItems.afficheQuestion(file)) {
                    log.append(i.toString());
                }
            }
            else
                log.append("Open command cancelled by user." + NEWLINE);


            //Handle save button action.
        } else if (e.getSource() == saveButton)
        {
            int returnVal = fc.showSaveDialog(this);//this centre sur la fen�te "parent"
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file/*.getName()*/ + "." + NEWLINE);
            }
            else
                log.append("Save command cancelled by user." + NEWLINE);
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

