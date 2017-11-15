package Domino.GameModes.SoloOne;

import Domino.Base.Dominoes;
import Domino.Base.Tile;

import java.util.ArrayList;

public class SoloOne {
    Dominoes dom;
    ArrayList<ArrayList<Tile>> tiles;
    public SoloOne(){
        dom = new Dominoes();
        tiles = dom.getGroupofTiles(4,7);
    }
}
