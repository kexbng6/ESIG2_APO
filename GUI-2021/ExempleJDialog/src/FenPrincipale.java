import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenPrincipale extends JFrame implements ActionListener
{
    JButton btnGo = new JButton("Go !");
    public String nom="???";

    FenPrincipale(String titre)
    {
        super(titre); // appel de la super-classe de FenPrincipale = JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnGo.addActionListener(this);
        add(btnGo);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        BoiteDialogue bdd = new BoiteDialogue(this,"Votre nom ?");
        bdd.pack();
        bdd.setVisible(true);
        System.out.println(nom);
    }
}
