package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;

public class TilesTable extends JPanel{
    TileGUI gui = new TileGUI(0, 0, 50, true);
    TileGUI gui2 = new TileGUI(0, 0, 50, false);
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
