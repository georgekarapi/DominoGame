package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck extends JPanel{
    public Deck(ArrayList<ArrayList<Tile>> tile, int collumns, int rows){
        setBorder(BorderFactory.createTitledBorder("Deck"));
        setMinimumSize(new Dimension(200, 200));
    }
}
