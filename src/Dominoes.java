import java.util.ArrayList;
import java.util.Random;

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
