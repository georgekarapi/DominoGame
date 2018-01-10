package Domino.UI.GUI.Base;

import Domino.Base.Table;
import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Player;
import javafx.scene.shape.Rectangle;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class TableGUI{
  //  private ArrayList<DraggableImage> grid;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean search=true;
    private boolean search1=true;
    private  int N=0;
    private boolean search2=true;
    private boolean search3=true;
    private  boolean K=true;
    private Table table;
    public  JPanel p;
    private Player my;
    private TilesTable mon;
    public TableGUI(Table table, JPanel p, Player my)
    {
       this.table=table;
        this.p=p;
        DraggableImage first=new DraggableImage(table.getFirstTile().getLeft(),table.getFirstTile().getRight(),50,false,this);
        first.removeMouseMotionListener(first.getMouseAdapter());
        first.removeMouseListener(first.getMouseAdapter());
        first.setBounds(300,0,50,50);
        x1=300;y1=0; x2=300 ;y2=0;
        p.add(first);
        this.my=my;
    }
    public JPanel get_panel(){return p;}
    public boolean add_TableGUI( boolean  lr) //KANONIKA ENA TileGUI ,an prostethike aristera h deksia ,aristera true k deksia false
    {   Tile t;
   // p.setVisible(false);
        if(lr)
         t=table.getFirstTile();
        else
            t=table.getLastTile();
         if(lr) {
             if (x1 - 50 > 0 && search) {
                 DraggableImage j = new DraggableImage(t.getLeft(), t.getRight(), 50, false,this);
                 x1 = x1 - 50;
                 j.setBounds(x1, y1, 50, 50);
                 p.add(j);
                 j.removeMouseMotionListener(j.getMouseAdapter());
                 j.removeMouseListener(j.getMouseAdapter());
             } else if (y1 + 50 < p.getHeight() && search1) {
                 DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, true,this);
                 if (search) {
                     search = false;
                     y1 = 40;
                 }
                 j.setBounds(x1, y1, 50, 50);
                 y1 = y1 + 50;
                 j.removeMouseMotionListener(j.getMouseAdapter());
                 j.removeMouseListener(j.getMouseAdapter());
                 p.add(j);
             } else {
                 DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, false,this);
                 search1 = false;
                 N++;
                 if (N == 1) {
                     y1 = 450;
                     x1 = x1 + 25;
                 }
                 if (N >= 2) {
                     x1 = x1 + 50;
                 }
                 j.setBounds(x1, y1, 50, 50);
                 j.removeMouseMotionListener(j.getMouseAdapter());
                 j.removeMouseListener(j.getMouseAdapter());
                 p.add(j);

             } p.repaint();// p.setVisible(true);
             return true;

         }
           else if(!lr)
           {
               if(x2+100<p.getWidth() && search2)
               {
                   DraggableImage j = new DraggableImage(t.getLeft(), t.getRight(), 50, false,this);
                   x2=x2+50;
                   j.setBounds(x2,y2,50,50);
                   p.add(j);
                   j.removeMouseMotionListener(j.getMouseAdapter());
                   j.removeMouseListener(j.getMouseAdapter());
               }

               else if(y2+50<p.getHeight()&&search3)
               {System.out.println("1234");
                   System.out.println(x2+","+y2);
                   DraggableImage j = new DraggableImage(t.getLeft(), t.getRight(), 50, true,this);
                   if(search2)
                   {
                       search2=false;
                       y2=40;
                       x2=x2+25;
                   }
                   j.setBounds(x2,y2,50,50);
                   y2=y2+50;
                   p.add(j);
                   j.removeMouseMotionListener(j.getMouseAdapter());
                   j.removeMouseListener(j.getMouseAdapter());
               }
       else
               {
                   if(K){y2=y2-25;K=false;}
                   DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, false,this);
                   search3=false;
                   x2=x2-50;
                   j.setBounds(x2,y2,50,25);
                   p.add(j);
                   j.removeMouseMotionListener(j.getMouseAdapter());
                   j.removeMouseListener(j.getMouseAdapter());

               } p.repaint();
               return true;
    }

return false; }
public boolean add_tile(Tile t,int u ,int v)
{    if(table.isLeft(t)||table.isRight(t))
     {int difference1,difference2;

         if(table.isLeft(t))
         {difference1 =Math.abs(u-x1)+Math.abs(v-y1); }
         else
             difference1=5000;
         if(table.isRight(t))
         {difference2 =Math.abs(u-x2)+Math.abs(v-y2);}
         else
             difference2=5000;

         if(difference1<difference2)
         {t=my.removes(t);table.addTile(t,true);add_TableGUI(true);return true;}
         else
         {t=my.removes(t);table.addTile(t,false);add_TableGUI(false);return true;}

     }
    return false;
}
public void set_TilesTable(TilesTable mon){this.mon=mon;}
    public static void main(String args[]) {
       JFrame fr=new JFrame("windows");
       fr.setLocation(100,100);
       fr.setLayout(null);
        fr.setSize(800,800);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
     ///   TableGUI tg= new TableGUI(fr);
    }
}
