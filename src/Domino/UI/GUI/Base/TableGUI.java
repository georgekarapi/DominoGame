package Domino.UI.GUI.Base;

import javax.swing.*;

public class TableGUI extends JPanel {
    JButton b1;
    public TableGUI()
    {
        b1=new JButton("Button 1");
        add(b1);
    }
    public static void main(String args[]) {
       JFrame fr=new JFrame("windows");
        TableGUI tg= new TableGUI();
        fr.setSize(512,512);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(tg);
        fr.setVisible(true);

    }
}
