package Domino.UI.GUI.Base;

import Domino.Base.Table;
import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
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
    private  int K=0;
    private Table table;
    private JPanel p;
    public TableGUI(Table table,JPanel p)
    {
       this.table=table;
        this.p=p;
        DraggableImage first=new DraggableImage(table.getFirstTile().getLeft(),table.getFirstTile().getRight(),50,false);
        first.removeMouseMotionListener(first.getMouseAdapter());
        first.removeMouseListener(first.getMouseAdapter());
        first.setBounds(300,0,50,50);
        x1=300;y1=0; x2=300 ;y2=0;
        p.add(first);
    }
    public boolean add_TableGUI(Tile t, boolean  lr) //KANONIKA ENA TileGUI ,an prostethike aristera h deksia ,aristera true k deksia false
    {
         if(lr&& table.isLeft(t)) {
             table.addTile(t, true);
             t = table.getFirstTile();
             if (x1 - 50 > 0 && search) {
                 DraggableImage j = new DraggableImage(t.getLeft(), t.getRight(), 50, false);
                 x1 = x1 - 50;
                 j.setBounds(x1, y1, 50, 50);
                 p.add(j);
                 j.removeMouseMotionListener(j.getMouseAdapter());
                 j.removeMouseListener(j.getMouseAdapter());
             } else if (y1 + 50 < p.getHeight() && search1) {
                 DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, true);
                 if (search) {
                     search = false;
                     y1 = 40;
                 }
                 //  j.rotate();
                 j.setBounds(x1, y1, 50, 50);
                 y1 = y1 + 50;
                 j.removeMouseMotionListener(j.getMouseAdapter());
                 j.removeMouseListener(j.getMouseAdapter());
                 p.add(j);
             } else {//if (N < 2)
                 DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, false);
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

             }return true;
         }
           else if(!lr && table.isRight(t))
           {
               table.addTile(t, false);
               t = table.getLastTile();
               if(x2+100<p.getWidth() && search2)
               {
                   DraggableImage j = new DraggableImage(t.getLeft(), t.getRight(), 50, false);
                   x2=x2+50;
                   j.setBounds(x2,y2,50,50);
                   p.add(j);
                   j.removeMouseMotionListener(j.getMouseAdapter());
                   j.removeMouseListener(j.getMouseAdapter());
               }
               }
               else if(y2+50<p.getHeight()&&search3)
               {
                   System.out.println(x2+","+y2);
                   DraggableImage j = new DraggableImage(t.getRight(), t.getLeft(), 50, true);
                   if(search2)
                   {
                       search2=false;
                       y2=150;
                       x2=x2-50;
                   }
                   j.setBounds(x2,y2,50,50);
                   y2=y2+50;
                   p.add(j);
                   j.removeMouseMotionListener(j.getMouseAdapter());
                   j.removeMouseListener(j.getMouseAdapter());
               }
             /*  else if(K<3)
               {
                   search3=false;
                   K++;
                  // if(K==2)
                   x2=x2-50;
                   j.setBounds(x2,y2,50,25);
                   j.setBackground(Color.BLACK);
                   add(j);
                   grid.add(j);
                   if(K==3){x2=x2-25;}
               }
               else
               {
                   y2=y2-50;
                   j.setBounds(x2,y2,25,50);
                   j.setBackground(Color.BLACK);
                   add(j);
                   grid.add(j);
               }*/

return false; }

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
