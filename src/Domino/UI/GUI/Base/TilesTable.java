package Domino.UI.GUI.Base;

import Domino.Base.Dominoes;
import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class TilesTable extends JPanel{
    TileGUI gui = new TileGUI(0,0,50,40,35, true);
    TileGUI gui2 = new TileGUI(0,0,50,80,35, true);
    public void paintComponent(Graphics g){
        //setOpaque(false);
        super.paintComponent(g);
        g.drawString("This is my custom Panel!",10,20);
        //gui.customPaint(g);
        //gui2.customPaint(g);
    }
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
}
