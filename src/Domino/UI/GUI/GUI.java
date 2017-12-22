package Domino.UI.GUI;

import javax.swing.*;

public class GUI extends JFrame{
    public GUI(){

    }
    public static void main(String args[]) {
        JFrame gui = new JFrame("Domino Game");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
