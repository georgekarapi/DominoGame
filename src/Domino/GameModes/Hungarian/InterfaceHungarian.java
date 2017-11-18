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
import Domino.UI.*;
/**
 *
 * @author Χ??ίστος
 */
public class InterfaceHungarian {
    private Terminal cout;
    private game_hungarian game;
    private Scanner input=new Scanner(System.in);
    public InterfaceHungarian()
    {game=new game_hungarian();
        cout=new Terminal();}
    public void ShowGame()
    {
        System.out.println("Καλως ήρθες στο ουγγγρικο ντομινο");
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
                    {
                    game.moveBotTurn();cout.ShowHands(game.getRobot().Tiles(),"Robot have hands:");
                    }
                }
                else if(game.getRobot().get_number()==1)
                {
                    while(game.botTurn())
                    {System.out.println("Its Robot turn");

                    game.moveBotTurn();}
                    while(game.playerTurn())
                    {inputPlayer();}
                }
            }
            System.out.println("Finish round "+game.getRound().numRound()+"ος");
            game.finishRound();
            cout.Points("player1 ",game.getRound().pointPlayer(game.getPlayer()));
            cout.Points("Robot ",game.getRound().pointPlayer(game.getRobot()));
            game.deleteHands(game.getPlayer());
            game.deleteHands(game.getRobot());
            game.newRound();

        }
        if(game.getRound().pointPlayer(game.getPlayer())>=100)
            System.out.println("You win");
        else
            System.out.println("You lost");
    }
    public void inputPlayer()
    {
        int number;
        String s;
        do{
            cout.ShowHands(game.getPlayer().Tiles(),"Your turn,your tiles are:");
            cout.showTabloDomino(game.getClassic().tablo(),"Ntominino tablo is");
            System.out.println("Διάλεξε ένα απο τα πλακάκια σου(αριθμό)");
            number=input.nextInt();//επιλέγει ποιό πλακίδιο θα μετακίνησει
            System.out.println("Στο τέρμα δεξιά ή στο τέρμα αριστερά(right or left)");
            s=input.next();
        }while(!game.movePlayerTurn(number,s));

    }
}
