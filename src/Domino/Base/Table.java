package Domino.Base;

import java.util.ArrayList;

/**
 * @author Giorgos
 */
public class Table {
    private ArrayList<Tile> table;

    public Table() {
        table = new ArrayList<>();
    }

    /**
     * @param t Add Tile to the Table
     * @param left Add first (true) or last (false) in the list
     * @return
     */
    public boolean addTile(Tile t, boolean left) {
        if (additionCheck(t)) {
            if (table.size() == 0) {
                table.add(t);
                return true;
            } else {
                if (isLeft(t) && left) {
                    if (t.getRight() != table.get(0).getLeft()) {
                        t.swapTile();
                    }
                    table.add(0, t);
                    return true;
                } else if (isRight(t) && !left) {
                    if (t.getLeft() != table.get(table.size() - 1).getRight()) {
                        t.swapTile();
                    }
                    table.add(t);
                    return true;
                } else {
                    System.out.println("Numbers don't match!");
                    return false;
                }
            }
        } else {
            System.out.println("Cannot add tile");
            return false;
        }
    }
    /**
     * @return Current Table ArrayList
     */
    public ArrayList<Tile> getTable() {
        return new ArrayList<Tile>(table);
    }
    public ArrayList<Tile> returnTable(){return table;}

    /**
     * @param t Tile
     * @return Find position (first or last)
     */
    public boolean isLeft(Tile t) {
        if (t.getRight() == table.get(0).getLeft() || t.getLeft() == table.get(0).getLeft()) {
            return true;
        }
        return false;
    }

    /**
     * @param t Tile
     * @return Find position (first or last)
     */
    public  boolean isRight(Tile t) {
        if (t.getLeft() == table.get(table.size() - 1).getRight() || t.getRight() == table.get(table.size() - 1).getRight()) {
            return true;
        }
        return false;
    }

    /**
     * @param t Tile
     * @return Can be added in Table ArrayList?
     */
    public boolean additionCheck(Tile t) {
        if (table.size() > 0) {
            if (t.getRight() == table.get(0).getLeft() || t.getLeft() == table.get(0).getLeft()) {
                return true;
            } else if (t.getLeft() == table.get(table.size() - 1).getRight() || t.getRight() == table.get(table.size() - 1).getRight()) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * @return First element Table
     */
    public Tile getFirstTile() {
        return table.get(0);
    }

    /**
     * @return Last element of Table
     */
    public Tile getLastTile() {
        return table.get(table.size() - 1);
    }

    /**
     * Remove all Table elements
     */
    public void deleteTiles() {
        table.clear();
    }







    //Cardinal game

}
