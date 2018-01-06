package Domino.UI.GUI.Base;

import Domino.Base.Tile;
import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TilesTable {
    private JLayeredPane panel;
    private ArrayList<DraggableImage> tiles;

    public TilesTable(int x, int y, int width, int height, ArrayList<Tile> T, int widthTile,JLayeredPane p)
    {    panel=p;
      // this.setBounds(x,y,width,height);
      // this.setLayout(null);//
        tiles=new ArrayList<>(); //setLayout(new GridBagLayout());.
       //  setVisible(true);
        for(Tile t:T)
        {
            tiles.add(new DraggableImage(t.getLeft(),t.getRight(),widthTile,true));
        }

        for(DraggableImage d:tiles)
        {
         d.setBounds(x,y,widthTile,widthTile);
            panel.add(d);
            x=x+widthTile/2+10;
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
      // TilesTable t=new TilesTable(0,0,800,800,p,50);
    //  fr.add(t);
       fr.setVisible(true);
    }
}
