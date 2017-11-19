/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Domino.GameModes.Hungarian;
import Domino.Base.*;

import java.util.ArrayList;
/**
 *
 * @author christos
 */
public class domino_tablo {
    private ArrayList<Tile> tablo;
    public domino_tablo()
    {
        tablo=new ArrayList<>();
    }
    public ArrayList<Tile> tablo
        (){return tablo;}
    public boolean first_tile(Tile t)//αν μπορεί να μπει στο αρχικό όχι σε άδειο ντόμινο
    {
           if(tablo.get(0).getLeft()==t.getLeft()|| tablo.get(0).getLeft()==t.getRight())
            return true;
           return false;
    }
    public boolean last_tile(Tile t)//αν μπορεί να μπει στο τελευταίο
    {
            if(tablo.get(tablo.size()-1).getRight()==t.getLeft()||tablo.get(tablo.size()-1).getRight()==t.getRight())
               return true;
           return false;    
    }
    private void move_all_tiles_right()
    {
        for(int i=tablo.size();i>1;i--)
          {
              Tile w=tablo.get(i-2);
              tablo.get(i-1).setRight(w.getRight());
              tablo.get(i-1).setLeft(w.getLeft());   
          }
    }
    public boolean first_change(Tile t)//παιρνει το πλακάκι και το βάζει πρώτο αν γίνεται ...
    {
        if(!first_tile(t))
            return false;
        tablo.add(new Tile());
        move_all_tiles_right();
      if(tablo.get(1).getLeft()==t.getLeft())
      {
           tablo.get(0).setRight(t.getLeft());
           tablo.get(0).setLeft(t.getRight());
      }
      else if(tablo.get(1).getLeft()==t.getRight())
      {
          tablo.get(0).setRight(t.getRight());
           tablo.get(0).setLeft(t.getLeft());
      }
      return true;
    }
    public boolean last_change(Tile t)//παίρνει το πλακάκι και το βάζει στο  τελευταίο
    {
        if(!last_tile(t))
        {return false;}
        tablo.add(new Tile());
      if(tablo.get(tablo.size()-2).getRight()==t.getLeft())
      {
           tablo.get(tablo.size()-1).setLeft(t.getLeft());
           tablo.get(tablo.size()-1).setRight(t.getRight());
      }
      else if(tablo.get(tablo.size()-2).getRight()==t.getRight())
      {
          tablo.get(tablo.size()-1).setRight(t.getLeft());
           tablo.get(tablo.size()-1).setLeft(t.getRight());
      }
      return true;
    }
       public Tile getfirstTile(){return tablo.get(0);}
       public Tile getlastTile(){return tablo.get(tablo.size()-1);}
       public boolean emptyTabloAddTile(Tile t)//μόνο για την πρώτη περίπτωση όταν είναι άδειο το ταμπλό μπαίνει το πρωtό πλακάκι
       {
           if(tablo.isEmpty())
           {tablo.add(t);
           return true;}
           return false;
       }
       public void deleteTiles()
       {tablo.clear();}

}
/*ΈΧΕΙ ΕΛΕΓΘΕΙ ΌΤΙ ΕΙΝΑΙ ΣΩΣΤΗ*/