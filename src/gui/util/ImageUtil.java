package gui.util;

import log.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public final class ImageUtil {

    public static void drawImage(Graphics graphics, JComponent panel, BufferedImage image) {
        Dimension size = panel.getSize();

        int pointX = 0;
        int imageWith = image.getWidth();
        if( imageWith < size.getWidth() ){
            pointX = (int) ((size.getWidth() - imageWith)/2);
        }

        int pointY = 0;
        int imageHeight = image.getHeight();
        if( imageHeight < size.getHeight() ){
            pointY = (int) ((size.getHeight() - imageHeight)/2);
        }

        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(image,pointX,pointY, null);

    }

    public static BufferedImage scale(File imageFile, Dimension newSize) {
        return scale(loadImage(imageFile),newSize);
    }

    public static BufferedImage scale(BufferedImage originalImage, Dimension newSize) {
        double srcWidth = originalImage.getWidth();
        double srcHeigth = originalImage.getHeight();

        double widthScale = newSize.getWidth() / srcWidth;
        double heigthScale = newSize.getHeight() / srcHeigth;

                AffineTransform tx = new AffineTransform();
        tx.scale(widthScale, heigthScale);

        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);

        return op.filter(originalImage, null);
    }

    public static BufferedImage createImage(String gifFileName) {
        BufferedImage img = null;
        try {
            URL url = ImageUtil.class.getResource("/images/" + gifFileName);
            img = ImageIO.read(url);
        } catch (IOException e) {
            Trace.debug(e);
        }
        return img;
    }

    public static BufferedImage loadImage(File imageFileName) {
        BufferedImage img = null;
        try {
//            URL url = ImageUtil.class.getResource("/images/" + gifFileName);
            img = ImageIO.read(imageFileName);
        } catch (IOException e) {
            Trace.debug(e);
        }
        return img;
    }

    public static Icon createImageIcon(String gifFileName) {
        URL url = ImageUtil.class.getResource("/images/" + gifFileName);

        return new ImageIcon(url);

    }
}
