package gui.util.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * User: 吴晓春
 * Date: 11-3-3
 * Timex: 下午2:52
 */
public class ImageLabel extends JButton implements MouseListener, ActionListener {
    private final BufferedImage image;
    private boolean mouseOn;

    public void setHighLight(final Boolean highLight) {
        this.highLight = highLight;
    }

    private Boolean highLight;

    public static ImageLabel build(BufferedImage bufferImage) {
        return new ImageLabel(bufferImage);
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    private ActionListener actionListener;

    private ImageLabel(BufferedImage image) {
        this.image = image;
        mouseOn = false;
        highLight = false;
        Dimension size = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setSize(size);

        addMouseListener(this);
        addActionListener(this);
    }

    private BufferedImage getImage() {
        return image;
    }

    static private Color HIGHLIGHT_COLOR = new Color(0, 0, 255); // blue
    static private Color MOUSE_ON_COLOR = new Color(153, 153, 255);
    //    static private Color MOUSE_ON_COLOR = new Color(255, 0, 0);
    private static final int STROCK_POINT = 10;

    protected void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);

        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(getImage(), getStartPoint().width, getStartPoint().height, null);

        if (highLight) {
            drawRectangleAroundImage(g2, HIGHLIGHT_COLOR);
            return;
        }

        if (mouseOn) {
            drawRectangleAroundImage(g2, MOUSE_ON_COLOR);
            return;
        }
    }

    private Dimension getStartPoint() {
        Dimension size = getSize();
        int imageWith = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        int pointX = (int) ((size.getWidth() - imageWith) / 2);
        int pointY = (int) ((size.getHeight() - imageHeight) / 2);
        return new Dimension(pointX, pointY);
    }

    private void drawRectangleAroundImage(Graphics2D g2, Color color) {
        Dimension size = getSize();
        int imageWith = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        int pointX = (int) ((size.getWidth() - imageWith) / 2);
        int pointY = (int) ((size.getHeight() - imageHeight) / 2);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(color);
        g2.setStroke(new BasicStroke(STROCK_POINT));
        g2.draw(new Rectangle(pointX, pointY, imageWith, imageHeight));
        g2.setStroke(oldStroke);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
        repaint();
    }
}
