/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import Domino.Base.Tile;

import java.util.ArrayList;

/**
 * @author Christos
 */
public class Player {
    private ArrayList<Tile> tiles;
    private String name;
    public Player(String name) {
        tiles = new ArrayList<>();
        this.name=name;
    }
    public void add(Tile t) {
        tiles.add(t);
    }
    public ArrayList<Tile> Tiles() {
        return tiles;
    }

    public Tile move(int x)
    {
        if (x >= 0 && x < tiles.size())
            return tiles.remove(x);
        else
            System.out.println("there is no such tile");
        return null;
    }


    public boolean haveMove(Tile lef, Tile rig)
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
        for(int i=0;i<tiles.size();i++)
        {
            if(tiles.get(i).getLeft()==t.getLeft()&&tiles.get(i).getRight()==t.getRight()||tiles.get(i).getLeft()==t.getRight()&&tiles.get(i).getRight()==t.getLeft())
            {  return tiles.remove(i);}
        }
          return null;
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
    public String get_name(){return name; }
    public void show()
    {
        System.out.println("My name is "+name);
        if(!tiles.isEmpty())
        { for(Tile t:tiles)
        {
            System.out.print(tiles.indexOf(t) + ".[" + t.getLeft() + "|" + t.getRight() + "]");
        }
        }
    }




    //Cardinal
    public boolean Cardinal_haveMove(Tile lef, Tile rig)
    {
        if (!tiles.isEmpty()) {
            for (Tile t : tiles) {
                if (t.getLeft() + lef.getLeft() ==7|| t.getRight() + lef.getLeft()==7 || t.getLeft() + rig.getRight()==7 || t.getRight() + rig.getRight()==7||t.balader())
                    return true;
            }
        }
        return false;
    }
}
