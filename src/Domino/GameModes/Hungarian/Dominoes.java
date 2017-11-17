 package hungarian;

import java.util.ArrayList;
import java.util.Random;

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
    public Tile giveTile(){
        Random r = new Random();
        int tile = r.nextInt(tiles.size() - 1);
        Tile tCopy = new Tile(tiles.get(tile).getLeft(), tiles.get(tile).getRight());
        tiles.remove(tile);
        return tCopy;
    }
    public ArrayList<ArrayList<Tile>> getGroupofTiles(int HEIGHT, int WIDTH){
        Tile tile;
        ArrayList<ArrayList<Tile>> tiles = new ArrayList<>();
        for(int i = 0; i < HEIGHT; i++){
            ArrayList<Tile> tileY = new ArrayList<>();
            for(int j = 0; j < WIDTH; j++){
                tile = giveTile();
                tileY.add(tile);
            }
            tiles.add(tileY);
        }
        return tiles;
    }
    public static void main(String[] args) {
        Dominoes dom = new Dominoes();
        Tile x;
        x = dom.giveTile();
        System.out.println(x.getLeft()+","+x.getRight()) ;
        x = dom.giveTile();
        System.out.println(x.getLeft()+","+x.getRight()) ;
        x = dom.giveTile();
        System.out.println(x.getLeft()+","+x.getRight()) ;
    }
}
