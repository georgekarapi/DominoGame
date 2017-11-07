public class Tile {
    private int left;
    private int right;
    public Tile(int l,int r){
        left = l;
        right = r;
    }
    public int getRight(){
        return right;
    }
    public int getLeft(){
        return left;
    }
    public int getTotal(){
        return left + right;
    }
}
