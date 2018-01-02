package Domino.UI.GUI.Base;

import Domino.Base.Table;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableGUI   {
    private ArrayList<JButton> grid;
    private JPanel panel;
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
    public TableGUI(JPanel panel)
    {
        grid=new ArrayList<>(24);
        this.panel=panel;
        x1=y1=x2=y2=0;
    }
    public void add_TableGUI(JButton j,boolean  lr) //KANONIKA ENA TileGUI ,an prostethike aristera h deksia ,aristera true k deksia false
    {

       if(grid.isEmpty())
        {  j.setBounds(300,0,50,25);
        j.setBackground(Color.red);
        x1=300;y1=0; x2=300 ;y2=0;
        panel.add(j);
        grid.add(j);}
        else if(lr==true)
            {
                if(x1-50>0 && search)
                {
                    x1=x1-50;
                    j.setBounds(x1,y1,50,25);
                    j.setBackground(Color.BLACK);
                    panel.add(j);
                    grid.add(j);
                }
                else if(y1+50<panel.getHeight()&&search1)
                {

                   if(search)
                    {
                        search=false;
                        y1=25;
                    }
                    j.setBounds(x1,y1,25,50);
                    y1=y1+50;
                    j.setBackground(Color.BLACK);
                    panel.add(j);
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
                    panel.add(j);
                    grid.add(j);
                    if(N==2){x1=x1+50;y1=y1+25;}
                }
                else
                {
                    y1=y1-50;
                    j.setBounds(x1,y1,25,50);
                    j.setBackground(Color.BLACK);
                    panel.add(j);
                    grid.add(j);
                }
            }
            else
           {
               if(x2+70<panel.getWidth() && search2)
               {
                   x2=x2+50;
                   j.setBounds(x2,y2,50,25);
                   j.setBackground(Color.BLACK);
                   panel.add(j);
                   grid.add(j);
               }
               else if(y2+50<panel.getHeight()&&search3)
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
                   panel.add(j);
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
                   panel.add(j);
                   grid.add(j);
                   if(K==3){x2=x2-25;}
               }
               else
               {
                   y2=y2-50;
                   j.setBounds(x2,y2,25,50);
                   j.setBackground(Color.BLACK);
                   panel.add(j);
                   grid.add(j);
               }
           }

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
