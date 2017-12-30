package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class TileGUI extends JPanel{
    private final int posX,posY,width,height,w2,h2;
    private Area shape;
    private Area comps;
    private Tile tile;
    public Tile getTile(){ return tile;}
    public TileGUI(int l, int r,int width, int posX, int posY) {
        tile = new Tile(l, r);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = width / 2;
        w2 = width/2;
        h2 = height/2;
        Shape tile2d = new RoundRectangle2D.Double(posX, posY, width, height,height / 6,height / 6);
        shape = new Area(tile2d);
        comps = new Area();
        comps.add(new Area(new Rectangle2D.Double(posX + w2,posY,2,height)));

        createDots(comps, posX, posY, tile.getLeft());
        createDots(comps, posX + w2, posY, tile.getRight());
        CustomMouseAdapter mouseAdapter = new CustomMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    private Shape dot(float x, float y) {
        return new Ellipse2D.Float(x, y, height / 6, height / 6);
    }
    private void createDots(Area comps, int posX, int posY, int num){
        int rows = 1;
        int y = h2;
        int tnum = num;
        if(num > 3){
            rows = 2;
            y -= (height / 6);
            tnum -= 2;
            if(num == 6){ tnum--;}
        }
        for (int i = 0; i < rows; i++) {
            if(tnum == 2){
                comps.add(new Area(dot((posX - (height / 6) / 2) + (w2 / 3), y + posY - (height / 6) / 2)));
                comps.add(new Area(dot((posX - (height / 6) / 2) + (w2 / 3) + (w2 / 3), y + posY - (height / 6) / 2)));
                tnum -= 2;
            }else if(tnum != 0){
                comps.add(new Area(dot((posX - (height / 6) / 2) + (w2 / 2), y + posY - (height / 6) / 2)));
                if(tnum == 3){
                    comps.add(new Area(dot((posX - (height / 6) / 2) + ((w2 / 2) - ((w2 / 2) / 2)), y + posY - (height / 6) / 2)));
                    comps.add(new Area(dot((posX - (height / 6) / 2) + ((w2 / 2) + ((w2 / 2) / 2)), y + posY - (height / 6) / 2)));
                    tnum -= 2;
                }
                tnum--;
            }
            y += (height / 3);
            if(num > 3){
                tnum += 2;
                if(num == 6){ tnum++;}
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D components = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (shape != null) {
            g2d.setColor(Color.WHITE);
            g2d.fill(shape);
            components.setColor(Color.BLACK);
            components.fill(comps);
        }
    }
    class CustomMouseAdapter extends MouseAdapter{
        private boolean pressed = false;
        private Point point;

        @Override
        public void mousePressed(MouseEvent e){
            if(e.getButton() != MouseEvent.BUTTON1){
                return;
            }

            if (shape != null && shape.contains(e.getPoint())) {
                pressed = true;
                this.point = e.getPoint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (pressed && (e.getX() < getWidth() - w2/2 && e.getX() > 0 + w2/2) && (e.getY() < getHeight() - h2/2 && e.getY() > 0 + h2/2)) {
                int deltaX = e.getX() - point.x;
                int deltaY = e.getY() - point.y;
                shape.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
                comps.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
                point = e.getPoint();
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }
    }
}
