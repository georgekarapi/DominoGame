package Domino.GameModes.Hungarian;

import Domino.Base.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BotTest {
    @Test
    public void byTile() throws Exception {
        Bot robot = new Bot();
        robot.add(new Tile(4, 6));
        robot.add(new Tile(2, 9));
        robot.add(new Tile(0, 1));
        robot.add(new Tile(1, 2));
        robot.add(new Tile(5, 6));
        robot.add(new Tile(1, 5));
        assertEquals(robot.byTile(4), true);
        assertEquals(robot.byTile(2), true);
        assertEquals(robot.byTile(3), false);

    }

    @Test
    public void movement_tile() throws Exception {
        Bot robot = new Bot();
        robot.add(new Tile(4, 6));
        robot.add(new Tile(2, 9));
        robot.add(new Tile(0, 1));
        robot.add(new Tile(1, 2));
        robot.add(new Tile(5, 6));
        robot.add(new Tile(1, 5));
        Tile x = robot.movement_tile(2);
        assertEquals(x.getLeft(), 2);
        assertEquals(x.getRight(), 9);
    }

}