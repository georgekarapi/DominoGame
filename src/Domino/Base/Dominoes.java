package Domino.Base;

import java.util.ArrayList;
import java.util.Random;

public class Dominoes {
    private static final int TILES_LIMIT = 28;
    private ArrayList<Tile> tiles;

    public Dominoes() {
        tiles = new ArrayList<>(TILES_LIMIT);
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tiles.add(new Tile(i, j));
            }
        }
    }

    /**
     * @return A Tile from the ArrayList
     */
    public Tile giveTile() {
        Random r = new Random();
        int tile;
        if (tiles.size() > 1)
            tile = r.nextInt(tiles.size() - 1);
        else if (tiles.size() == 1)
            tile = 0;
        else
            return null;
        return tiles.remove(tile);
    }

    /**
     * @param HEIGHT Height of the ArrayList (up to 4)
     * @param WIDTH Width of the ArrayList (up to 7)
     * @return ArrayList<ArrayList<Tile>>
     */
    public ArrayList<ArrayList<Tile>> getTiles(int HEIGHT, int WIDTH) {
        Tile tile;
        ArrayList<ArrayList<Tile>> ctiles = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            ArrayList<Tile> tileY = new ArrayList<>();
            for (int j = 0; j < WIDTH; j++) {
                tile = giveTile();
                tileY.add(tile);
            }
            ctiles.add(tileY);
        }
        return ctiles;
    }

    /**
     * Clear Tiles from the List
     */
    public void deletesTiles() {
        tiles.clear();
    }
}