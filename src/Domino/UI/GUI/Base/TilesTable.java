package Domino.UI.GUI.Base;

import Domino.Base.Table;
import Domino.Base.Tile;
import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TilesTable {
    private ArrayList<DraggableImage> tiles;
    public TilesTable(int x, int y, int width, int height, ArrayList<Tile> T, int widthTile,JPanel p,TableGUI classic)
    {

        tiles=new ArrayList<>();
        for(Tile t:T)
        {
            tiles.add(new DraggableImage(t.getLeft(),t.getRight(),widthTile,true,classic));
        }
        for(DraggableImage d:tiles)
        {
            d.setBounds(x-50,y,widthTile,widthTile);
            p.add(d);
            x=x+widthTile/2+15;
        }
    }
    public void addTiles(DraggableImage t,int x){tiles.add(x,t);}
    public DraggableImage removeTiles( int i){return tiles.remove(i);}
}
