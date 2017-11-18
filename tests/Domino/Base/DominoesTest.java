package Domino.Base;

import org.junit.Test;

import static org.junit.Assert.*;

public class DominoesTest {
    @Test
    public void dominoes() throws Exception {
        Dominoes dom = new Dominoes();
        Tile x;
        for(int i = 0; i<28;i++)
        {
            x = dom.giveTile();
            if (x != null)
                System.out.println("["+x.getLeft()+"|"+x.getRight()+"]");
        }

    }
}
/* den exoyn ginei oloi oi methodoi*/