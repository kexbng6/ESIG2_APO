import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FenSaisie extends JFrame implements ActionListener
{
    private static final String NL = System.lineSeparator();
    private static final String MESSAGE_DEPART = "from gturtle import *";

    FenSaisie()
    {
        super("Saisie Accélérée des Rendus Studieux - version écrite par <votre nom ici>");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
    }

    private void aff(JTextArea jta, String s)
    {
        aff(jta, s, 0);
    }

    private void aff(JTextArea jta, String s, int indent)
    {
        for (int i = 0; i < indent; i++)
            jta.append(" ");
        jta.append(s+NL);
    }
}
