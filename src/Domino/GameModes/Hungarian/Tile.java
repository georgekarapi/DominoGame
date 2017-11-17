/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungarian;

/**
 *
 * @author Χρίστος
 */
public class Tile {

    private int left;
    private int right;
    public Tile()
    {
        left=0;
        right=0;
    }
    public Tile(int l,int r){
        left = l;
        right = r;
    }
    public int getRight(){
        return right;
    }
    public int getLeft(){
        return left;
    }
    public void setRight(int r){
    right=r; }
    public void setLeft(int l)
    {left=l;}
    public int getTotal(){
        return left + right;
    }//To change body of generated methods, choose Tools | Templates.
    
    
}
