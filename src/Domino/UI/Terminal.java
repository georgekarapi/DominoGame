package Domino.UI;

import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Bot;
import Domino.GameModes.Hungarian.Hungarian;
import Domino.GameModes.Hungarian.Player;
import Domino.GameModes.SoloOne.SoloOne;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Giorgos & Christos
 */

public class Terminal {
    public static String stringifyTile(Tile t) {
        return "[" + t.getLeft() + "|" + t.getRight() + "]";
    }

    public static void printTiles(ArrayList<ArrayList<Tile>> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            System.out.print(i+1+".");
            for (int j = 0; j < tiles.get(i).size(); j++) {
                System.out.print(stringifyTile(tiles.get(i).get(j)));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTiles2(ArrayList<Tile> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            System.out.print(stringifyTile(tiles.get(i)));
        }
        System.out.println();
    }

    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cmd.exe /c cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public static void gameOver(String reason) {
        clearConsole();
        System.out.println(reason);
        try {
            Thread.sleep(150);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("**********GameOver!**********");
    }

    public static boolean positionLeft(){
        Scanner scan = new Scanner(System.in);
        String input = new String();
        do{
            System.out.println("Choose l(eft) or r(ight)");
            input = scan.nextLine();
        }while(!((input.contains("l") || input.contains("L")) ^ ((input.contains("r") || input.contains("R")))));
        if((input.contains("l") || input.contains("L"))){
            return true;
        }else{
            return false;
        }
    }

    public static int inputTile(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            System.out.println("Choose a number between " + min + "-" + max);
            while (!scan.hasNextInt()) {
                System.out.println("That's not a number :( ");
                System.out.println("Choose a number between " + min + "-" + max);
                scan.next();
            }
            input = scan.nextInt();
        } while (min > input && input < max);
        return input;
    }

    public static void startSolo() {
        SoloOne solo = new SoloOne();
        while (!solo.gameOver) {
            clearConsole();
            System.out.println("Tiles Left: ");
            printTiles(solo.tilesLeft());
            System.out.println("Tiles Played: ");
            printTiles2(solo.getTable());
            int row = inputTile(1,4);
            solo.getTile(row - 1, positionLeft());
        }
    }

    public static void ShowHands(ArrayList<Tile> tiles, String s)
    {
        System.out.println(s);
        for (Tile t : tiles)
            System.out.println(tiles.indexOf(t) + ".[" + t.getLeft() + "|" + t.getRight() + "]");
    }

    public static void showTabloDomino(ArrayList<Tile> tiles, String s)
    {
        System.out.println(s);
        if (!tiles.isEmpty()) {
            for (Tile t : tiles) {
                if (t == tiles.get(tiles.size() - 1))
                    System.out.println("[" + t.getLeft() + "|" + t.getRight() + "]");
                else
                    System.out.print("[" + t.getLeft() + "|" + t.getRight() + "]-");
            }
        } else
            System.out.println("not tiles hands");
    }

    public static void Points(String p, int point) {
        System.out.println(p + " have " + point + " points");
    }

    public static void inputPlayer(Hungarian game) {
        Scanner input = new Scanner(System.in);
        int number;
        String s;
        do {
            ShowHands(game.my_player().Tiles(), "Your turn,your tiles are: ");
            showTabloDomino(game.getClassic().getTable(), "Dominoes are: ");
            System.out.println("Choose one of your tiles (number)");
            number = input.nextInt();
            System.out.println("Choose l(eft) or r(ight)");
            s = input.next();
      } while (!game.movePlayerTurn(number, s));

    }

    public static void startGameHungarian(Hungarian game,String name,int pl) {
        System.out.println("Welcome to the Hungarian Domino ");
        while (!game.finishGame()) {
            game.Start();
            System.out.println("Round " + game.getRound().numRound() + "os");
            while (game.movesPlayers()) {
                for (int i = 0; i < pl; i++) {
                    if (game.turn_notBot(i)) {
                        while (game.botTurn(i)) {
                            game.moveBotTurn(i);
                        }
                    } else {
                        while (game.playerTurn()) {
                            inputPlayer(game);
                        }
                    }
                }
            }
            System.out.println("Finish round " + game.getRound().numRound());
            game.finishRound();
            game.deleteHands();
            game.newRound();
        }
            if (game.getRound().pointPlayer(game.my_player()) >= 100)
                System.out.println("You win");
            else
                System.out.println("You lost");

    }
    public static void main(String args[]) {
        //Add input method
        int choice = 1;
        while (choice > 0) {
            System.out.println("Choose a GameMode/option: ");
            System.out.println();
            System.out.println("1.Solo 1");
            System.out.println("2.Hungarian");
            System.out.println("0. Exit");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    startSolo();
                    break;
                case 2:
                   Hungarian game = new Hungarian(3,"christos");
                   startGameHungarian(game,"christos",3);
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
