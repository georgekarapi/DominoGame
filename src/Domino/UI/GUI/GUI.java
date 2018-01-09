package Domino.UI.GUI;

import Domino.UI.GUI.Base.DraggableImage;
import Domino.UI.GUI.Base.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GUI{
    DraggableImage tile = new DraggableImage(2, 6, 250, true);

    //TileGUI tile2 = new TileGUI(1,3,100);
    public GUI(){
        JFrame frame = new JFrame("Domino Game");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //frame.add(new NewGame());

        //frame.addComponentListener(new ResizeListener());
        frame.setVisible(true);
    }
//    class ResizeListener implements ComponentListener {
//        public void componentHidden(ComponentEvent e) {}
//        public void componentMoved(ComponentEvent e) {}
//        public void componentShown(ComponentEvent e) {}
//
//        public void componentResized(ComponentEvent e) {
//            Dimension newSize = e.getComponent().getBounds().getSize();
//        }
//    }
    public static void main(String args[]) {
        new GUI();
    }
}