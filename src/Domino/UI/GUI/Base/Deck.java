package Domino.UI.GUI.Base;

import Domino.Base.Tile;
import Domino.UI.GUI.GameModes.SoloOneGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck extends JPanel{
    public TableGUI tableGUI;
    public ArrayList<ArrayList<Tile>> tileList;
    private ArrayList<ArrayList<DraggableImage>> tiles;
    private SoloOneGUI soloOneGUI;

    public Deck(ArrayList<ArrayList<Tile>> tileList, int collumns, int rows, TableGUI tableGUI) {
        this.tableGUI = tableGUI;
        tiles = new ArrayList<>();
        this.tileList = tileList;
        setBorder(BorderFactory.createTitledBorder("Deck"));
        setPreferredSize(new Dimension(812, 512));
        if (tileList.size() == 1) {
            setLayout(new GridLayout(1, 7, 5, 5));
        } else {
            setLayout(null);
        }
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

    public int searchArray(DraggableImage tile) {
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).get(tiles.get(i).size() - 1) == tile) {
                return i;
            }
        }
        return 0;
    }

    public void setSoloOneGUI(SoloOneGUI gui) {
        this.soloOneGUI = gui;
    }

    public void removeTile(DraggableImage tile) {
        int row = searchArray(tile);
        tiles.get(row).remove(tiles.get(row).size() - 1 > 0 ? tiles.get(row).size() - 1 : 0);
        tileList.get(row).remove(tileList.get(row).size() - 1);
        tiles.get(row).get(tiles.get(row).size() - 1 > 0 ? tiles.get(row).size() - 1 : 0).enableMouse();
        tile.setVisible(false);
        remove(tile);
        revalidate();
        repaint();
        soloOneGUI.setGameOver();
    }
}
