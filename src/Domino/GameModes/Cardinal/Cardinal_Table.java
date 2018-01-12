package Domino.GameModes.Cardinal;

import Domino.Base.Table;
import Domino.Base.Tile;

public class Cardinal_Table extends Table {
    public Cardinal_Table(){super();}
    public boolean additionCheck(Tile t) {
        if(returnTable().size()>0){
            if(t.getRight()+returnTable().get(0).getLeft()==7||t.getLeft()+returnTable().get(0).getLeft()==7||t.getRight()+returnTable().get(returnTable().size()-1).getRight()==7||t.getLeft()+returnTable().get(returnTable().size()-1).getRight()==7||t.balader())
                return true;       }
        return false;
    }
    public boolean isLeft(Tile t){
        if(t.getRight()+returnTable().get(0).getLeft()==7||t.getLeft()+returnTable().get(0).getLeft()==7||t.balader())
            return true;
        return false;
    }
    public boolean isRight(Tile t) {
        if(t.getRight()+getTable().get(getTable().size()-1).getRight()==7||t.getLeft()+getTable().get(getTable().size()-1).getRight()==7||t.balader())
            return true;
        return false;
    }

    public boolean addTile(Tile t,boolean left)
    {
        if(getTable().isEmpty())
        {returnTable().add(t);return true;}
        if(isLeft(t) && left)
        {
            if(t.getLeft()+getTable().get(0).getLeft()==7)
                t.swapTile();
            returnTable().add(0, t);
            return true;
        }
        else if(isRight(t) &&!left)
        {
            if(t.getRight()+getTable().get(getTable().size()-1).getRight()==7)
                t.swapTile();
            returnTable().add(t);
            return true;
        }
        return false;
    }


}
