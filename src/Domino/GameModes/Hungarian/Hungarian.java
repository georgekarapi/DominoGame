/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import Domino.Base.Dominoes;
import Domino.Base.Table;
import Domino.Base.Tile;

/**
 * @author christos
 */
public class Hungarian {
    private final int numberTile = 12;
    private Dominoes stack;
    private Table classic;
    private Player player1;
    private Bot Robot;
    private Round rounds;

    public Hungarian() {

        stack = new Dominoes();
        classic = new Table();
        player1 = new Player();
        Robot = new Bot();
        rounds = new Round();
        rounds.add(player1);
        rounds.add(Robot);
    }

    public void Start() {

        for (int i = 0; i < numberTile; i++) {
            Robot.add(stack.giveTile());
            player1.add(stack.giveTile());
        }
        if ((player1.maxTile().getTotal() > Robot.maxTile().getTotal() && player1.doubleTile(player1.maxTile()) && Robot.doubleTile(Robot.maxTile())) || (player1.doubleTile(player1.maxTile()) && !Robot.doubleTile(Robot.maxTile())) || (!player1.doubleTile(player1.maxTile()) && !Robot.doubleTile(Robot.maxTile()) && player1.maxTile().getTotal() > Robot.maxTile().getTotal())) {
            player1.set_number(1);//
            Robot.set_number(2);
            Tile t = player1.removes(player1.maxTile());
            classic.emptyTabloAddTile(t);
        } else {
            Robot.set_number(1);
            player1.set_number(2);
            Tile t = Robot.removes(Robot.maxTile());
            classic.emptyTabloAddTile(t);
        }
    }//εχει ελεχθει

    public boolean movePlayerTurn(int x, String position)
    {
        Tile t = player1.move(x);
        if (t == null)
            return false;
        if (position.compareTo("l") == 0) {
            classic.addTile(t, true);
            return true;
        } else if (position.compareTo("r") == 0) {
            classic.addTile(t, false);
            return true;
        }
        player1.add(t);
        return false;
    }

    public boolean moveBotTurn()
    {
        if (Robot.byTile(classic.getfirstTile().getLeft())) {
            Tile t = Robot.movement_tile(classic.getfirstTile().getLeft());
            classic.addTile(t, true);
            return true;
        } else if (Robot.byTile(classic.getlastTile().getRight())) {
            Tile t = Robot.movement_tile(classic.getlastTile().getRight());
            classic.addTile(t, false);
            return true;
        }
        return false;

    }

    public boolean finishGame()
    {
        if (rounds.pointPlayer(player1) >= 100 || rounds.pointPlayer(Robot) >= 100)
            return true;
        return false;
    }

    public boolean movesPlayers()
    {
        if (player1.haveMove(classic.getfirstTile(), classic.getlastTile()) || Robot.haveMove(classic.getfirstTile(), classic.getlastTile())) {
            return true;
        }
        return false;
    }

    public void finishRound() {
        if (player1.sumTiles() < Robot.sumTiles())
            rounds.final_round(player1, player1.sumTiles() + Robot.sumTiles());
        else
            rounds.final_round(Robot, player1.sumTiles() + Robot.sumTiles());

    }

    public boolean playerTurn()
    {
        if (player1.haveMove(classic.getfirstTile(), classic.getlastTile()))
            return true;
        return false;
    }

    public boolean botTurn()//αν έχει κίνηση Robot
    {
        if (Robot.haveMove(classic.getfirstTile(), classic.getlastTile()))
            return true;
        return false;
    }

    public Round getRound() {
        return rounds;
    }

    public Player getPlayer() {
        return player1;
    }

    public Bot getRobot() {
        return Robot;
    }

    public Table getClassic() {
        return classic;
    }

    public void deleteHands(Player p)
    {
        player1.deletesTiles();
        Robot.deletesTiles();
    }

    public void newRound()//
    {
        stack.deletesTiles();
        stack = new Dominoes();
        classic.deleteTiles();
    }
}
