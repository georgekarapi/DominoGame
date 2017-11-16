package Domino.GameModes.SoloOne;

import Domino.Base.Dominoes;
import Domino.Base.Tile;
import Domino.UI.Terminal;

import java.util.ArrayList;

public class SoloOne {
    ArrayList<ArrayList<Tile>> tiles;
    public SoloOne(){
        Dominoes dom;
        dom = new Dominoes();
        tiles = dom.getTiles(4,7);
    }
    public ArrayList<ArrayList<Tile>> tilesLeft(){
        return tiles;
    }
    public Tile getTile(int row){
        if((1 <= row && row <= 4) && tiles.get(row).size() > 0) {
            ArrayList<Tile> tCopy = new ArrayList<>(tiles.get(row));
            tiles.get(row).remove(tiles.get(row).size() - 1);
            return tCopy.get(tCopy.size() - 1);
        }
        return null;
    }
    public static void main(String args[]){
        SoloOne solo = new SoloOne();
        Terminal ter = new Terminal();
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
        solo.getTile(1);
        ter.printTiles(solo.tilesLeft());
    }
}
