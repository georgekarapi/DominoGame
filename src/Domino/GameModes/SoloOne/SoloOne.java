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
    }
    public ArrayList<ArrayList<Tile>> tilesLeft(){
        return tiles;
    }
    public void getTile(int row){
        if(0 <= row && row <= 3 &&tiles.get(row).size() > 0) {
            if(addTile(tiles.get(row).get(tiles.get(row).size() - 1), false)){
                tiles.get(row).remove(tiles.get(row).size() - 1);
                tiles_size--;
                if(tiles_size == 0 || !anyMoves()){
                    if(!anyMoves()){ Terminal.gameOver("No more moves");}
                    else { Terminal.gameOver("Won!");}
                    this.gameOver = true;
                }
            }else{
                System.out.println("Not matching existed Tiles");
            }
        }else{
            System.out.println("Row empty or doesn't exist!");
        }
    }
    public boolean anyMoves(){
        for(int i = 0; i < tiles.size(); i++){
            if(addTile(tiles.get(i).get(tiles.get(i).size() - 1), true)){
                return true;
            }
        }
        return false;
    }
}
