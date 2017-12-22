package Domino.UI.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    public GUI(){
        setTitle("Domino Game");
        setSize(512,512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[]) {
        new GUI();
    }
    public void paint(Graphics g){
        int tileX = 120;
        int tileY = 60;
        Graphics2D tile = (Graphics2D) g;
        Graphics2D dot = (Graphics2D) g;
        Graphics2D div = (Graphics2D) g;
        tile.setColor(Color.WHITE);
        tile.fillRect(40, 40, tileX, tileY);
        dot.setColor(Color.BLACK);
        dot.fillOval(40,60,10,10);
        div.fillRect(100,40,2,60);

    }
}
