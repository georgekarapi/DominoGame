package Domino.GameModes;

import Domino.Base.Dominoes;
import Domino.GameModes.Hungarian.Bot;
import Domino.GameModes.Hungarian.Player;

import java.util.ArrayList;

public class Cardinal {
    private ArrayList<Bot> bots;
    private Player player;
    private Dominoes dominoes;

    public Cardinal(int players, String name){
        dominoes = new Dominoes();
        bots = new ArrayList<>();
        if(players > 2){
            for(int i = 0; i < players - 1; i++){
                bots.add(new Bot("Bot" + i));
                for(int j = 0; j < 5; j++){
                    bots.get(i).add(dominoes.giveTile());
                }
            }
        }else{
            bots.add(new Bot("Bot0"));
            for(int i = 0; i < 7; i++){
                bots.get(0).add(dominoes.giveTile());
            }
            player = new Player(name);
            for(int i = 0; i < 7; i++){
                player.add(dominoes.giveTile());
            }
        }
        startGame();
    }
    public void startGame(){

    }
}
