package gui.major.videoinfo;

import convert.*;
import gui.major.*;
import gui.major.videoinfo.videodetail.*;
import gui.major.videoinfo.videoimage.thumbview.*;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.*;

import static gui.util.layout.LayoutUtil.*;

/**
 * User: 吴晓春
 * Date: 11-3-2
 * Timex: 下午3:10
 */
public class VideoInfoMainPanel extends JPanel implements I_Update {
    private ThumbViewPanel thumbViewPanel;
    private VideoDetail videoDetail;

    public VideoInfoMainPanel() {
        setOpaque(true);

        LayoutUtil.UsingGridBagLayout(this);

        int line = 0, column = 0;
        final Insets insets = buildInsets(5, 5, 5, 5);
        thumbViewPanel = new ThumbViewPanel();
        GridBagConstraints gridBagConstraints = LayoutUtil.buildConstraints(line, column, insets);
        gridBagConstraints.weightx = 0;
        add(thumbViewPanel, gridBagConstraints);

        column++;
        videoDetail = new VideoDetail();
        final GridBagConstraints gridBagConstraints1 = LayoutUtil.buildConstraints(line, column, insets);
        gridBagConstraints1.weightx = 1;
        add(videoDetail, gridBagConstraints1);

    }


    public void update(VideoFile videoFile) {
        thumbViewPanel.update(videoFile);
        videoDetail.update(videoFile);

    }


}
