package gui.major.videoinfo.videoimage.originalview;

import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 */
public class OriginalViewPanel extends JPanel {

    Image1xDispalyPanel image1xDispalyPanel;
    ThumbListPanel thumbListPanel;

    public OriginalViewPanel() {
        super();
        LayoutManager layoutManager = new BoxLayout(this,BoxLayout.PAGE_AXIS);
        setLayout(layoutManager);

        image1xDispalyPanel = new Image1xDispalyPanel();
        add(image1xDispalyPanel);

        thumbListPanel = new ThumbListPanel(this);
        add(thumbListPanel);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

    }

    public void setImages(File[] imageFiles) {

        thumbListPanel.setImages(imageFiles);
        if( imageFiles.length >= 1 ){
            image1xDispalyPanel.setImage(ImageUtil.loadImage(imageFiles[0]));
        }

    }

    public void imageChange(File imageFile) {
        image1xDispalyPanel.setImage(ImageUtil.loadImage(imageFile));
    }
}
