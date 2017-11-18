package Domino.Base;

import java.util.ArrayList;
/**
 *
 * @author Giorgos
 */
public class Table {
    private ArrayList<Tile> table;
    public Table(){
        table = new ArrayList<>();
    }
    public boolean addTile(Tile t, boolean actionLess){
        if(table.size() > 0) {
            //Add First
            if (t.getRight() == table.get(0).getLeft() || t.getLeft() == table.get(0).getLeft()) {
                if(!actionLess) {
                    if (t.getLeft() == table.get(0).getLeft()) {
                        int temp = t.getLeft();
                        t.setLeft(t.getRight());
                        t.setRight(temp);
                    }
                    table.add(0, t);
                }
                return true;
            }
            //Add Last
            else if(t.getLeft() == table.get(table.size()-1).getRight() || t.getRight() == table.get(table.size()-1).getRight()) {
                if (!actionLess) {
                    if (t.getRight() == table.get(table.size() - 1).getRight()) {
                        int temp = t.getLeft();
                        t.setLeft(t.getRight());
                        t.setRight(temp);
                    }
                    table.add(t);
                }
                return true;
            }
        }else{
            table.add(t);
            return true;
        }
        return false;
    }
    public ArrayList<Tile> getTable(){return table;}
}
