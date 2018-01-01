/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import Domino.Base.Dominoes;
import Domino.Base.Table;
import Domino.Base.Tile;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author christos
 */
public class Hungarian {
    private  int numberTile ;
    private Dominoes stack;
    private Table classic;
    private Round rounds;
    private HashMap<Integer,Player> players;
    public Hungarian(int numPlayer,String name) {
        numberTile=24/numPlayer;
        players=new HashMap<>();
        stack = new Dominoes();
        classic = new Table();
        players.put(new Integer(0),new Player(name));
        for(int i=1;i<numPlayer;i++)
            players.put(new Integer(i),new Bot("bot"+i));
        rounds = new Round();
        for(Player p:players.values())
            rounds.add(p);
    }
    public void Start() {

        for (int i = 0; i < numberTile; i++) {
            for( Player p:players.values())
            p.add(stack.giveTile());
        }

      for(int i=0;i<players.size()-1;i++) {
            for(int j=i;j<players.size();j++) {
                if ((players.get(new Integer(j)).maxTile().getTotal() > players.get(i).maxTile().getTotal() && players.get(j).doubleTile(players.get(j).maxTile()) && players.get(i).doubleTile(players.get(i).maxTile())) || (players.get(j).doubleTile(players.get(j).maxTile()) && !players.get(i).doubleTile(players.get(i).maxTile())) || (!players.get(j).doubleTile(players.get(j).maxTile()) && !players.get(i).doubleTile(players.get(i).maxTile()) && players.get(j).maxTile().getTotal() > players.get(i).maxTile().getTotal()))
                {
                    Player pl=players.get(i);
                    players.put(new Integer(i),players.get(j));
                    players.put(new Integer(j),pl);

                }
            }
      }
              Tile t = players.get(0).removes(players.get(0).maxTile());
              classic.addTile(t, true);
    }
    public void showEver()
    {
     for(Player p:players.values())
     {
         p.show();
         System.out.println();

     }
    }
   public Collection<Player> getplayers(){return players.values();}
     public boolean movePlayerTurn(int x, String position)
     {
         Player p1=my_player();
         Tile t = p1.move(x);
         if (t == null)
             return false;
         if (position.compareTo("l") == 0 && classic.isLeft(t)) {
             classic.addTile(t, true);
             return true;
         } else if (position.compareTo("r") == 0 && classic.isRight(t)) {
             classic.addTile(t, false);
             return true;
         }
         p1.add(t);
         return false;
     }

     public boolean moveBotTurn(int turn)
     {
         Bot Robot= (Bot) players.get(turn);
         if (Robot.byTile(classic.getFirstTile().getLeft())) {
             Tile t = Robot.movement_tile(classic.getFirstTile().getLeft());
             classic.addTile(t, true);
             return true;
         } else if (Robot.byTile(classic.getLastTile().getRight())) {
             Tile t = Robot.movement_tile(classic.getLastTile().getRight());
             classic.addTile(t, false);
             return true;
         }

         return false;

     }

     public boolean finishGame()
     {
         for(Player p:players.values())
         {
             if (rounds.pointPlayer(p) >= 100 )
                 return true;
         }
         return false;
     }

     public boolean movesPlayers()
     {
         for(Player p:players.values())
         {
             if (p.haveMove(classic.getFirstTile(), classic.getLastTile()) )
                 return true;
         }
         return false;
     }

     public void finishRound(){
        int sum=0;
        Player min=players.get(0);
        for(Player p:players.values())
        {
             if(p.sumTiles()<min.sumTiles())
             {
                 min=p;
             }
             sum=sum+p.sumTiles();
        }
        rounds.final_round(min,sum);
     }
     public boolean playerTurn()
     {
         if (my_player().haveMove(classic.getFirstTile(), classic.getLastTile()))
             return true;
         return false;
     }

     public boolean botTurn(int i)
     {
         Bot Robot=(Bot) players.get(i);
         Robot.show();
         System.out.println("");
         if (Robot.haveMove(classic.getFirstTile(), classic.getLastTile()))
             return true;
         return false;
     }

     public Round getRound() {
         return rounds;
     }
     public Table getClassic() {
         return classic;
     }

     public void deleteHands()
     {
         for(Player p:players.values())
             p.deletesTiles();
     }

     public void newRound()
     {
         stack.deletesTiles();
         stack = new Dominoes();
         classic.deleteTiles();
     }
     public Player my_player()
     {
         for(Player p:players.values())
         {
             if(p instanceof Bot){}
             else
                 return p;
         }
          return null;
     }
     public boolean turn_notBot(int i)
     {
         if(players.get(i) instanceof Bot)
         return true;
         else
           return false;
     }
     public Bot get_Bot(int i)
     {
         return (Bot) players.get(i);
     }
     public int  get_numberTile(){return numberTile;}

}
