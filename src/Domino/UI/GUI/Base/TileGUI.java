package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class TileGUI extends JComponent{
    private final int posX,posY,width,height,w2,h2;
    private Area shape, comps;
    private Path2D complete;
    private BufferedImage bimage;
    private boolean rotate;
    private Tile tile;
    private Graphics2D g2d,components,pic;
    private String rot = "h";
    public Tile getTile(){ return tile;}
    public TileGUI(int l, int r, int width, int posX, int posY, boolean rotate) {
        setOpaque(false);
        tile = new Tile(l, r);
        this.rotate = rotate;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = width / 2;
        w2 = width/2;
        h2 = height/2;
        shape = new Area(new RoundRectangle2D.Double(0, 0, width, height,height / 6,height / 6));
        comps = new Area(new Rectangle2D.Double(w2,0,2,height));
        createDots(comps, tile.getLeft());
        //createDots(comps, tile.getRight());

        bimage = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_ARGB);
        pic = bimage.createGraphics();
        draw();
        CustomMouseAdapter mouseAdapter = new CustomMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    private Shape dot(float x, float y) {
        return new Ellipse2D.Float(0, 0, height / 6, height / 6);
    }
    private void createDots(Area comps, int num){
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
                comps.add(new Area(dot(((height / 6) / 2) + (w2 / 3), y + (height / 6) / 2)));
                comps.add(new Area(dot(((height / 6) / 2) + (w2 / 3) + (w2 / 3), y + (height / 6) / 2)));
                tnum -= 2;
            }else if(tnum != 0){
                comps.add(new Area(dot(((height / 6) / 2) + (w2 / 2), y + (height / 6) / 2)));
                if(tnum == 3){
                    comps.add(new Area(dot(((height / 6) / 2) + ((w2 / 2) - ((w2 / 2) / 2)), y + (height / 6) / 2)));
                    comps.add(new Area(dot(((height / 6) / 2) + ((w2 / 2) + ((w2 / 2) / 2)), y + (height / 6) / 2)));
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
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bimage,posX,posY,null);
    }

    public BufferedImage getImage(){
        return bimage;
    }
    public void draw() {
        pic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pic.setColor(Color.WHITE);
        pic.fill(shape);
        pic.setColor(Color.BLACK);
        pic.setStroke(new BasicStroke(1));
        pic.draw(shape);
        pic.fill(comps);
        pic.dispose();
    }
    public void rotate(){
        AffineTransform t = new AffineTransform();
        int rotation;
        if(rot.equals("h")){
            rotation = 90;
            rot = "v";
        }else{
            rotation = -90;
            rot = "h";
        }
        t.rotate(Math.toRadians(rotation), posX, posY);
        comps.transform(t);
        shape.transform(t);
    }

    class CustomMouseAdapter extends MouseAdapter{
        private boolean pressed = false;
        private Point point;

        public void mousePressed(MouseEvent e){
            if(e.getButton() != MouseEvent.BUTTON1){
                return;
            }

            if (shape != null && shape.contains(e.getPoint())) {
                pressed = true;
                this.point = e.getPoint();
            }
        }

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

        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }
    }
}
