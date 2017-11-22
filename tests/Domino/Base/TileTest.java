package Domino.Base;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileTest {
    @Test
    public void tiless() throws Exception {
        Tile t = new Tile(2, 6);
        t.setRight(10);
        assertEquals(t.getLeft(), 2);
        assertEquals(t.getRight(), 10);
        assertEquals(t.getTotal(), 12);
    }
}