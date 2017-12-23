package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class TileGUI extends JPanel{
    public int l,r,posX,posY;
    public TileGUI(int l, int r) {
        this.l = l;
        this.r = r;
        posX = 40;
        posY = 35;
    }
    private Shape dot(int x, int y) {
        return new Ellipse2D.Float(x, y, 10, 10);
    }
    public void paint(Graphics g){
        int tileX = 120;
        int tileY = 60;
        int rows = 1;
        Graphics2D g2d = (Graphics2D) g;
        Shape tile = new Rectangle2D.Double(posX, posY, tileX, tileY);
        Area shape = new Area(tile);

        shape.subtract(new Area(new Rectangle2D.Double(posX + (tileX / 2),posY,2,60)));
        System.out.println("running");
        int y = (tileY / 2);
        if(l > 3){
            rows = 2;
            y /= 2;
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <= l; j++){
                System.out.println(l);
                if(l == 1 || l == 4){
                    shape.subtract(new Area(dot((posX - 5) + ((tileX / 2) / 2),y + posY - 5)));
                    l--;
                    System.out.println("1st");
                }
                else if(l == 2 || l == 5){
                    shape.subtract(new Area(dot((posX - 5) + (((tileX / 2) / 2) - (((tileX / 2) / 2) / 2)),y + posY - 5)));
                    l--;
                    System.out.println("2nd");
                }
                else if(l == 3 || l == 6){
                    shape.subtract(new Area(dot((posX - 5) + (((tileX / 2) / 2) + (((tileX / 2) / 2) / 2)),y + posY - 5)));
                    l--;
                    System.out.println("3rd");
                }
            }
            y += (tileY / 2);
        }
        g2d.draw(shape);
    }
}
