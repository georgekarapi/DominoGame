package Domino.UI.GUI;

import Domino.UI.GUI.Base.DraggableImage;
import Domino.UI.GUI.Base.TileGUI;

import javax.swing.*;
import java.awt.*;

public class GUI{
   //DraggableImage tile = new DraggableImage(2, 6, 100, true);
 //  DraggableImage tile1 = new DraggableImage(3, 1, 150, true);
    public GUI(){
       /* JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLayeredPane jLayeredPane = frame.getLayeredPane();
        jLayeredPane.setLayout(new FlowLayout());
        JPanel jPanel = new JPanel();
       jPanel.setBounds(0,0,512,300);
       JPanel jPanel1 = new JPanel();
        jPanel.setBounds(0,0,512,212);
        jPanel.setBorder(BorderFactory.createTitledBorder(
                "Panel 1"));
        jPanel1.setBorder(BorderFactory.createTitledBorder(
                "Panel 2"));
       // tile.setBounds(100,100,20,10);
       // tile.setLocation(100,100);
        jPanel.add(tile);
        jLayeredPane.add(jPanel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(jPanel1, JLayeredPane.DEFAULT_LAYER);
        frame.setVisible(true);*/
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JPanel jPanel = new JPanel();
       jPanel.setBounds(0,0,512,512);
        jPanel.setLayout(new GridBagLayout());
        jPanel.setVisible(true);
        //tile.setBounds(200,200,100,50);
     //   jPanel.add(tile);
     //   jPanel.add(tile1);
        frame.add(jPanel);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}