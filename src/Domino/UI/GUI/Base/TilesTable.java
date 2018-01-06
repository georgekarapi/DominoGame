package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TilesTable extends JPanel{
    private ArrayList<DraggableImage> tiles;
    public TilesTable(int x, int y, int width, int height, ArrayList<Tile> T, int widthTile)
    {
        setBounds(x,y,width,height);
        setLayout(new GridLayout(1,T.size()+1,0,0));
        tiles=new ArrayList<>();
        setVisible(true);
        for(Tile t:T)
        {
            tiles.add(new DraggableImage(t.getLeft(),t.getRight(),widthTile,true));
        }
        for(DraggableImage d:tiles)
        {
            add(d);

        }
    }
    public void addTiles(DraggableImage t,int x){tiles.add(x,t);}
    public DraggableImage removeTiles( int i){return tiles.remove(i);}
    public static void main(String args[]) {

        JFrame fr=new JFrame("windows");
        fr.setLayout(null);
        fr.setSize(500,500);
        fr.setLocation(50,50);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<Tile> p=new ArrayList<>();
        p.add(new Tile(2,4));
        p.add(new Tile(3,1));
        p.add(new Tile(4,4));
        p.add(new Tile(1,2));
        p.add(new Tile(3,1));
        p.add(new Tile(4,4));
        p.add(new Tile(1,2));
        TilesTable t=new TilesTable(0,0,800,800,p,100);

       fr.add(t);
       fr.setVisible(true);
    }
}
