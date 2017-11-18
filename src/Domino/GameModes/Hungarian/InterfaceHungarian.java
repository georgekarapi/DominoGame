/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;
//System.out.println("");
import Domino.Base.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author �??�����
 */
public class InterfaceHungarian {
    private game_hungarian game;
    private Scanner input=new Scanner(System.in);
    public InterfaceHungarian()
    {game=new game_hungarian();}
    public void ShowGame()
    {
        System.out.println("����� ����� ��� ��������� �������");//
        while(!game.finishGame())
        {
            game.Start();
            System.out.println("����� "+game.getRound().numRound()+"��");
            while(game.movesPlayers())
            {

                if(game.getPlayer().get_number()==1)
                {
                    while(game.playerTurn())
                    {inputPlayer();}
                    while(game.botTurn())
                    {game.moveBotTurn();}
                }
            }
            game.finishRound();
        }
    }

    public void showTile(ArrayList<Tile> tiles,String s)//����ͺ��� ��� ����� ��� ���ʺ���
    {
        System.out.println(s);
        for(Tile t: tiles)
        {
            if(t==tiles.get(tiles.size()-1))
                System.out.print("("+t.getLeft()+","+t.getRight()+")");
            else
            System.out.print("("+t.getLeft()+","+t.getRight()+")-");
        }
        System.out.println();
    }
    public void showHands(ArrayList<Tile> tiles,String s)
    {
        System.out.println(s);
        for(Tile t:tiles)
            System.out.println(tiles.indexOf(t) + ".(" + t.getLeft() + "," + t.getRight() + ")");

    }
    public void inputPlayer()
    {
        int number;
        String s;
        do{
            showHands(game.getPlayer().Tiles(),"��� ����� ��� �����:");
            showTile(game.getClassic().tablo(),"�� ������ ��� ���������� �����:");//��������� �� ������
            System.out.println("������� ��� ��� �� �������� ���");
            number=input.nextInt();//�������� ���� �������� �� �����������
            System.out.println("��� ����� �������� � ��� ����� �����(right or left)");
            s=input.next();
        }while(!game.movePlayerTurn(number,s));

    }
}
