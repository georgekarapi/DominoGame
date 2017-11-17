/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungarian;
//System.out.println("");

import java.util.ArrayList;

/**
 *
 * @author Χρίστος
 */
public class InterfaceHungarian {
    game_hungarian game;
    public InterfaceHungarian()
    {game=new game_hungarian();}
    public void ShowGame()
    {
        System.out.println("Καλως ήρθες στο ουγγρικό ντόμινο");
        while(game.finishGame())
        {
            game.Start();
            System.out.println("Γύρος "+game.getRound().numRound()+"ος");
            while(game.movesPlayers())
            {
                if(game.getPlayer().get_number()==1)
                {
                    if(game.botTurn())
                    game.moveBotTurn();
                    if(game.playerTurn())
                    {
                        showTile(game.getPlayer().Tiles());
                        //εμφανίζει το ταμπλο
                        //επιλέγει ποιό πλακίδιο θα μετακίνησει
                        //που θα το βαλει 
                        
                    }
                }
            }
        }
    }
    public void showTile(ArrayList<Tile> tiles)//ΕΜΦΑΝΊΖΕΙ ΕΝΑ ΣΥΝΟΛΟ ΑΠΟ ΠΛΑΚΊΔΙΑ
    {
        System.out.println("Στα χέρια σου έχεις:");
        for(Tile t: tiles)
        System.out.print("("+t.getLeft()+","+t.getRight()+")-");
    }
    
}
