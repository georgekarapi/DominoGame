package Domino.UI;

import Domino.Base.Tile;

import java.util.ArrayList;

/**
 * @author Giorgos
 */

public class Terminal {
    public String stringifyTile(Tile t){
        return "["+t.getLeft()+"|"+t.getRight()+"]";
    }
    public void printTiles(ArrayList<ArrayList<Tile>> tiles){
        for(int i = 0; i < tiles.size(); i++){
            for(int j = 0; j < tiles.get(i).size(); j++){
                System.out.print(stringifyTile(tiles.get(i).get(j)));
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void clearConsole(){
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
    public static void gameOver(){
        clearConsole();
        System.out.print("GameOver!");
    }
}
