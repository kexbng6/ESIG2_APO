import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoiteDialogue extends JDialog implements ActionListener
{
    JButton btnClose = new JButton("fermer la boîte de dialogue");
    FenPrincipale fen;
    JTextField jtf = new JTextField(20);

    BoiteDialogue(Frame d, String titreBDD)
    {
        super(d, titreBDD, true);
        fen = (FenPrincipale) d;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(jtf, "North");

        add(btnClose, "South");
        btnClose.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fen.nom= jtf.getText();
        dispose();//pour fermer juste la boîte de dialogue
    }
}
