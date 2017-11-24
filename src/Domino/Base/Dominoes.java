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

    public ArrayList<Tile> stack() {
        return tiles;
    }

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

    public void deletesTiles() {
        tiles.clear();
    }
}