package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImageTile implements MouseListener,MouseMotionListener{
private int x,y,a,b,Lx,Ly,sumx,sumy;
private JLabel l;

private boolean drag=false;
private boolean fois=false;
public ImageTile(JLabel l, int Lx, int Ly)
{this.l=l;x=y=0;this.Lx=Lx;this.Ly=Ly;}
    @Override
    public void mouseClicked(MouseEvent e) {
    System.out.println(1);
  // l.setText("mouseClicked");
       // x=e.getX();



    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(2);
    x=e.getX();
    y=e.getY();
       ///l.setText("mousePressed1213");
        if(e.getX()>l.getX()&& e.getX()<l.getX()+l.getWidth()&& e.getY()>l.getY()&&e.getY()<l.getY()+l.getHeight())
        {drag=true;}
        if(drag)
        {a=e.getX();b=e.getY();}
    }

    @Override
    public void mouseReleased(MouseEvent e) {

      //  l.setText("mouseReleased");
        x=e.getX();
        y=e.getY();
        if(drag)
        {
           // l.setBounds(x,y,100,100);
            Lx=sumx;
            Ly=sumy;
        }
        drag=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(4);
            // x=e.getX();
       // y=e.getY();
       //l.setText("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(5);
        //x=e.getX();
       // y=e.getY();
     //  l.setText("mouseExited");
            //l.setBounds(x,y,100,100);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(3);
        x = e.getX();
        y = e.getY();
        if (drag) {
            if (e.getX() <= a && e.getY() <= b)
            { l.setBounds(Lx - (a - e.getX()), Ly - (b - e.getY()), 100, 100);sumx=Lx - (a - e.getX());sumy=Ly - (b - e.getY());}
            else if(e.getX()<=a && e.getY()>=b)
            { l.setBounds(Lx -(a-e.getX()),Ly+(e.getY()-b),100,100);sumx=Lx -(a-e.getX());sumy=Ly+(e.getY()-b);}
            else if(e.getX()>=a &&e.getY()<=b)
            {  l.setBounds(Lx+(e.getX()-a),Ly-(b-e.getY()),100,100);sumx=Lx+(e.getX()-a);sumy=Ly-(b-e.getY());}
             else if(e.getX()>=a && e.getY()>=b)
            {l.setBounds(Lx+(e.getX()-a),Ly+(e.getY()-b),100,100);sumx=Lx+(e.getX()-a);sumy=Ly+(e.getY()-b);}
        }
        }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(6);
      //  x=e.getX();
       // y=e.getY();
    //   l.setText("mouseMoved");

    }
    public static void main(String args[]) {
    JFrame f=new JFrame();
    JPanel p=new JPanel();
TileGUI t=new TileGUI(2,2,100);
        TileGUI t1=new TileGUI(4,1,100);
        JLabel l=new JLabel(new ImageIcon(t.getImage()));
        JLabel l1=new JLabel(new ImageIcon(t1.getImage()));
       l1.setBounds(100,100,100,100);
        l.setBounds(300,300,100,100);
        f.setSize(512,512);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        p.setBounds(0,0,512,512);
        p.setVisible(true);
        p.setLayout(null);
        f.add(p);
        p.add(l);
        p.add(l1);
        ImageTile h=new ImageTile(l,300,300);
        ImageTile w=new ImageTile(l1,100,100);
        p.addMouseListener(h);
        p.addMouseMotionListener(h);
        p.addMouseListener(w);
        p.addMouseMotionListener(w);
    }
}
