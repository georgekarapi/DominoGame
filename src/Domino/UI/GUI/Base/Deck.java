package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck extends JPanel{
    public TableGUI tableGUI;
    public Deck(ArrayList<ArrayList<Tile>> tiles, int collumns, int rows){
        setBorder(BorderFactory.createTitledBorder("Deck"));
        setMinimumSize(new Dimension(200, 200));
        setLayout(new GridLayout(4,7,2,2));
        for (int i = 0; i < tiles.size(); i++) {
            for (int j = 0; j < tiles.get(i).size(); j++) {
                Tile tile = tiles.get(i).get(j);
                DraggableImage draggableImage = new DraggableImage(tile.getLeft(), tile.getRight(), 200 / 4, true);
                draggableImage.table = tableGUI;
                add(draggableImage);
            }
        }
    }
}
