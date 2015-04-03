package gui.major.videoinfo.videoimage.originalview;

import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-3-2
 * Timex: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
public class Image1xDispalyPanel extends JPanel {

    public void setImage(BufferedImage image) {
        if (this.image == image)
            return;

        this.image = image;
        Dimension size = new Dimension(image.getWidth(), image.getHeight());

        SizeUtil.sameSize(this,size);

        repaint();

        return;
    }

    private BufferedImage image = null;

    public Image1xDispalyPanel() {
        super();
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (image == null) {
            return;
        }

        ImageUtil.drawImage(graphics,this,image);
    }

}
