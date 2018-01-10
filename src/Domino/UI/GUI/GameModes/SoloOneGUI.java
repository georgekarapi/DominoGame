package Domino.UI.GUI.GameModes;

import Domino.GameModes.SoloOne.SoloOne;
import Domino.UI.GUI.Base.Deck;
import Domino.UI.GUI.Base.TableGUI;
import Domino.UI.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class SoloOneGUI extends JPanel{
    private SoloOne soloOne;
    public SoloOneGUI(){
        soloOne = new SoloOne();
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        Deck deck = new Deck(soloOne.tilesLeft(), 4, 7);
        JPanel tableGUI = new JPanel();
        tableGUI.setMinimumSize(new Dimension(512,512));
        TableGUI table = new TableGUI(soloOne, tableGUI);
        add(tableGUI);
        add(deck);
    }
    public static void main(String args[]) {
        JFrame jFrame = new JFrame("Solo");
        jFrame.setSize(712,712);
        jFrame.add(new  SoloOneGUI());
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
