package Domino.UI.GUI;

import Domino.UI.GUI.Base.DraggableImage;
import Domino.UI.GUI.Base.TileGUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    TileGUI tile;
    TileGUI tile2;
    public GUI(){
        tile = new TileGUI(2, 6, 100, true);
        tile2 = new TileGUI(1, 3, 100, false);
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        //JLabel label = new JLabel(new ImageIcon(tile.getImage()));
        //JLabel label2 = new JLabel(new ImageIcon(tile2.getImage()));
        frame.add(new DraggableImage(1, 3, 100, false));
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
    }

    public static void main(String args[]) {
        new GUI();
    }
}