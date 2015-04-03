package gui.major.videoinfo.videoimage.thumbview;

import config.properties.*;
import gui.major.videoinfo.videoimage.originalview.*;
import gui.util.*;
import gui.util.button.*;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static gui.util.layout.LayoutUtil.*;

/**
 * User: 吴晓春
 * Date: 11-3-3
 * Timex: 下午2:33
 */
public class ImageControlPanel extends JPanel {

    private JButton leftButton;
    private JButton rightButton;
    private JButton pop1xButton;

    private JLabel infoLabel;

    private int min_index;
    private int max_index;
    private ThumbViewPanel thumbViewPanel;

    private int current_index;

    public ImageControlPanel(ThumbViewPanel thumbViewPanel) {
        super();
        this.thumbViewPanel = thumbViewPanel;

        LayoutUtil.UsingGridBagLayout(this);

        pop1xButton = ImageButton.build(
            ImageUtil.createImage("button.1x.light.png"),
            ImageUtil.createImage("button.1x.dark.png"),
            ImageUtil.createImage("button.1x.light.png"));
        pop1xButton.addActionListener(new Pop1x());
        pop1xButton.setEnabled(true);

        leftButton = ImageButton.build(
            ImageUtil.createImage("left_light.png"),
            ImageUtil.createImage("left_dark.png"),
            ImageUtil.createImage("left_inactive.png"));
        leftButton.addActionListener(new Left());
        leftButton.setEnabled(false);

        rightButton = ImageButton.build(
            ImageUtil.createImage("right_light.png"),
            ImageUtil.createImage("right_dark.png"),
            ImageUtil.createImage("right_inactive.png"));
        rightButton.addActionListener(new Right());
        rightButton.setEnabled(false);

        infoLabel = new JLabel();
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoLabel.setHorizontalAlignment(JLabel.CENTER);
        Dimension labelSize = new Dimension((int) (leftButton.getSize().width * 1.5),
            leftButton.getSize().height);
        SizeUtil.sameSize(infoLabel, labelSize);
        infoLabel.setFont(new Font("sansserif", Font.ITALIC, 16));

        final Insets insets = buildInsets(5, 5, 5, 5);

        int line = 0, column = 0;
        add(pop1xButton, buildConstraints(line, column, insets));
        column++;
        add(leftButton, buildConstraints(line, column, insets));
        column++;
        add(infoLabel, buildConstraints(line, column, insets));
        column++;
        add(rightButton, buildConstraints(line, column, insets));

    }

    public void setIndexRange(int min, int max) {
        min_index = min;
        max_index = max;
        current_index = min;
        indexChange();
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
    }

    public void setDisable() {
        infoLabel.setText(VideoFileFieldProperties.instance().getString(
            VideoFileFieldProperties.Key.NO_SELECTION));
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);
        Dimension size = this.getSize();

        Graphics2D g2 = (Graphics2D) graphics;

        g2.setPaint(GradUtil.buildGrad(this));

        g2.fill(new Rectangle(size));

    }

    private class Left implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (current_index == min_index) {
                return;
            }
            current_index--;
            indexChange();
        }
    }

    public void setButtonEnable() {
        if (current_index == min_index) {
            leftButton.setEnabled(false);
            rightButton.setEnabled(true);
            return;
        }
        if (current_index == max_index) {
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
            return;
        }
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        pop1xButton.setEnabled(true);
    }

    private class Right implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (current_index == max_index) {
                return;
            }
            current_index++;
            indexChange();
        }
    }

    private class Pop1x implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            OriginalViewDialog originalViewDialog = new OriginalViewDialog();
            originalViewDialog.update(thumbViewPanel.getVideoFile());
            originalViewDialog.setVisible(true);
        }
    }

    private void indexChange() {
        infoLabel.setText(String.format("%d/%d", current_index + 1, max_index + 1));
        setButtonEnable();
        thumbViewPanel.imageChange(current_index);
        leftButton.repaint();
        rightButton.repaint();
    }
}
