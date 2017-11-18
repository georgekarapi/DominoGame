/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
//System.out.println("");
import Domino.Base.*;
import java.util.ArrayList;

/**
 *
 * @author Χ??ίστος
 */
public class InterfaceHungarian {
    game_hungarian game;
    public InterfaceHungarian()
    {game=new game_hungarian();}
    public void ShowGame()
    {
        System.out.println("??αλως ή??θες στο ουγγ??ικ?? ντ??μινο");//
        while(game.finishGame())
        {
            game.Start();
            System.out.println("Γ????ος "+game.getRound().numRound()+"ος");
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
                        //επιλέγει ποι?? πλακίδιο θα μετακίνησει
                        //που θα το βαλει 
                        
                    }
                }
            }
        }
    }
    public void showTile(ArrayList<Tile> tiles)//Ε??ΦΑ????ΖΕΙ Ε??Α ΣΥ????Λ?? ΑΠ?? ΠΛΑ????ΔΙΑ
    {
        System.out.println("Στα χέ??ια σου έχεις:");
        for(Tile t: tiles)
        System.out.print("("+t.getLeft()+","+t.getRight()+")-");
    }
    
}
