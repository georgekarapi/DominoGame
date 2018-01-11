package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck extends JPanel{
    public TableGUI tableGUI;
    private ArrayList<ArrayList<DraggableImage>> tiles;

    public Deck(ArrayList<ArrayList<Tile>> tileList, int collumns, int rows, TableGUI tableGUI) {
        this.tableGUI = tableGUI;
        tiles = new ArrayList<>();
        setBorder(BorderFactory.createTitledBorder("Deck"));
        setPreferredSize(new Dimension(200, 200));
        setLayout(null);
        for (int i = 0; i < tileList.size(); i++) {
            ArrayList<DraggableImage> tilesRow = new ArrayList<>();
            for (int j = 0; j < tileList.get(i).size(); j++) {
                Tile tile = tileList.get(i).get(j);
                DraggableImage draggableImage = new DraggableImage(tile, 200 / 4, false);
                draggableImage.table = tableGUI;
                draggableImage.setBounds(j * (draggableImage.width + 25) + 15, i * (draggableImage.width / 2 + 15) + 20, draggableImage.width + 2, draggableImage.width / 2 + 2);
                tilesRow.add(draggableImage);
                draggableImage.disableMouse();
                add(draggableImage);
            }
            tilesRow.get(tilesRow.size() - 1).enableMouse();
            tiles.add(tilesRow);
        }
    }

    public void removeTile(DraggableImage tile) {
        remove(tile);
        revalidate();
    }
}
