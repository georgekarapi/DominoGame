/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungarian;

import java.util.Random;

/**
 * @author christos
 */
public class game_hungarian {
    private final int numberTile = 12;
    private Dominoes stack;
    private domino_tablo classic;
    private Player player1;
    private Bot Robot;
    private Round rounds;

    public game_hungarian() {

        stack = new Dominoes();
        classic = new domino_tablo();
        player1 = new Player();
        Robot = new Bot();
        rounds = new Round();
        rounds.add(player1);
        rounds.add(Robot);
    }

    public void Start()/* όποιος έχει το μεγαλύτερο πλακίδι  θα παίξει πρώτος και μοιράζει πλακίδια*/ {

        if (player1.maxTile().getTotal() > Robot.maxTile().getTotal()) {
            player1.set_number(1);
            Robot.set_number(2);
            player1.removes(player1.maxTile());
        } else {
            Robot.set_number(1);
            Robot.removes(Robot.maxTile());
            player1.set_number(2);
        }

        for (int i = 0; i < numberTile; i++) {
            Robot.add(stack.giveTile());
            player1.add(stack.giveTile());
        }
    }

    /*  while(rounds.pointPlayer(player1)!=100 && rounds.pointPlayer(Robot)!=100)
      {
          if(player1.get_number()==1)
          {


          }

      }
  }*/
    public boolean playerTurn(int x, String position)//αν ολοκληρώθηκε επιτυχώς η κίνηση ή όχι
    {
        Tile t = player1.move(x);
        if (position.compareTo("left") == 0) {
            classic.first_change(t);
            return true;
        } else if (position.compareTo("right") == 0) {
            classic.last_change(t);
            return true;
        }
        return false;
    }

    public boolean BotTurn()//αν έγινε η κίνηση ή δεν μπορεί να κάνει αλλη
    {
        if (Robot.byTile(classic.firstTile().getLeft())) {
            Tile t = Robot.movement_tile(classic.firstTile().getLeft());
            return true;
        } else if (Robot.byTile(classic.lastTile().getRight())) {
            Tile t = Robot.movement_tile(classic.lastTile().getRight());
            return true;
        }
        return false;

    }


}
