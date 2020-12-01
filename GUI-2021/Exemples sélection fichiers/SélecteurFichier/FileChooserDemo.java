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
public class FileChooserDemo extends JPanel
                             implements ActionListener 
{
    static private final String NEWLINE = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public FileChooserDemo() 
    {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Open a File...",
                                 createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Save a File...",
                                 createImageIcon("images/Save16.gif"));
        saveButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, "North");//BorderLayout.PAGE_START);//propre à 1.4
        add(logScrollPane, "South");//BorderLayout.CENTER);//propre à 1.4
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == openButton) //Handle open button action.
        {
            int returnVal = fc.showOpenDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            	{
	                File file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	                log.append("Opening: " + file.getName() + "." + NEWLINE);
         		}
        	else 
                log.append("Open command cancelled by user." + NEWLINE);
        } 
        else if (e.getSource() == saveButton) //Handle save button action.
        {
            int returnVal = fc.showSaveDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + NEWLINE);
            }
            else 
                log.append("Save command cancelled by user." + NEWLINE);
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) 
    {
        java.net.URL imgURL = FileChooserDemo.class.getResource(path);
        if (imgURL != null) 
            return new ImageIcon(imgURL);
        else 
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) 
    {
        //Make sure we have nice window decorations.
        // JFrame.setDefaultLookAndFeelDecorated(false);//propre à 1.4
        // JDialog.setDefaultLookAndFeelDecorated(true);//propre à 1.4

        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new FileChooserDemo();
        newContentPane.setOpaque(false);
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
