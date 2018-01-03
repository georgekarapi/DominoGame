package Domino.UI.GUI.Base;

import Domino.Base.Tile;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class TileGUI extends Tile {
    private final int width,height,w2,h2;
    private Area shape, comps;
    private BufferedImage domino;
    private Graphics2D pic;
    String rotation = "h";

    public TileGUI(int l, int r, int width, boolean rotate) {
        super(l, r);
        this.width = width;
        this.height = width / 2;
        w2 = this.width/2;
        h2 = this.height/2;
        shape = new Area(new RoundRectangle2D.Double(0, 0, width, height,height / 6,height / 6));
        comps = new Area(new Rectangle2D.Double(w2,0,2,height));
        createDots(comps, 0, getLeft());
        createDots(comps, w2, getRight());

        domino = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_ARGB);
        pic = domino.createGraphics();
        draw(rotate);
    }
    private Shape dot(float x, float y) {
        return new Ellipse2D.Float(x, y, height / 6, height / 6);
    }
    private void createDots(Area comps,int x, int num){
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
                comps.add(new Area(dot((x - (height / 6) / 2) + (w2 / 3), y - (height / 6) / 2)));
                comps.add(new Area(dot((x - (height / 6) / 2) + (w2 / 3) + (w2 / 3), y - (height / 6) / 2)));
                tnum -= 2;
            }else if(tnum != 0){
                comps.add(new Area(dot((x - (height / 6) / 2) + (w2 / 2), y - (height / 6) / 2)));
                if(tnum == 3){
                    comps.add(new Area(dot((x - (height / 6) / 2) + ((w2 / 2) - ((w2 / 2) / 2)), y - (height / 6) / 2)));
                    comps.add(new Area(dot((x - (height / 6) / 2) + ((w2 / 2) + ((w2 / 2) / 2)), y - (height / 6) / 2)));
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

    public BufferedImage getImage(){
        return domino;
    }

    public void draw(boolean rotate) {
        pic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pic.setColor(Color.WHITE);
        pic.fill(shape);
        pic.setColor(Color.BLACK);
        pic.setStroke(new BasicStroke(1));
        pic.draw(shape);
        pic.fill(comps);
        if (rotate) {
            rotate();
        }
        pic.dispose();
    }

    public void rotate() {
        AffineTransform t = new AffineTransform();
        BufferedImage rotated = new BufferedImage(height + 1, width + 1, BufferedImage.TYPE_INT_ARGB);
        ;
        int orientation;
        if (rotation.equals("h")) {
            pic = rotated.createGraphics();
            orientation = 90;
            rotation = "v";
        } else {
            orientation = -90;
            rotation = "h";
        }
        t.rotate(Math.toRadians(orientation), domino.getWidth() / 2, domino.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(t,
                AffineTransformOp.TYPE_BILINEAR);
        domino = op.filter(domino, null);
    }
}