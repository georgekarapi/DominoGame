package Domino.Base;

import java.util.ArrayList;
import java.util.Random;
import Domino.UI.*;

public class Dominoes {
    private static final int TILES_LIMIT = 28;
    private ArrayList<Tile> tiles;

    public Dominoes(){
        tiles = new ArrayList<>(TILES_LIMIT);
        for(int i=0; i <= 6; i++){
            for(int j=i; j <=6; j++){
                tiles.add(new Tile(i,j));
            }
        }
    }
    public ArrayList<Tile> stack(){return tiles;}
    public Tile giveTile(){
        Random r = new Random();
        int tile;
        if(tiles.size() > 0)//αυτόν τον έλενχο τον κάνουμε γιατί πρέπει το tiles.size()-1>0 δεν μπορεί να είναι μηδεν  !!!!!!
         tile = r.nextInt(tiles.size());
        else
         return null;
        Tile tCopy = new Tile(tiles.get(tile).getLeft(), tiles.get(tile).getRight());
        tiles.remove(tile);
        return tCopy;
    }
    public ArrayList<ArrayList<Tile>> getTiles(int HEIGHT, int WIDTH){
        Tile tile;
        ArrayList<ArrayList<Tile>> ctiles = new ArrayList<>();
        for(int i = 0; i < HEIGHT; i++){
            ArrayList<Tile> tileY = new ArrayList<>();
            for(int j = 0; j < WIDTH; j++){
                tile = giveTile();
                tileY.add(tile);
            }
            ctiles.add(tileY);
        }
        return ctiles;
    }
    public static void main(String[] args) {
        Dominoes dom = new Dominoes();
        Terminal ter=new Terminal();
        Tile x;
        for(int i=0;i<28;i++)
        {x = dom.giveTile();ter.printTiles(dom.getTiles(4,7));}
        x = dom.giveTile();
    }
}
