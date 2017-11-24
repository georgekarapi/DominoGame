package Domino.GameModes.SoloOne;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoloOneTest {
    @Test
    public void tilesLeft() throws Exception {
        SoloOne instance = new SoloOne();
        instance.getTile(1,true);
        assertEquals(27, instance.tiles_size);
    }

    @Test
    public void getTile() throws Exception {
        SoloOne instance = new SoloOne();
        instance.getTile(1,true);
        assertEquals(27, instance.tiles_size);
    }

}