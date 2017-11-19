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
}
