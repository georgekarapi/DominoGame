package Domino.UI.GUI;

import Domino.Base.Tile;
import Domino.UI.GUI.Base.TileGUI;
import Domino.UI.GUI.Base.TilesTable;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.dnd.DropTarget;
import javax.swing.TransferHandler;
public class GUI{
    TileGUI tile = new TileGUI(1,6,100);

    public GUI(){
        TransferHandler th=new TransferHandler("asdsda");
        JFrame frame = new JFrame("Domino Game");DropTarget dt=new DropTarget();
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel l1=new JLabel(new ImageIcon(tile.getImage()));
      //  JLabel l2=new JLabel(new ImageIcon(tile2.getImage()));
       l1.setBounds(250,250,100,100);
       // l2.setBounds(400,400,100,100);
        l1.setDropTarget(dt);
        JTextField f= new JTextField("ante gamisoy");
        f.setBounds(20,20,50,50);
        f.setDragEnabled(true);

        frame.add(l1);
    //    frame.add(l2);
        frame.add(f);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}