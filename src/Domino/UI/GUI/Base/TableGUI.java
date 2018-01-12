package Domino.UI.GUI.Base;

import Domino.Base.Table;
import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Player;

import javax.swing.*;

public class TableGUI{
  //  private ArrayList<DraggableImage> grid;
  public Deck deck=null;
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
    public TableGUI(Table table, JPanel p)
    {
       this.table=table;
        this.p=p;
        if(!table.getTable().isEmpty()) {
            DraggableImage first = new DraggableImage(table.getFirstTile(), 50, false);
        first.removeMouseMotionListener(first.getMouseAdapter());
        first.removeMouseListener(first.getMouseAdapter());
        first.setBounds(300,0,50,50);
        x1=300;y1=0; x2=300 ;y2=0;
        p.add(first);}
    }
    public JPanel get_panel(){return p;}
    public boolean add_TableGUI( boolean  lr) //KANONIKA ENA TileGUI ,an prostethike aristera h deksia ,aristera true k deksia false
    {   Tile t;
        if(lr)
        t=new Tile(table.getFirstTile().getLeft(),table.getFirstTile().getRight());
        else
        t=new Tile(table.getLastTile().getLeft(),table.getLastTile().getRight());
   // p.setVisible(false);
        if(table.getTable().size()==1) {
            DraggableImage first = new DraggableImage(table.getFirstTile(), 50, false);
            first.removeMouseMotionListener(first.getMouseAdapter());
            first.removeMouseListener(first.getMouseAdapter());
            first.setBounds(300,0,50,50);
            x1=300;y1=0; x2=300 ;y2=0;
            p.add(first);
            p.repaint();
        }
        else {
            if (lr) {
                if (x1 - 50 > 0 && search) {
                    DraggableImage j = new DraggableImage(t, 50, false);
                    x1 = x1 - 50;
                    j.setBounds(x1, y1, 50, 50);
                    p.add(j);
                    j.removeMouseMotionListener(j.getMouseAdapter());
                    j.removeMouseListener(j.getMouseAdapter());
                } else if (y1 + 50 < p.getHeight() && search1) {
                    t.swapTile();
                    DraggableImage j = new DraggableImage(t, 50, true);
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
                    t.swapTile();
                    DraggableImage j = new DraggableImage(t, 50, false);
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

                }
                p.repaint();// p.setVisible(true);
                return true;

            } else if (!lr) {
                if (x2 + 100 < p.getWidth() && search2) {
                    DraggableImage j = new DraggableImage(t, 50, false);
                    x2 = x2 + 50;
                    j.setBounds(x2, y2, 50, 50);
                    p.add(j);
                    j.removeMouseMotionListener(j.getMouseAdapter());
                    j.removeMouseListener(j.getMouseAdapter());
                } else if (y2 + 50 < p.getHeight() && search3) {
                    System.out.println("1234");
                    System.out.println(x2 + "," + y2);
                    DraggableImage j = new DraggableImage(t, 50, true);
                    if (search2) {
                        search2 = false;
                        y2 = 40;
                        x2 = x2 + 25;
                    }
                    j.setBounds(x2, y2, 50, 50);
                    y2 = y2 + 50;
                    p.add(j);
                    j.removeMouseMotionListener(j.getMouseAdapter());
                    j.removeMouseListener(j.getMouseAdapter());
                } else {
                    if (K) {
                        y2 = y2 - 25;
                        K = false;
                    }
                    t.swapTile();
                    DraggableImage j = new DraggableImage(t, 50, false);
                    search3 = false;
                    x2 = x2 - 50;
                    j.setBounds(x2, y2, 50, 25);
                    p.add(j);
                    j.removeMouseMotionListener(j.getMouseAdapter());
                    j.removeMouseListener(j.getMouseAdapter());

                }
                p.repaint();
                return true;
            }
        }
return false; }

    public boolean add_tile(DraggableImage t, int u, int v) {
        Tile tile = t.tile;
        if (table.additionCheck(tile)) {
            if (table.getTable().isEmpty()) {
                deck.removeTile(t);
                table.addTile(tile, true);
                    add_TableGUI(true);
                deck.removeTile(t);
                    return true;
                }
                int difference1, difference2;
                if (table.isLeft(tile)) {
                    difference1 = Math.abs(u - x1) + Math.abs(v - y1);
                } else
                    difference1 = 5000;
                if (table.isRight(tile)) {
                    difference2 = Math.abs(u - x2) + Math.abs(v - y2);
                } else
                    difference2 = 5000;

                if (difference1 < difference2) {
                    table.addTile(tile, true);
                    add_TableGUI(true);
                  //  my.show();
                } else {
                    table.addTile(tile, false);
                    add_TableGUI(false);
                   // my.show();
                }
            if (deck != null) {
                deck.removeTile(t);
            } else {
                my.removes(tile);
                mon.removeTile(t.tile);
            }
                return true;
            }

    return false;
}
public void set_TilesTable(TilesTable mon){this.mon=mon;}
public void set_Player(Player my){this.my=my;}

}
