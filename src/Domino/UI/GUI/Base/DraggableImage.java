package Domino.UI.GUI.Base;


import Domino.Base.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DraggableImage extends JLabel {
    public TileGUI tile;
    public TableGUI table;
    private BufferedImage image;
    public int width;
    private CustomMouseAdapter mouseAdapter;

    public DraggableImage(Tile oldTile, int width, boolean rotate) {
        this.width = width;
        this.tile = new TileGUI(oldTile, width, rotate);
        image = tile.getImage();
        setIcon(new ImageIcon(image));
        mouseAdapter = new CustomMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void rotate() {
        tile = new TileGUI(tile, width + 1, tile.rotation == "h" ? true : false);
        image = tile.getImage();
        setIcon(new ImageIcon(image));
        revalidate();
        repaint();
    }

    public void disableMouse() {
        removeMouseListener(mouseAdapter);
        removeMouseMotionListener(mouseAdapter);
    }

    public void enableMouse() {
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public CustomMouseAdapter getMouseAdapter(){
        return mouseAdapter;
    }

    class CustomMouseAdapter extends MouseAdapter {
        private boolean pressed = false;
        private Point point, old;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            if(e.getComponent() instanceof DraggableImage) {

//                System.out.println(e.getComponent().getBounds());
//                System.out.println(e.getPoint());
//                Point pointer = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), e.getComponent().getParent());
//                System.out.println(pointer);
                if (getRootPane().getLayeredPane().getLayer(e.getComponent()) != JLayeredPane.DRAG_LAYER) {
                    getRootPane().getLayeredPane().add(DraggableImage.this, JLayeredPane.DRAG_LAYER);
                }
                if (getLocation().y < 200) {
                    old = new Point(getLocation().x, getLocation().y + 512);
                } else {
                    old = getLocation();
                }
                point = e.getPoint();
                pressed = true;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (pressed) {
                Point p = e.getPoint();
                p = SwingUtilities.convertPoint(e.getComponent(), p, e.getComponent().getParent());
                setBounds(p.x - point.x, p.y - point.y, image.getWidth(), image.getHeight());
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            if(pressed) {
                Point pointer = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), e.getComponent().getParent());
                if (table.p.getBounds().contains(pointer)) {
                    if (!table.add_tile(DraggableImage.this, pointer.x, pointer.y)) {
                        setBounds(old.x, old.y, image.getWidth(), image.getHeight());
                    }
                }
                else
                    setBounds(old.x, old.y, image.getWidth(), image.getHeight());
                pressed = false;
            }
        }
    }
}
