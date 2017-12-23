package Domino.UI.GUI;

import Domino.UI.GUI.Base.TileGUI;

import javax.swing.*;
import java.awt.*;

public class GUI{
    public GUI(){
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new TileGUI(6,4));
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        new GUI();
    }
}