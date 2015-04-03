package gui.major.videoinfo.videoimage.thumbview;

import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

/**
 * User: 吴晓春
 */
public class ImageThumbDispalyPanel extends JPanel {

    private BufferedImage image = null;
    private BufferedImage scaledImage = null;

    private static final int WIDTH = 180;
    private static final int HEIGHT = 120;

    public ImageThumbDispalyPanel() {
        super();
        SizeUtil.sameSize(this,new Dimension(WIDTH, HEIGHT));
    }

    public void setImage(BufferedImage image) {
        if (this.image == image)
            return;

        this.image = image;
        if (this.image == null) {
            scaledImage = null;
            return;
        }

        scaledImage = ImageUtil.scale(image,new Dimension(WIDTH,HEIGHT));

        repaint();

        return;
    }



    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (image == null || scaledImage == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(scaledImage, null, null);
    }

}
