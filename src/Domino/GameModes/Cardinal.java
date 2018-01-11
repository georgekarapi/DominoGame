package Domino.GameModes;

import Domino.Base.Dominoes;
import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Bot;
import Domino.GameModes.Hungarian.Hungarian;
import Domino.GameModes.Hungarian.Player;

import java.util.ArrayList;

public class Cardinal extends Hungarian{
    private Dominoes dominoes;
    public Cardinal(int players, String name){
        super(players,name);
        if(players==2)
        set_get_numberTile(7);
        else if(players==3 ||players==4)
            set_get_numberTile(5);

    }
    public void start_game()
    {
        Start();

    }
    public boolean draw_Tile(Player p)
    {
        if (get_Stack().size_Dominoes() > 2)
        {
            p.add(get_Stack().giveTile());
            return true;
        }
     return false;
    }
   /* public boolean cardinal_has_move_bot(int i){
        if(get_Player(i).Cardinal_haveMove(getClassic().getFirstTile(),getClassic().getLastTile()))
        {
            return true;
        }

    }*/
    public void cardinal_move_bot(int turn)
    {

    }
    public static void main(String args[]) {
        Cardinal car=new Cardinal(2,"Christos");
        System.out.println(car.get_Stack().size_Dominoes());
    }
}

