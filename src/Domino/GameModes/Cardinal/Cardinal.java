package Domino.GameModes.Cardinal;

import Domino.Base.Dominoes;
import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Bot;
import Domino.GameModes.Hungarian.Hungarian;
import Domino.GameModes.Hungarian.Player;

public class Cardinal extends Hungarian{
    //private Dominoes dominoes;
    private Cardinal_Table table;
    public Cardinal(int players, String name){
        super(players,name);
        if(players==2)
        set_get_numberTile(7);
        else if(players==3 ||players==4)
            set_get_numberTile(5);
 table=new Cardinal_Table();
    }
    public void Cardinal_start_game()
    {
        Start();
        table.addTile(getClassic().getFirstTile(),true);

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
    public boolean is_empty_tiles(Player p)
    {
        if(p.Tiles().isEmpty())
            return true;
        return false;
    }
    public boolean Cardinal_has_move_bot(int i){if(get_Player(i).Cardinal_haveMove(table.getFirstTile(),table.getLastTile()))
    {
        return true;
    }
        return false;}
   public boolean Cardinal_has_move_bot_andStack(int i){
        if(get_Player(i).Cardinal_haveMove(table.getFirstTile(),table.getLastTile())||get_Stack().size_Dominoes() > 2)
        {
            return true;
        }
return false;
    }
    public boolean Cardinal_move_bot(int turn)//turn o sygkekrimeno robot stin kanoniki katataksiwhile (Cardinal_has_move_bot(turn))&& isempty
    {
        Bot Robot= (Bot) get_Player(turn);
             Robot.show();
             if(get_Player(turn).Cardinal_haveMove(table.getFirstTile(),table.getLastTile())) {
                 if (Robot.Cardinal_byTile(table.getFirstTile().getLeft())) {
                     Tile t = Robot.Cardinal_movement_tile(table.getFirstTile().getLeft());
                     table.addTile(t, true);
                     Robot.show();
                     return true;
                 } else if (Robot.Cardinal_byTile(table.getLastTile().getRight())) {
                     Tile t = Robot.Cardinal_movement_tile(table.getLastTile().getRight());
                     table.addTile(t, false);
                     Robot.show();
                      return false;
                 }
             }
            return true;
    }
    public boolean cardinal_movesPlayers()//an kapoios exei kinisi
    {
        for(Player p:getplayers())
        {
            if (p.Cardinal_haveMove(table.getFirstTile(), table.getLastTile() ))
                return true;
        }
        return false;
    }
    public boolean cardinal_not_tile()//an yparxei kapoios poy toy exoyn teleiosei ta xartia me to cardinal_movesPlayers() tha syndethoyn me :cardinal_movesPlayers()&&! cardinal_not_tile()
    {
        for(Player p:getplayers())
        {
            if(p.Tiles().isEmpty())
                return true;
        }
        return false;
    }
    public boolean Cardinal_playerTurn()//an exei kinisi xoris na trabikseis tile
    {
        if (my_player().Cardinal_haveMove(table.getFirstTile(), table.getLastTile()))
            return true;
        return false;
    }
    public boolean Cardinal_movePlayerTurn(int x, String position)//kanei kinisi o paixtis poy exeis
    {
        Player p1=my_player();
        Tile t = p1.move(x);
        if (t == null)
            return false;
        if (position.compareTo("l") == 0 && table.isLeft(t)) {
            table.addTile(t, true);
            return true;
        } else if (position.compareTo("r") == 0 && table.isRight(t)) {
            table.addTile(t, false);
            return true;
        }
        p1.add(t);
        return false;
    }
    public void cardinal_finishRound(){
        int sum=0;
        Player min=get_Player(0);
        for(Player p:getplayers())
        {
            if(p.sumTiles()<min.sumTiles())
            {
                min=p;
            }
            sum=sum+p.sumTiles();
        }
        getRound().final_round(min,sum-min.sumTiles());
    }
    public Cardinal_Table get_Table_Cardinal(){return table;}
    public void newRound(){super.newRound();table.deleteTiles();}
    //finishGame() einai idia me hungarian opos kai to deletehands()
}

