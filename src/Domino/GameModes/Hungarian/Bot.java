/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
package Player;
        import java.util.ArrayList;
        import java.util.Random;

/**
 * @author Χρίστος
 */
public class Bot extends Player {
    public Bot() {
        super();
    }

    public boolean byTile(int l)//ελένχει αν ένα πλακίδιο μπορεί να κολήσει μια μεριά(είτε στην αριστερή είτε στην δεξιά)
    {
        for (Tile t : Tiles()) {
            if (t.getLeft() == l || t.getRight() == l)
                return true;
        }
        return false;
    }

    public Tile movement_tile(int r)//επιστρέφει το πλακίδιο που είναι να κολήσει στο ταμπλό του ντόμινο
    {
        ArrayList<Tile> move = new ArrayList<>();
        Random r1 = new Random();
        for (Tile t : Tiles()) {
            if (t.getLeft() == r)
                move.add(t);
            else if (t.getRight() == r)
                move.add(t);
        }
        for (Tile t : move)
            System.out.print("(" + t.getLeft() + "," + t.getRight() + ")-");
        int x;
        if (move.size() == 1)
            x = 0;
        else
            x = r1.nextInt(move.size() - 1);
        Tiles().remove(move.get(x));
        return move.get(x);
    }

    public boolean win() {
        if (Tiles().isEmpty()) return true;
        return false;
    }

    public void showTile() {
        System.out.println("Στα χέρια του το μποτ έχει:");
        for (Tile t : Tiles())
            System.out.print("(" + t.getLeft() + "," + t.getRight() + ")-");
    }
}
/* έχει γίνει έλεγχος*/

/**/