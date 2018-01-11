package Domino.Base;

public class Tile {
    private int left;
    private int right;

    public Tile() {
        left = 0;
        right = 0;
    }

    /**
     * @param l Left Tile number
     * @param r Right Tile number
     */
    public Tile(int l, int r) {
        left = l;
        right = r;
    }

    /**
     * @return  Get Right number
     */
    public int getRight() {
        return right;
    }

    /**ArrayList<ArrayList<Tile>>
     * @param r Set right int
     */
    public void setRight(int r) {
        right = r;
    }

    /**
     * @return  Get Left number
     */
    public int getLeft() {
        return left;
    }

    /**
     * @param l Set left int
     */
    public void setLeft(int l) {
        left = l;
    }

    /**
     * @return  Total number power of tiles
     */
    public int getTotal() {
        return left + right;
    }

    /**
     * Swap Left Right Tiles numbers
     */
    public void swapTile() {
        int temp = left;
        setLeft(right);
        setRight(temp);
    }





    public boolean balader( )
    {
        if(getTotal()==7 || getTotal()==0)
            return true;
        return false;
    }
}