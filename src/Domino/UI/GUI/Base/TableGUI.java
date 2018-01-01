package Domino.UI.GUI.Base;

import Domino.Base.Table;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableGUI   {
    private ArrayList<TileGUI> grid;
    private Table table;
    public JPanel p1;
   public  JPanel p2;
    JButton b1;
    JButton b2;
    JFrame j;
    public TableGUI(JFrame j)
    {
      //  grid=new ArrayList<>();
        //this.table=table;

        b1=new JButton("1,2");
        b2=new JButton("2,4");
        p2=new JPanel();
        p1=new JPanel();
        this.j=j;
        this.j.add(p1);
        this.j.add(p2);


        p1.setBounds(0,0,500,800);

        p1.setLayout(null);
        p2.setBounds(0,500,300,800);
        p2.setLayout(new FlowLayout());


        b1.setBounds(0,100,50,50);
        p1.add(b1);
        p2.add(b2);
        p2.add(new Button("7,8"));

        p1.setVisible(true);
        p2.setVisible(true);
      //  b2.setSize(50,50);


       // b2.setBounds(100,700,50,50);

    }
    public static void main(String args[]) {
       JFrame fr=new JFrame("windows");

       fr.setLocation(100,100);
       fr.setLayout(null);
        fr.setSize(800,800);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        TableGUI tg= new TableGUI(fr);
    }
}
