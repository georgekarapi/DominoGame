package Domino.UI.GUI.Base;

import Domino.Base.Table;
import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class TableGUI{
    private ArrayList<DraggableImage> grid;
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
    private Table t;
    private JPanel p;
    public TableGUI(Table t,JPanel p)
    {
        grid=new ArrayList<>(24);
        x1=y1=x2=y2=0;
        this.t=t;
        this.p=p;
    }
    public boolean add_TableGUI(Tile t, boolean  lr) //KANONIKA ENA TileGUI ,an prostethike aristera h deksia ,aristera true k deksia false
    {

       if(grid.isEmpty())
        { DraggableImage j=new DraggableImage(t.getLeft(),t.getRight(),50,false);
        j.setBounds(300,0,50,50);
        x1=300;y1=0; x2=300 ;y2=0;
        p.add(j);
        j.removeMouseMotionListener((MouseMotionListener) DraggableImage.CustomMouseAdapter);
       // grid.add(j);
            return true;}
            return false;
      /*  else if(lr==true &&t.isLeft(j.getTileGUI()))
            {
                t.addTile(j.getTileGUI(),true);
                if(x1-50>0 && search)
                {
                    x1=x1-50;
                    j.setBounds(x1,y1,50,25);
                    j.setBackground(Color.BLACK);
                    add(j);
                    grid.add(j);
                }
                else if(y1+50<getHeight()&&search1)
                {

                   if(search)
                    {
                        search=false;
                        y1=25;
                    }
                    j.setBounds(x1,y1,25,50);
                    y1=y1+50;
                    j.setBackground(Color.BLACK);
                    add(j);
                    grid.add(j);
                }
                else if(N<2)
                {
                    search1=false;
                   N++;
                    if(N==2)
                       {x1=x1+50;}
                        j.setBounds(x1,y1,50,25);
                    j.setBackground(Color.BLACK);
                    add(j);
                    grid.add(j);
                    if(N==2){x1=x1+50;y1=y1+25;}
                }
                else
                {
                    y1=y1-50;
                    j.setBounds(x1,y1,25,50);
                    j.setBackground(Color.BLACK);
                    add(j);
                    grid.add(j);
                }
                return true;
            }
            else if(t.isRight(j.getTileGUI()))
           {
               t.addTile(j.getTileGUI(),false);
               if(x2+70<getWidth() && search2)
               {
                   x2=x2+50;
                   j.setBounds(x2,y2,50,25);
                   j.setBackground(Color.BLACK);
                   add(j);
                   grid.add(j);
               }
               else if(y2+50<getHeight()&&search3)
               {

                   if(search2)
                   {
                       search2=false;
                       x2=x2+25;
                       y2=25;
                   }
                   j.setBounds(x2,y2,25,50);
                   y2=y2+50;
                   j.setBackground(Color.BLACK);
                   add(j);
                   grid.add(j);
               }
               else if(K<3)
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
               }return true;
           }
return false;*/
    }
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
