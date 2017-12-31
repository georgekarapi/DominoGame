package Domino.UI.GUI;

import Domino.Base.Tile;
import Domino.UI.GUI.Base.TileGUI;

import javax.swing.*;
import java.awt.*;

public class GUI{
    public GUI(){
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        TileGUI tile = new TileGUI(1,1,50,40,35, true);
       TileGUI tile2 = new TileGUI(2,1,50,180,180, false);

        frame.add(tile);
      //  frame.add(tile2);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        new GUI();
    }
}