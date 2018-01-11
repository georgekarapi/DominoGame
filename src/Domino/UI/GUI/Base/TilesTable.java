package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.util.ArrayList;

public class TilesTable {
    private ArrayList<DraggableImage> tiles;
    private JPanel p;
    private TableGUI classic;
    public boolean enable;
    public TilesTable(int x, int y, int width, int height, ArrayList<Tile> T, int widthTile,JPanel p,TableGUI classic)
    {
       this.p=p;
       this.classic=classic;
        tiles=new ArrayList<>();
        for(Tile t:T)
        {
            tiles.add(new DraggableImage(t, widthTile, true));

        }
        for(DraggableImage d:tiles)
        {
            d.setBounds(x-50,y,widthTile,widthTile);
            p.add(d);
            x=x+widthTile/2+15;
        }
        for(DraggableImage d:tiles){d.table=classic;}
        removeMouseListenet();

    }
    public void addTiles(DraggableImage t,int x){tiles.add(x,t);}
    public void removeTile( Tile t)
    {
        for(DraggableImage d:tiles)
        {
        if(d.tile.getLeft()==t.getLeft() &&d.tile.getRight()==t.getRight() ||d.tile.getLeft()==t.getRight() &&d.tile.getRight()==t.getLeft() )
        {Thread w=new Thread(new Interr(d));w.start();try {
            w.join();
        } catch (InterruptedException e) {
        }
        }

        }
    }
    public void  removes_all_DraggableImage()
    {
        for(DraggableImage d:tiles)
        {d.setVisible(false);p.remove(d);}
    }
    public void removeMouseListenet()
    {for(DraggableImage d:tiles)
    {
        d.disableMouse();

    }
    enable=false;
    }
    public void addMouseListener()
    {
        for(DraggableImage d:tiles)
        {
            d.enableMouse();
        }
        enable=true;
    }
    public class Interr implements Runnable {
        DraggableImage d;
        public Interr(DraggableImage d){this.d=d;}
        public void run() {
          d.setVisible(false);//tiles.remove(d);//classic.get_panel().remove(d);p.remove(d);
        }
    }

}
