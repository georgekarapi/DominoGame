package Domino.UI.GUI;

import Domino.UI.GUI.GameModes.CardinalGUI;
import Domino.UI.GUI.GameModes.HungarianGUI;
import Domino.UI.GUI.GameModes.SoloOneGUI;

import javax.swing.*;

public class GUI{
    public static JFrame frame;
    public GUI(){
        showNewDialog();
    }

    public static void showNewDialog() {
        String[] options = {"SoloOne", "Hungarian", "Cardinal"};
        JFrame frame = new JFrame("DominoGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String answer = (String) JOptionPane.showInputDialog(frame,
                "Choose a GameMode",
                "New Game",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        startGame(answer);
    }

    public static void startGame(String option) {
        if (frame == null) {
            frame = new JFrame();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (option == "SoloOne") {
            frame.setSize(812, 812);
            frame.setContentPane(new SoloOneGUI());
        } else if (option == "Hungarian") {
            frame.setSize(812, 812);
            frame.setContentPane(new HungarianGUI());
        } else {
            frame.setSize(820, 801);
            frame.setContentPane(new CardinalGUI());
        }
        frame.setVisible(true);
    }


    public static void main(String args[]) {
        new GUI();
    }

}