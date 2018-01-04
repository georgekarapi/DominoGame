package Domino.UI.GUI;

import Domino.UI.GUI.Base.DraggableImage;

import javax.swing.*;
import java.awt.*;

public class GUI{
    DraggableImage tile = new DraggableImage(2, 6, 100, false);

    //TileGUI tile2 = new TileGUI(1,3,100);
    public GUI(){
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        JPanel a = new JPanel();
        JPanel b = new JPanel();
        a.setBounds(0,0,512,300);
        b.setBounds(0,300,512,200);
        frame.add(a);
        frame.add(b);
       JLayeredPane lp=new JLayeredPane();
        ///jPanel.add(new JButton());
        //jPanel.add(tile);
        tile.rotate();
        frame.add(tile);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}