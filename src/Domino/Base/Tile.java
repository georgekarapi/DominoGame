package Domino.Base;

public class Tile {
    private int left;
    private int right;

    public Tile() {
        left = 0;
        right = 0;
    }

    public Tile(int l, int r) {
        left = l;
        right = r;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int r) {
        right = r;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int l) {
        left = l;
    }

    public int getTotal() {
        return left + right;
    }

    public void swapTile() {
        int temp = left;
        setLeft(right);
        setRight(temp);
    }
}