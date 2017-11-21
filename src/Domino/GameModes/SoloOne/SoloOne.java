package Domino.GameModes.SoloOne;

import Domino.Base.*;
import Domino.UI.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


import java.util.ArrayList;

/**
 * @author Giorgos
 */
public class SoloOne extends Table{
    ArrayList<ArrayList<Tile>> tiles;
    public int tiles_size = 28;
    public boolean gameOver;
    public SoloOne(){
        Dominoes dom;
        dom = new Dominoes();
        tiles = dom.getTiles(4,7);
//        tiles = new ArrayList<>();
//        ArrayList<Tile> t1,t2;
//        t1 = new ArrayList<>();
//        t1.add(new Tile(1,1));
//        t2 = new ArrayList<>();
//        t2.add(new Tile(1,4));
//        tiles.add(t1);
//        tiles.add(t2);
    }
    public ArrayList<ArrayList<Tile>> tilesLeft(){
        return tiles;
    }
    public void getTile(int row, boolean left){
        if(0 <= row && row <= 3 &&tiles.get(row).size() > 0) {
            if(addTile(tiles.get(row).get(tiles.get(row).size() - 1), left)){
                tiles.get(row).remove(tiles.get(row).size() - 1);
                tiles_size--;
                if(tiles_size == 0 || !anyMoves()){
                    if(!anyMoves() && tiles_size != 0){ Terminal.gameOver("No more moves");}
                    else { Terminal.gameOver("Won!");}
                    this.gameOver = true;
                }
            }
        }else{
            System.out.println("Row empty or doesn't exist!");
        }
    }
    public boolean anyMoves(){
        for(int i = 0; i < tiles.size(); i++){
            if(tiles.get(i).size() > 0 && additionCheck(tiles.get(i).get(tiles.get(i).size() - 1))){
                return true;
            }
        }
        return false;
    }
}
