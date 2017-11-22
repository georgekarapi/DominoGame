package Domino.GameModes.Hungarian;

import Domino.Base.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void move() throws Exception {
        Player p1 = new Player();
        p1.add(new Tile(3, 4));
        p1.add(new Tile(6, 6));
        p1.add(new Tile(1, 9));
        p1.add(new Tile(0, 2));
        p1.add(new Tile(5, 7));
        Tile x = p1.move(2);
        assertEquals(x.getLeft(), 1);
        assertEquals(x.getRight(), 9);
    }

    @Test
    public void haveMove() throws Exception {
        Player p1 = new Player();
        p1.add(new Tile(3, 4));
        p1.add(new Tile(6, 6));
        p1.add(new Tile(1, 9));
        p1.add(new Tile(0, 2));
        p1.add(new Tile(5, 7));
        assertEquals(p1.haveMove(new Tile(2, 8), new Tile(4, 7)), true);
        assertEquals(p1.haveMove(new Tile(8, 8), new Tile(4, 8)), false);
    }

    @Test
    public void maxTile() throws Exception {
        Player p1 = new Player();
        p1.add(new Tile(1, 4));
        p1.add(new Tile(3, 5));
        p1.add(new Tile(1, 9));
        p1.add(new Tile(8, 1));
        p1.add(new Tile(0, 0));
        assertEquals(p1.maxTile().getLeft(), 0);
        assertEquals(p1.maxTile().getRight(), 0);
    }

    @Test
    public void sumTiles() throws Exception {
        Player p1 = new Player();
        p1.add(new Tile(3, 4));
        p1.add(new Tile(6, 6));
        p1.add(new Tile(1, 9));
        p1.add(new Tile(0, 2));
        p1.add(new Tile(5, 7));
        assertEquals(p1.sumTiles(), 43);
    }
}