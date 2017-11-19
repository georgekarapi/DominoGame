package Domino.UI;
import Domino.Base.Tile;

import java.util.ArrayList;

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
    public void ShowHands(ArrayList<Tile> til,String s)//Eμφανίζει ότι έχεις στα χέρια σου τα πλακίδια
    {
        System.out.println(s);
        for(Tile t:til)
            System.out.println(til.indexOf(t)+".["+t.getLeft()+"|"+t.getRight()+"]");
        System.out.println();
    }
    public void showTabloDomino(ArrayList<Tile> tiles,String s)//ΕΜΦΑΝΊΖΕΙ μια σειρά ΑΠΟ ΠΛΑΚΊΔΙΑ
    {
        System.out.println(s);
        for(Tile t: tiles)
        {
            if(t==tiles.get(tiles.size()-1))
                System.out.print("["+t.getLeft()+","+t.getRight()+"]");
            else
                System.out.print("["+t.getLeft()+","+t.getRight()+"]-");
        }
        System.out.println();
    }
    public void Points(String player,int point)
    {
        System.out.println(player+" have "+point+" points");
    }
}
