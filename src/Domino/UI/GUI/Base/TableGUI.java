package Domino.UI.GUI.Base;

import Domino.Base.Table;

import javax.swing.*;
import java.util.ArrayList;

public class TableGUI extends JPanel {
    private ArrayList<TileGUI> grid;
    private Table table;
    public TableGUI(Table table)
    {
        super();
        grid=new ArrayList<>();
        this.table=table;
    }


    public static void main(String args[]) {
       JFrame fr=new JFrame("windows");
       // TableGUI tg= new TableGUI();
        fr.setSize(512,512);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    fr.add(tg);
        fr.setVisible(true);

    }
}
