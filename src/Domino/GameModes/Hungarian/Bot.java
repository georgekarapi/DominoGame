/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import Domino.Base.Tile;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Christos
 */
public class Bot extends Player {
    public Bot() {
        super();
    }

    public boolean byTile(int l)
    {
        if (!Tiles().isEmpty()) {
            for (Tile t : Tiles()) {
                if (t.getLeft() == l || t.getRight() == l)
                    return true;
            }
        }
        return false;
    }

    public Tile movement_tile(int r)
    {
        ArrayList<Tile> move = new ArrayList<>();
        Random r1 = new Random();
        for (Tile t : Tiles()) {
            if (t.getLeft() == r)
                move.add(t);
            else if (t.getRight() == r)
                move.add(t);
        }
        // for(Tile t: move)
        //System.out.print("("+t.getLeft()+","+t.getRight()+")-");
        int x;
        if (move.size() == 1)
            x = 0;
        else
            x = r1.nextInt(move.size() - 1);
        Tiles().remove(move.get(x));
        return move.get(x);
    }

}
   

/* έχει γίνει έλεγχος*/

/**/