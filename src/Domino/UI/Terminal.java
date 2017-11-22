package Domino.UI;

import Domino.Base.Tile;
import Domino.GameModes.Hungarian.Hungarian;
import Domino.GameModes.SoloOne.SoloOne;

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

    public int inputTile(int min, int max) {
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
        } while (min <= input && input <= max);
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
            while (true) {
                System.out.println("Choose next tile");
                Scanner scan = new Scanner(System.in);
                int row = scan.nextInt();
                if (1 <= row && row <= 4) {
                    while (true) {
                        scan.nextLine();
                        System.out.println("Choose l(eft) or r(ight)");
                        String pos = scan.nextLine();
                        if (pos.equals("l")) {
                            solo.getTile(row - 1, true);
                            break;
                        } else if (pos.equals("r")) {
                            solo.getTile(row - 1, false);
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Choose between 1-4");
                }
            }
        }
    }

    public static void ShowHands(ArrayList<Tile> tiles, String s)//εμφανίζει τα πλακίδια που έχει στα χέρια ο παίχτης
    {
        System.out.println(s);
        for (Tile t : tiles)
            System.out.println(tiles.indexOf(t) + ".[" + t.getLeft() + "|" + t.getRight() + "]");
    }

    public static void showTabloDomino(ArrayList<Tile> tiles, String s)//εμφανίζει το ντόμινο ταμπλό
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
            ShowHands(game.getPlayer().Tiles(), "Your turn,your tiles are: ");
            showTabloDomino(game.getClassic().getTable(), "Dominoes are: ");
            System.out.println("Choose one of your tiles (number)");
            number = input.nextInt();//επιλέγει ποιό πλακίδιο θα μετακίνησει
            System.out.println("Choose l(eft) or r(ight)");
            s = input.next();
        } while (!game.movePlayerTurn(number, s));

    }

    public static void startGameHungarian(Hungarian game) {
        System.out.println("Welcome to the Hungarian Domino ");
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

    public static void main(String args[]) {
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
                    Hungarian game = new Hungarian();
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
