package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images extends MouseAdapter{//MouseListener,
   private JLabel f;
   boolean click=false;
   private JPanel panel;
    TileGUI tile;
int x,y;
    public Images()
    {//new ImageIcon(tile.getImage()
        super();
        JPanel panel=new JPanel();
        panel.setBounds(0,0,512,512);
        panel.setVisible(true);
        TileGUI tile = new TileGUI(2,6,100);
        JFrame frame = new JFrame("Domino Game");

        JLabel f= new JLabel("fgdffg");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        f.setBounds(250,250,100,100);
        frame.add(panel);
        panel.add(f);
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

      // f.addMouseListener(this);
       //f.addMouseMotionListener(this);
     // frame.addMouseListener(this);
      // frame.addMouseMotionListener(this);

    }


/*
    @Override
    public void mouseClicked(MouseEvent e) {//otan oloklironetai ena click (kai to patas kai to afinis)

        System.out.println("1");
    }

    @Override
    public void mousePressed(MouseEvent e) {

      /*  click=true;
        x=e.getX();
        y=e.getY();
        if(x>250 && x<350 && y> 250&& y<350&& click)
        {  System.out.println("gamisoy") ;  f.setBounds(0,0,f.getWidth(),f.getHeight());}

        System.out.println("2");
    }

    @Override
    public void mouseReleased(MouseEvent e) {//otan afinis to klik
       // System.out.println("2");
        click=false;
        System.out.println("3");

    }

    @Override
    public void mouseEntered(MouseEvent e) {//;otan pigaineis pano apo kapoio antikeimeno



    }

    @Override
    public void mouseExited(MouseEvent e) {//ekso apo to winoows
        //System.out.println("4");
    }
*/

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("5");
        x=e.getX();
        y=e.getY();
        click=true;



    }
    @Override
    public void mouseMoved(MouseEvent e) {
       // System.out.println(e.getX()+","+e.getY());
       f.setText(String.format("(%d,%d)",e.getX(),e.getY()));
    }
    public static void main(String args[]) {
        Images sdf= new Images();
    }
}
