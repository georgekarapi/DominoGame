package Domino.UI.GUI.GameModes;

import Domino.GameModes.SoloOne.SoloOne;
import Domino.UI.GUI.Base.Deck;
import Domino.UI.GUI.Base.TableGUI;
import Domino.UI.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class SoloOneGUI extends JPanel{
    private SoloOne soloOne;
    public String gameOver = null;
    public Deck deck;
    public SoloOneGUI(){
        soloOne = new SoloOne();

        JPanel tableGUI = new JPanel();
        TableGUI table = new TableGUI(soloOne, tableGUI);
        deck = new Deck(soloOne.tilesLeft(), 4, 7, table);
        table.deck = deck;
        deck.setSoloOneGUI(this);
        tableGUI.setBackground(Color.pink);
        tableGUI.setLayout(null);
        setLayout(null);
        tableGUI.setBounds(100, 10, 600, 500);
        deck.setBounds(0, 510, 812, 512);
        add(tableGUI);
        add(deck);
    }

    public void setGameOver() {
        soloOne.tiles_size--;
        if (soloOne.tiles_size == 0 || !soloOne.anyMoves()) {
            if (!soloOne.anyMoves() && soloOne.tiles_size != 0) {
                gameOver = "You lost! No more moves";
            } else {
                gameOver = "You won!";
            }
            System.out.println(gameOver);
            deck.setVisible(false);
            JOptionPane.showMessageDialog(getRootPane(), gameOver);
            int newGame = JOptionPane.showConfirmDialog(null,
                    "Would you like to start a New Game?",
                    "GameOver!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (newGame == JOptionPane.YES_OPTION) {
                System.out.println("Starting new game.");
                GUI.startGame("SoloOne");
            } else {
                GUI.showNewDialog();
            }
        }
    }

}
