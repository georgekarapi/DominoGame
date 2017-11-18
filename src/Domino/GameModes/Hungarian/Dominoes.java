/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
import Domino.Base.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Χρίστος
 */
public class Dominoes {
     private ArrayList<Tile> tiles;
    public Dominoes(){
        tiles = new ArrayList<Tile>(28);
        for(int i=0; i <= 6; i++){
            for(int j=i; j <=6; j++){
                tiles.add(new Tile(i,j));
            }
        }
    }
    public Tile giveTile(){
        Random r = new Random();
        int tile = r.nextInt(tiles.size()-1);
        Tile tcopy = new Tile(tiles.get(tile).getLeft(),tiles.get(tile).getRight());
        tiles.remove(tile);
        return tcopy;
    }
}
