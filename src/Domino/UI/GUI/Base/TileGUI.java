package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class TileGUI extends JPanel{
    private final int l,r,posX,posY;
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
        int num = l;
        int posX = this.posX;
        int posY = this.posY;
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D components = (Graphics2D) g;
        Shape tile = new RoundRectangle2D.Double(posX, posY, tileX, tileY,10,10);
        Area shape = new Area(tile);
        Area comps = new Area();
        comps.add(new Area(new Rectangle2D.Double(posX + (tileX / 2),posY,2,60)));
        System.out.println("running");
        int y = (tileY / 2);
        if(l > 3){
            rows = 2;
            y /= 2;
        }
        for(int s = 0; s < 2; s++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <= l; j++) {
                    System.out.println(l);
                    if (num == 3 || num == 6) {
                        comps.add(new Area(dot((posX - 5) + (((tileX / 2) / 2) + (((tileX / 2) / 2) / 2)), y + posY - 5)));
                        num--;
                        System.out.println("1st");
                    } else if (num == 2 || num == 5) {
                        comps.add(new Area(dot((posX - 5) + (((tileX / 2) / 2) - (((tileX / 2) / 2) / 2)), y + posY - 5)));
                        num--;
                        System.out.println("2nd");
                    } else if (num == 1 || num == 4) {
                        comps.add(new Area(dot((posX - 5) + ((tileX / 2) / 2), y + posY - 5)));
                        num--;
                        System.out.println("3rd");
                    }
                }
                y += (tileY / 2);
            }
            y -= (tileY / 2);
            posX += (tileX / 2);
            num = r;
        }
        g2d.setColor(Color.WHITE);
        g2d.fill(shape);
        components.setColor(Color.BLACK);
        components.fill(comps);
        components.drawRoundRect(this.posX, this.posY, tileX, tileY,10,10);
    }
}
