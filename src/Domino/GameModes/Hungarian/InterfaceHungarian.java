/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
//System.out.println("");
import Domino.Base.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Χ??ίστος
 */
public class InterfaceHungarian {
    private game_hungarian game;
    private Scanner input=new Scanner(System.in);
    public InterfaceHungarian()
    {game=new game_hungarian();}
    public void ShowGame()
    {
        System.out.println("Καλως ήρθες στο ουγγγρικο ντομινο");//
        while(!game.finishGame())
        {
            game.Start();
            System.out.println("Γύρος "+game.getRound().numRound()+"ος");
            while(game.movesPlayers())
            {

                if(game.getPlayer().get_number()==1)
                {
                    while(game.playerTurn())
                    {inputPlayer();}
                    while(game.botTurn())
                    {game.moveBotTurn();}
                }
            }
            game.finishRound();
        }
    }

    public void showTile(ArrayList<Tile> tiles,String s)//ΕΜΦΑΝΊΖΕΙ μια σειρά ΑΠΟ ΠΛΑΚΊΔΙΑ
    {
        System.out.println(s);
        for(Tile t: tiles)
        {
            if(t==tiles.get(tiles.size()-1))
                System.out.print("("+t.getLeft()+","+t.getRight()+")");
            else
            System.out.print("("+t.getLeft()+","+t.getRight()+")-");
        }
        System.out.println();
    }
    public void showHands(ArrayList<Tile> tiles,String s)
    {
        System.out.println(s);
        for(Tile t:tiles)
            System.out.println(tiles.indexOf(t) + ".(" + t.getLeft() + "," + t.getRight() + ")");

    }
    public void inputPlayer()
    {
        int number;
        String s;
        do{
            showHands(game.getPlayer().Tiles(),"Στα χέρια σου έχεις:");
            showTile(game.getClassic().tablo(),"Το ταμπλό του παιχνιδιού είναι:");//εμφανίζει το ταμπλο
            System.out.println("Διάλεξε ένα απο τα πλακάκια σου");
            number=input.nextInt();//επιλέγει ποιό πλακίδιο θα μετακίνησει
            System.out.println("Στο τέρμα αριστερά ή στο τέρμα δεξιά(right or left)");
            s=input.next();
        }while(!game.movePlayerTurn(number,s));

    }
}
