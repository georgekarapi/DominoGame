/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domino.GameModes.Hungarian;

import java.util.HashMap;

/**
 *
 * @author christos
 */
public class Round {
    private HashMap<Player,Integer> r;
    private int numberRound;
    public Round ()
    {
        r=new HashMap<>();
        numberRound=1;
    }
    public void add(Player p)
    {
        r.put(p, new Integer(0));
    }
    public void final_round(Player p,int points)
    {
        if(r.containsKey(p))
        {
           r.put(p, new Integer (points+r.get(p).intValue()));
        }
         numberRound=numberRound+1;
    }
    public int pointPlayer(Player p)
    {
        return r.get(p).intValue();
    }
    public int numRound()
    {return numberRound;}
   }
//ΕΧΕΙ ΕΛΕΓΧΘΕΙ