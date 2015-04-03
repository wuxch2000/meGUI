package gui.major.videoinfo.videodetail;

import convert.*;
import gui.major.*;
import gui.major.videoinfo.videodetail.items.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 上午10:40
 */
public class VideoDetail extends JPanel implements I_Update {
    private ArrayList<A_Detail> details;

    public VideoDetail() {
        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);

        details = new ArrayList<A_Detail>();

        details.add(new Detail_Name());
        details.add(new Detail_Length());
        details.add(new Detail_Format());
        details.add(new Detail_Fps());
        details.add(new Detail_Width());
        details.add(new Detail_Height());
        details.add(new Detail_AudioCodec());
        details.add(new Detail_AudioBitrate());
        details.add(new Detail_AudioChannel());
        details.add(new Detail_VideoCodec());
        details.add(new Detail_VideoBitrate());

        addAllDetail();
    }

    private void addAllDetail() {
        for (A_Detail detail : details) {
            add(detail, detail.getGridBagConstraints());
        }
    }

    @Override
    public void update(final VideoFile videoFile) {
        for (A_Detail detail : details) {
            A_Detail.update(detail, videoFile);
        }
        invalidate();
    }
}
