package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class TileGUI extends JPanel{
    private final int l,r,posX,posY,width,height,w2,h2;
    public TileGUI(int l, int r,int width, int height, int posX, int posY) {
        this.l = l;
        this.r = r;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        w2 = width/2;
        h2 = height/2;
    }
    private Shape dot(int x, int y) {
        return new Ellipse2D.Float(x, y, 10, 10);
    }
    private void createDots(Area comps, int posX, int posY, int num){
        int rows = 1;
        int y = h2;
        int tnum = num;
        if(num > 3){
            rows = 2;
            y /= 2;
            tnum -= 2;
            if(num == 6){ tnum--;}
        }
        for (int i = 0; i < rows; i++) {
            if(tnum == 2){
                comps.add(new Area(dot((posX - 5) + (w2 / 3), y + posY - 5)));
                comps.add(new Area(dot((posX - 5) + (w2 / 3) + (w2 / 3), y + posY - 5)));
                tnum -= 2;
            }else{
                comps.add(new Area(dot((posX - 5) + (w2 / 2), y + posY - 5)));
                if(tnum == 3){
                    comps.add(new Area(dot((posX - 5) + ((w2 / 2) - ((w2 / 2) / 2)), y + posY - 5)));
                    comps.add(new Area(dot((posX - 5) + ((w2 / 2) + ((w2 / 2) / 2)), y + posY - 5)));
                    tnum -= 2;
                }
                tnum--;
            }
            y += h2;
            if(num > 3){
                tnum += 2;
                if(num == 6){ tnum++;}
            }
        }
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D components = (Graphics2D) g;
        Shape tile = new RoundRectangle2D.Double(posX, posY, width, height,10,10);
        Area shape = new Area(tile);
        Area comps = new Area();
        comps.add(new Area(new Rectangle2D.Double(posX + w2,posY,2,60)));

        createDots(comps, posX, posY, l);
        createDots(comps, posX + w2, posY, r);

        g2d.setColor(Color.WHITE);
        g2d.fill(shape);
        components.setColor(Color.BLACK);
        components.fill(comps);
        components.drawRoundRect(this.posX, this.posY, width, height,10,10);
    }
}
