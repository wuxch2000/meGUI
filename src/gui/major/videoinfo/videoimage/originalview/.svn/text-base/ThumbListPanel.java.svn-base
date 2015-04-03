package gui.major.videoinfo.videoimage.originalview;

import gui.util.*;
import gui.util.button.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.List;

import static gui.util.WindowOfListUtil.PosOfWindow.*;

/**
 * User: 吴晓春
 */
public class ThumbListPanel extends JPanel {

    private JButton leftButton;
    private JButton rightButton;

    private static final Dimension THUMB_SIZE = new Dimension(100, 80);

    private ImageLabelList thumbImages;

    private static int MAX_THUMB_DISPLAY = 4;

    private OriginalViewPanel originalViewPanel;
    private WindowOfListUtil<ImageLabel> windowOfListUtil;

    public ThumbListPanel(OriginalViewPanel originalViewPanel) {
        super();

        this.originalViewPanel = originalViewPanel;
        LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER);
        setLayout(layoutManager);

        thumbImages = new ImageLabelList();
        windowOfListUtil = new WindowOfListUtil<ImageLabel>(MAX_THUMB_DISPLAY,
            thumbImages);

        leftButton = ImageButton.build(
            ImageUtil.createImage("left_light.png"),
            ImageUtil.createImage("left_dark.png"),
            ImageUtil.createImage("left_inactive.png"),
            false);
        leftButton.addActionListener(leftKeyAction);
        registLeftKey(this);

        rightButton = ImageButton.build(
            ImageUtil.createImage("right_light.png"),
            ImageUtil.createImage("right_dark.png"),
            ImageUtil.createImage("right_inactive.png"),
            false);
        rightButton.addActionListener(rightKeyAction);
        registRightKey(this);

        initThumbDisplay();
    }


    private AbstractAction rightKeyAction = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (thumbImages.selectNext()) {
                if (windowOfListUtil.checkItemPos(thumbImages.getCurrentSelectedLabel())
                    == RIGHT) {
                    thumbViewMoveForward();
                }
                newSelection();
            }
        }
    };

    private AbstractAction leftKeyAction = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (thumbImages.selectPrev()) {
                if (windowOfListUtil.checkItemPos(thumbImages.getCurrentSelectedLabel())
                    == LEFT) {
                    thumbViewMoveBackward();
                }
                 newSelection();
            }
        }
    };

    private void registRightKey(JComponent jComponent) {

        final String s = "RIGHT";
        jComponent.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), s);
        jComponent.getActionMap().put(s, rightKeyAction);
    }


    private void registLeftKey(JComponent jComponent) {

        final String s = "LEFT";
        jComponent.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), s);
        jComponent.getActionMap().put(s, leftKeyAction);
    }


    JComponent buildEmptyLabel() {
        return ImageLabel.build(
            ImageUtil.scale(ImageUtil.createImage("empty.png"),
                THUMB_SIZE));
    }

    public void setImages(File[] imageFiles) {
        thumbImages.clear();
        windowOfListUtil.clear();

        for (File imageFile : imageFiles) {
            BufferedImage thumbsImage = ImageUtil.scale(imageFile, THUMB_SIZE);
            ImageLabel thumbLabel = ImageLabel.build(thumbsImage);
            thumbLabel.setActionListener(new ThumbClick(thumbLabel));
            thumbImages.add(thumbLabel, imageFile);
        }
        thumbImages.selectFirst();
        updateThumbDisplay();
    }

    private void initThumbDisplay() {
        addLeftButton();
        for (int i = 0; i < MAX_THUMB_DISPLAY; i++) {
            this.add(buildEmptyLabel());
        }
        addRightButton();
        this.validate();
    }

    private void updateButtonStatus() {
        if (thumbImages.isHead() ||
            thumbImages.getCurrentSelectedLabel() == null) {
            leftButton.setEnabled(false);
        } else {
            leftButton.setEnabled(true);
        }
        if (thumbImages.isTail()) {
            rightButton.setEnabled(false);
        } else {
            rightButton.setEnabled(true);
        }
    }

    private void addLeftButton() {
        add(leftButton);
    }

    private void addRightButton() {
        add(rightButton);
    }

    private void updateThumbDisplay() {
        this.removeAll();

        addLeftButton();
        List<ImageLabel> thumbs = windowOfListUtil.getSubListInWindow();

        JComponent displayComponent;
        for (int i = 0; i < MAX_THUMB_DISPLAY; i++) {
            if (i >= thumbs.size()) {
                displayComponent = buildEmptyLabel();
            } else {
                displayComponent = thumbs.get(i);

            }
            this.add(displayComponent);

        }
        addRightButton();

        for (Component component : getComponents()) {
            registLeftKey((JComponent) component);
            registRightKey((JComponent) component);
        }

        validate();

        highLightSelectLabel();
    }

    private void highLightSelectLabel() {
        if (thumbImages.getCurrentSelectedLabel() == null) {
            return;
        }
        List<ImageLabel> thumbs = windowOfListUtil.getSubListInWindow();
        for (ImageLabel label : thumbs) {
            if (label.equals(thumbImages.getCurrentSelectedLabel())) {
                label.setHighLight(true);
            } else {
                label.setHighLight(false);
            }

        }
        updateButtonStatus();
        repaint();
    }

    private class ThumbClick implements ActionListener {
        private final ImageLabel imageLabel;

        public ThumbClick(ImageLabel imageLabel) {
            this.imageLabel = imageLabel;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            thumbImages.setCurrentSelectedLabel(imageLabel);
            newSelection();
        }
    }

    private void newSelection() {
        originalViewPanel.imageChange(thumbImages.getCurrentSelectFile());
        highLightSelectLabel();
    }

    private void thumbViewMoveForward() {
         windowOfListUtil.moveForward();
            updateThumbDisplay();
    }

    private void thumbViewMoveBackward() {
        windowOfListUtil.moveBackward();
            updateThumbDisplay();
    }
}
