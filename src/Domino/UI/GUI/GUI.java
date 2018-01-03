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
        JPanel jPanel = new JPanel();
        ///jPanel.add(new JButton());
        //jPanel.add(tile);
        //frame.add(tile);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}