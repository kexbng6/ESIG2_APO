import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class GUI extends JFrame implements ActionListener
{
    JButton somme, soustraction;
    JTextField x, y;
    JLabel resultat;

    GUI(String aTitle)
    {
        setTitle(aTitle);

        setLayout(new FlowLayout());
        somme = new JButton("+");
        somme.addActionListener(this);
        add(somme, "North");

        soustraction = new JButton("-");
        soustraction.addActionListener(this);
        add(soustraction, "South");

        x = new JTextField("",5);
        add(x);


        y = new JTextField("", 5);
        add(y);

        resultat = new JLabel("résultat");
        add(resultat);



    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource().equals(somme))
        {
            Integer xInput =  Integer.valueOf(x.getText());
            Integer yInput = Integer.valueOf(y.getText());

            Integer resSomme = xInput + yInput;

            resultat.setText(String.valueOf(resSomme));

        }
        else{
            Integer xInput =  Integer.valueOf(x.getText());
            Integer yInput = Integer.valueOf(y.getText());

            Integer resSoustra = xInput - yInput;

            resultat.setText(String.valueOf(resSoustra));
        }
    }
}