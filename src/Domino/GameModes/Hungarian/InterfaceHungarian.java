/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
//System.out.println("");
import Domino.Base.*;
import java.util.ArrayList;

/**
 *
 * @author �??�����
 */
public class InterfaceHungarian {
    game_hungarian game;
    public InterfaceHungarian()
    {game=new game_hungarian();}
    public void ShowGame()
    {
        System.out.println("??���� �??��� ��� ����??��?? ��??����");//
        while(game.finishGame())
        {
            game.Start();
            System.out.println("�????�� "+game.getRound().numRound()+"��");
            while(game.movesPlayers())
            {
                if(game.getPlayer().get_number()==1)
                {
                    if(game.botTurn())
                    game.moveBotTurn();
                    if(game.playerTurn())
                    {
                        showTile(game.getPlayer().Tiles());
                        //��������� �� ������
                        //�������� ���?? �������� �� �����������
                        //��� �� �� ����� 
                        
                    }
                }
            }
        }
    }
    public void showTile(ArrayList<Tile> tiles)//�??��????��� �??� ��????�?? ��?? ���????���
    {
        System.out.println("��� ��??�� ��� �����:");
        for(Tile t: tiles)
        System.out.print("("+t.getLeft()+","+t.getRight()+")-");
    }
    
}
