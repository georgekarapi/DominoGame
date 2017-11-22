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

    public ArrayList<Tile> getTable() {
        return new ArrayList<Tile>(table);
    }

    private boolean isLeft(Tile t) {
        if (t.getRight() == table.get(0).getLeft() || t.getLeft() == table.get(0).getLeft()) {
            return true;
        }
        return false;
    }

    private boolean isRight(Tile t) {
        if (t.getLeft() == table.get(table.size() - 1).getRight() || t.getRight() == table.get(table.size() - 1).getRight()) {
            return true;
        }
        return false;
    }

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

    public Tile getfirstTile() {
        return table.get(0);
    }

    public Tile getlastTile() {
        return table.get(table.size() - 1);
    }

    public boolean emptyTabloAddTile(Tile t)//μόνο για την πρώτη περίπτωση όταν είναι άδειο το ταμπλό μπαίνει το πρωtό πλακάκι
    {
        if (table.isEmpty()) {
            table.add(t);
            return true;
        }
        return false;
    }

    public void deleteTiles() {
        table.clear();
    }
}
