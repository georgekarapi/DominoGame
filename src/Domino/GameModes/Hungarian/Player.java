/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import Domino.Base.Tile;

import java.util.ArrayList;

/**
 * @author Χρίστος
 */
public class Player {
    private ArrayList<Tile> tiles;
    private int number;//σειρά του παίχτη αν είναι αυτός πχ που παίζει πρώτος δεύτερος κλp    

    public Player() {
        tiles = new ArrayList<>();
        number = 0;
    }

    public int get_number() {
        return number;
    }

    public void set_number(int n) {
        number = n;
    }

    public void add(Tile t) {
        tiles.add(t);
    }

    public ArrayList<Tile> Tiles() {
        return tiles;
    }

    public Tile move(int x)//επιστρεφει το χ πλακίδιο απο τα χεριά
    {
        if (x >= 0 && x < tiles.size())
            return tiles.remove(x);
        else
            System.out.println("there is no such tile");
        return null;
    }


    public boolean haveMove(Tile lef, Tile rig)//αν εχει να κάνει κίνηση ή όχι
    {
        if (!tiles.isEmpty()) {
            for (Tile t : tiles) {
                if (t.getLeft() == lef.getLeft() || t.getRight() == lef.getLeft() || t.getLeft() == rig.getRight() || t.getRight() == rig.getRight())
                    return true;
            }
        }
        return false;
    }

    public Tile maxTile() {
        Tile max = new Tile(-1, -2);
        boolean b = false;
        for (Tile t : tiles) {
            if (t.getRight() == t.getLeft()) {
                if (!b) {
                    b = true;
                    max = t;
                } else if (t.getTotal() > max.getTotal())
                    max = t;
            }
        }
        if (!b) {
            max = tiles.get(0);
            for (Tile t : tiles) {
                if (t.getTotal() > max.getTotal())
                    max = t;
            }
        }

        return max;
    }

    public Tile removes(Tile t) {
        Tile z = new Tile(t.getLeft(), t.getRight());
        tiles.remove(t);
        return z;
    }

    public int sumTiles() {
        int sum = 0;
        if (!tiles.isEmpty()) {
            for (Tile t : tiles)
                sum = sum + t.getTotal();
        }
        return sum;
    }

    public boolean doubleTile(Tile t) {
        if (t.getLeft() == t.getRight())
            return true;
        return false;
    }

    public void deletesTiles() {
        tiles.clear();
    }
}
/*εχει ελεγχθεί/* public void print()
    {
        System.out.println();
        for(Tile t:tiles)
        System.out.println(tiles.indexOf(t)+".["+t.getLeft()+"|"+t.getRight()+"]");
    }*/