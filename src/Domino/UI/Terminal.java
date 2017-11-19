package Domino.UI;

import Domino.Base.Tile;

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
    public void ShowHands(ArrayList<Tile> tiles,String s)//εμφανίζει τα πλακίδια που έχει στα χέρια ο παίχτης
    {
        System.out.println(s);
        for(Tile t:tiles)
            System.out.println(tiles.indexOf(t)+".["+t.getLeft()+"|"+t.getRight()+"]");
    }
    public void showTabloDomino(ArrayList<Tile> tiles,String s)//εμφανίζει το ντόμινο ταμπλό
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
    public void Points(String p,int point)
    {
        System.out.println(p+" have "+point+" points");
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
                    //Hungarian
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
