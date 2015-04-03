package gui.util.button;

import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-3-3
 * Timex: 下午2:52
 * To change this template use File | Settings | File Templates.
 */
public class ImageButton extends JButton implements MouseListener {
    private final BufferedImage imageMouseOff;
    private final BufferedImage imageMouseOn;
    private final BufferedImage imageInactive;
    private boolean mouseOn;

    private final boolean usingGradBackground;

    private ImageButton(BufferedImage imageMouseOff,
                        BufferedImage imageMouseOn,
                        BufferedImage imageInactive,
                        final boolean usingGradBackground) {
        super();
        this.imageMouseOff = imageMouseOff;
        this.imageMouseOn = imageMouseOn;
        this.imageInactive = imageInactive;
        this.usingGradBackground = usingGradBackground;
        mouseOn = false;
        Dimension size = new Dimension(32, 32);
        setPreferredSize(size);
        setMinimumSize(size);
        setSize(size);

        addMouseListener(this);
    }

    public static ImageButton build(BufferedImage imageMouseOff,
                                    BufferedImage imageMouseOn,
                                    BufferedImage imageInactive) {
        return build(imageMouseOff, imageMouseOn, imageInactive, true);
    }

    public static ImageButton build(BufferedImage imageMouseOff,
                                    BufferedImage imageMouseOn,
                                    BufferedImage imageInactive,
                                    boolean usingGradBackground) {
        return new ImageButton(imageMouseOff, imageMouseOn, imageInactive, usingGradBackground);
    }

    private BufferedImage getImage() {
        if (!isEnabled()) {
            return imageInactive;
        }
        if (mouseOn) {
            return imageMouseOn;
        } else {
            return imageMouseOff;
        }
    }

    protected void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);

        Dimension size = getSize();

        Graphics2D g2 = (Graphics2D) graphics;

        if (usingGradBackground) {
            g2.setPaint(GradUtil.buildGrad(this));

            g2.fill(new Rectangle(size));
        }


        BufferedImage bufferedImage = getImage();
        int imageWith = bufferedImage.getWidth();
        int imageHeight = bufferedImage.getHeight();

        int pointX = (int) ((size.getWidth() - imageWith) / 2);
        int pointY = (int) ((size.getHeight() - imageHeight) / 2);

        g2.drawImage(bufferedImage, pointX, pointY, null);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        mouseOn = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        mouseOn = false;
        repaint();
    }
}
