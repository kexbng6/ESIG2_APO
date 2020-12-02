import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        //Make sure we have nice window decorations.
//        JFrame.setDefaultLookAndFeelDecorated(true);//propre � 1.4
//        JDialog.setDefaultLookAndFeelDecorated(true);//propre � 1.4

        //Create and set up the window.
        FileChooser frame = new FileChooser("Sélectionnez un fichier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.pack();


        frame.setVisible(true);
    }


}
