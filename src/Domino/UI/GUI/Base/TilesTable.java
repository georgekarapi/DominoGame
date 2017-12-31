package Domino.UI.GUI.Base;

import Domino.Base.Dominoes;
import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TilesTable extends JPanel{
    private ArrayList<ArrayList<Tile>> tiles;
    public TilesTable(ArrayList<ArrayList<Tile>> tiles, int rows){
        this.tiles = tiles;
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRoundRect(getHeight() / 3, 10,getHeight() / 3, getWidth() - 20,5,5);
    }
}
