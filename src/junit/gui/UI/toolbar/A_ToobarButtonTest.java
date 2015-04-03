package junit.gui.UI.toolbar;

import gui.util.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public abstract class A_ToobarButtonTest extends AbstractAction implements MouseListener {

    public JButton getButton() {
        return button;
    }

    private class ImageButton extends JButton {

        public ImageButton() {
        }

        @Override
        protected void paintComponent(Graphics graphics) {
//            super.paintComponent(graphics);

            Dimension size = getSize();

            Graphics2D g2 = (Graphics2D) graphics;

            g2.setPaint(GradUtil.buildGrad(this));
            g2.fill(new Rectangle(size));

            BufferedImage image = getImage();
            int imageWith = image.getWidth();
            int imageHeight = image.getHeight();

            int pointX = (int) ((size.getWidth() - imageWith) / 2);
            int pointY = (int) ((size.getHeight() - imageHeight) / 2);

            g2.drawImage(image, pointX, pointY, null);

        }
    }


    private final BufferedImage activeImage;
    private final BufferedImage inactiveImage;
    private final BufferedImage activeMouseImage;

    private ImageButton button;

    public void setEnable(Boolean enable) {
        setEnabled(enable);
        button.repaint();
    }

    public void setToolTipText(String tipText) {
        button.setToolTipText(tipText);
    }

    public A_ToobarButtonTest(String activeGifString,
                              String inactiveGifString,
                              String activeMouseIconString) {
        button = new ImageButton();
        button.addActionListener(this);

        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);

        button.addMouseListener(this);

        activeImage = ImageUtil.createImage(activeGifString);
        inactiveImage = ImageUtil.createImage(inactiveGifString);
        activeMouseImage = ImageUtil.createImage(activeMouseIconString);

        int xGap = activeImage.getWidth() / 3;
        int yGap = activeImage.getHeight() / 3;

        SizeUtil.sameSize(button, new Dimension(activeImage.getWidth() + xGap,activeImage.getHeight() + yGap));
    }


    public BufferedImage getImage() {
        if (!isEnabled()) {
            return inactiveImage;
        }

        if (mouseIn)
            return activeMouseImage;

        return activeImage;
    }


    private boolean mouseIn = false;


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
        Trace.debug("A_ToobarButtonTest.mouseEntered():",
            "");
        mouseIn = true;
        button.repaint();
//        JUT_ToolBar.toolbarRepaint();
//        button.revalidate();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Trace.debug("A_ToobarButtonTest.mouseExited():",
            "");
        mouseIn = false;
        button.repaint();
//        JUT_ToolBar.toolbarRepaint();
//        button.revalidate();
    }
}
