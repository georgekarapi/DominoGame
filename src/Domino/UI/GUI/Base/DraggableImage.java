package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DraggableImage extends JLabel {
    private TileGUI tile;
    private BufferedImage image;

    public DraggableImage(int l, int r, int width, boolean rotate) {
        tile = new TileGUI(l, r, width, rotate);
        image = tile.getImage();
        setIcon(new ImageIcon(image));
        CustomMouseAdapter mouseAdapter = new CustomMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    class CustomMouseAdapter extends MouseAdapter {
        private boolean pressed = false;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            pressed = true;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (pressed) {
                Point p = e.getPoint();
                p = SwingUtilities.convertPoint(e.getComponent(), p, e.getComponent().getParent());
                setBounds(p.x, p.y, image.getWidth(), image.getHeight());
                repaint();
            }
        }
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }
    }
}
