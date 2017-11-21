package Domino.UI;

import java.util.Scanner;
import Domino.Base.Tile;
import Domino.GameModes.Hungarian.*;
import java.util.ArrayList;
import java.util.Scanner;

import Domino.GameModes.SoloOne.SoloOne;

/**
 * @author Giorgos & Christos
 */

public class Terminal {
    public static String stringifyTile(Tile t){
        return "["+t.getLeft()+"|"+t.getRight()+"]";
    }
    public static void printTiles(ArrayList<ArrayList<Tile>> tiles){
        for(int i = 0; i < tiles.size(); i++){
            for(int j = 0; j < tiles.get(i).size(); j++){
                System.out.print(stringifyTile(tiles.get(i).get(j)));
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printTiles2(ArrayList<Tile> tiles){
        for(int i = 0; i < tiles.size(); i++){
            System.out.print(stringifyTile(tiles.get(i)));
        }
        System.out.println();
    }
    public static void clearConsole(){
        final String os = System.getProperty("os.name");
        try{
            if(os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            }else{
                Runtime.getRuntime().exec("clear");
            }
        }catch (Exception e){
            System.err.print(e);
        }
    }
    public static void gameOver(String reason){
        clearConsole();
        System.out.println(reason);
        System.out.println("**********GameOver!**********");
    }
    public static void startSolo(){
        SoloOne solo = new SoloOne();
        while(!solo.gameOver){
            clearConsole();
            System.out.println("Tiles Left: ");
            printTiles(solo.tilesLeft());
            System.out.println("Tiles Played: ");
            printTiles2(solo.getTable());
            while (true) {
                System.out.println("Choose next tile");
                Scanner scan = new Scanner(System.in);
                int row = scan.nextInt();
                if(1 <= row && row <= 4) {
                    solo.getTile(row-1);
                    break;
                }else{
                    System.out.println("Choose between 1-4");
                }
            }
        }
    }

    public static void ShowHands(ArrayList<Tile> tiles, String s)//εμφανίζει τα πλακίδια που έχει στα χέρια ο παίχτης
    {
        System.out.println(s);
        for(Tile t:tiles)
            System.out.println(tiles.indexOf(t)+".["+t.getLeft()+"|"+t.getRight()+"]");
    }

    public static void showTabloDomino(ArrayList<Tile> tiles, String s)//εμφανίζει το ντόμινο ταμπλό
    {
        System.out.println(s);
        if(!tiles.isEmpty()) {
            for (Tile t : tiles) {
                if (t == tiles.get(tiles.size() - 1))
                    System.out.println("[" + t.getLeft() + "|" + t.getRight() + "]");
                else
                    System.out.print("[" + t.getLeft() + "|" + t.getRight() + "]-");
            }
        }
        else
            System.out.println("not tiles hands");
    }

    public static void Points(String p, int point)
    {
        System.out.println(p+" have "+point+" points");
    }

    public static void inputPlayer(game_hungarian game) {
        Scanner input = new Scanner(System.in);
        int number;
        String s;
        do {
            ShowHands(game.getPlayer().Tiles(), "Your turn,your tiles are:");
            showTabloDomino(game.getClassic().tablo(), "Ntominino table is");
            System.out.println("Choose one of your tiles (number)");
            number = input.nextInt();//επιλέγει ποιό πλακίδιο θα μετακίνησει
            System.out.println("right or left");
            s = input.next();
        } while (!game.movePlayerTurn(number, s));

    }

    public static void startGameHungarian(game_hungarian game) {
        System.out.println("welcome to the Hungarian Domino ");
        while (!game.finishGame()) {
            game.Start();
            System.out.println("Round " + game.getRound().numRound() + "os");
            while (game.movesPlayers()) {

                if (game.getPlayer().get_number() == 1) {
                    while (game.playerTurn()) {
                        inputPlayer(game);
                    }
                    while (game.botTurn()) {
                        System.out.println("Its Robot turn");
                        game.moveBotTurn();//ShowHands(game.getRobot().Tiles(),"Robot have hands:");
                    }
                } else if (game.getRobot().get_number() == 1) {
                    while (game.botTurn()) {
                        System.out.println("Its Robot turn");

                        game.moveBotTurn();
                    }
                    while (game.playerTurn()) {
                        inputPlayer(game);
                    }
                }
            }
            System.out.println("Finish round " + game.getRound().numRound());
            game.finishRound();
            Points("player1 ", game.getRound().pointPlayer(game.getPlayer()));
            Points("Robot ", game.getRound().pointPlayer(game.getRobot()));
            game.deleteHands(game.getPlayer());
            game.deleteHands(game.getRobot());
            game.newRound();

        }
        if (game.getRound().pointPlayer(game.getPlayer()) >= 100)
            System.out.println("You win");
        else
            System.out.println("You lost");
    }
    public static void main(String args[]){
        int choice = 1;
        while(choice > 0) {
            System.out.println("Choose a GameMode/option: ");
            System.out.println();
            System.out.println("1.Solo 1");
            System.out.println("2.Hungarian");
            System.out.println("0. Exit");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    startSolo();
                    break;
                case 2:
                    game_hungarian game = new game_hungarian();
                    startGameHungarian(game);
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
