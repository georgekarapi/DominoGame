package Domino.UI.GUI.GameModes;

import Domino.GameModes.SoloOne.SoloOne;
import Domino.UI.GUI.Base.Deck;
import Domino.UI.GUI.Base.TableGUI;

import javax.swing.*;
import java.awt.*;

public class SoloOneGUI extends JPanel{
    private SoloOne soloOne;
    public SoloOneGUI(){
        soloOne = new SoloOne();

        JPanel tableGUI = new JPanel();
        TableGUI table = new TableGUI(soloOne, tableGUI);
        Deck deck = new Deck(soloOne.tilesLeft(), 4, 7, table);
        table.deck = deck;
        tableGUI.setBackground(Color.pink);
        tableGUI.setLayout(null);
        setLayout(null);
        tableGUI.setBounds(100, 10, 600, 500);
        deck.setBounds(0, 510, 812, 512);
        add(tableGUI);
        add(deck);
    }
    public static void main(String args[]) {
        JFrame jFrame = new JFrame("Solo");
        jFrame.setSize(812, 812);
        jFrame.setContentPane(new SoloOneGUI());
        jFrame.setVisible(true);
    }

}
