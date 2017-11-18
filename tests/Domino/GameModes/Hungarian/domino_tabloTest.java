package Domino.GameModes.Hungarian;

import Domino.Base.Tile;
import org.junit.Test;

import static org.junit.Assert.*;

public class domino_tabloTest {
    @Test
    public void first_tile() throws Exception {
    domino_tablo dt=new domino_tablo();
        assertEquals(dt.emptyTabloAddTile(new Tile(2, 5)),true);
        assertEquals(dt.first_tile(new Tile(3,5)),false);
        assertEquals(dt.first_tile(new Tile(2,6)),true);
        assertEquals(dt.first_tile(new Tile(5,2)),true);

    }

    @Test
    public void last_tile() throws Exception {
        domino_tablo dt=new domino_tablo();
        assertEquals(dt.emptyTabloAddTile(new Tile(4, 5)),true);
        assertEquals(dt.last_tile(new Tile(3,5)),true);
        assertEquals(dt.last_tile(new Tile(2,6)),false);
        assertEquals(dt.last_tile(new Tile(5,3)),true);

    }

    @Test
    public void first_change() throws Exception {
        domino_tablo dt=new domino_tablo();
        dt.emptyTabloAddTile(new Tile(4, 5)),true);
         dt.first_change()
    }

    @Test
    public void last_change() throws Exception {
    }


}