package Domino.UI.GUI.Base;


import Domino.GameModes.Hungarian.Hungarian;
import Domino.UI.GUI.GameModes.HungarianGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DraggableImage extends JLabel {
    private TileGUI tile;
    private BufferedImage image;
    private int width;
    private CustomMouseAdapter mouseAdapter;

    public DraggableImage(int l, int r, int width, boolean rotate) {
        this.width = width;
        tile = new TileGUI(l, r, width, rotate);
        image = tile.getImage();
        setIcon(new ImageIcon(image));
        mouseAdapter = new CustomMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void rotate() {
        tile = new TileGUI(tile.getLeft(), tile.getRight(), width + 1, tile.rotation == "h" ? true : false);
        image = tile.getImage();
        setIcon(new ImageIcon(image));
        revalidate();
        repaint();
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

                if (getRootPane().getLayeredPane().getLayer(e.getComponent()) != JLayeredPane.DRAG_LAYER) {
                    getRootPane().getLayeredPane().add(DraggableImage.this, JLayeredPane.DRAG_LAYER);
                }
                old = getLocation();
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
           // JPanel jPanel = TableGUI();
           // if(jPanel.contains(e.getPoint())){
           //     System.out.println("in");
          //  }
           // else{
                setBounds(old.x, old.y, image.getWidth(), image.getHeight());
          //  }
            pressed = false;
        }
    }
}
