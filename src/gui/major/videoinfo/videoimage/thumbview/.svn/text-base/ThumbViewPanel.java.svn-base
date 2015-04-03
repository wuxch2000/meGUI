package gui.major.videoinfo.videoimage.thumbview;

import convert.*;
import gui.major.*;
import gui.util.*;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 */
public class ThumbViewPanel extends JPanel implements I_Update {

    ImageControlPanel imageControlPanel;
    ImageThumbDispalyPanel imageThumbDispalyPanel;

    ArrayList<BufferedImage> images;

    public VideoFile getVideoFile() {
        return videoFile;
    }

    VideoFile videoFile;

    public ThumbViewPanel() {
        super();
        LayoutUtil.UsingGridBagLayout(this);

        int column = 0, line = 0;
        imageThumbDispalyPanel = new ImageThumbDispalyPanel();
        add(imageThumbDispalyPanel, LayoutUtil.buildConstraints(line, column));

        line++;
        imageControlPanel = new ImageControlPanel(this);
        add(imageControlPanel, LayoutUtil.buildConstraints(line, column));

        images = new ArrayList<BufferedImage>();
    }


    public void setImages(File[] imageFiles) {
        images.clear();
        for (File imagefile : imageFiles) {
            images.add(ImageUtil.loadImage(imagefile));
        }
        if (imageFiles.length > 0) {
            imageControlPanel.setIndexRange(0, imageFiles.length - 1);
        }
    }

    public void imageChange(int index) {
        imageThumbDispalyPanel.setImage(images.get(index));
    }

    public void update(VideoFile newVideoFile) {
        if (newVideoFile == null) {
            images.clear();
            imageControlPanel.setDisable();
            imageThumbDispalyPanel.setImage(ImageUtil.createImage("main_icon.128.png"));
            return;
        }

        setImages(newVideoFile.getClip().getClipFiles());
        this.videoFile = newVideoFile;
    }


}
