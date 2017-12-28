package Domino.GameModes.Hungarian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundTest {
    @Test
    public void final_round() throws Exception {
        Player p1 = new Player("");
        Bot robot = new Bot("");
        Round r = new Round();
        r.add(p1);
        r.add(robot);
        r.final_round(p1, 100);
        r.final_round(p1, 20);
        r.final_round(p1, 0);
        r.final_round(robot, 50);
        r.final_round(robot, 150);
        r.final_round(robot, 50);
        r.final_round(robot, 10);
        r.final_round(robot, 5);
        assertEquals(r.pointPlayer(p1), 120);
        assertEquals(r.pointPlayer(robot), 265);
        assertEquals(r.numRound(), 9);

    }

}