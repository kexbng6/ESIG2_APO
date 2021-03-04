import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class DialogueSaisie extends SarsDialog implements ActionListener
{
    DialogueSaisie(String title)
    {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
    }

    public static void main(String[] args) {
        System.out.println(yield("Pour tester votre interface de DialogueSaisie"));
    }
}
