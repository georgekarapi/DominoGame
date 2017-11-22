package Domino.Base;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TableTest {
    @Test
    public void addTile() throws Exception {
        Table instance = new Table();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(4, 5));
        tiles.add(0, new Tile(5, 4));
        tiles.add(new Tile(5, 4));
        instance.addTile(new Tile(4, 5), true);
        instance.addTile(new Tile(4, 5), true);//Swap sides (left)
        instance.addTile(new Tile(0, 4), true);//Cannot be inserted (left)
        instance.addTile(new Tile(4, 5), false);//Swap sides (right)
        instance.addTile(new Tile(0, 0), false);//Cannot be inserted (right)
        assertEquals(tiles.get(0).getLeft(), instance.getTable().get(0).getLeft());
    }
}