import java.util.ArrayList;

public class Dominoes {
    ArrayList<ArrayList<Tile>> tiles;
    public Dominoes(){
        tiles = new ArrayList<>();
        for(int i=0; i <= 6; i++){
            for(int j=i; j <=6; j++){
                tiles.add(new Tile(i,j));
            }
        }
    }
    public giveTile(){

    }
    public static void main(String[] args) {
        Dominoes dom = new Dominoes();
    }
}
