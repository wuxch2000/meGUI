package gui.major.videoinfo.videodetail.items;

import convert.*;
import convert.util.*;
import gui.major.videoinfo.videodetail.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午4:28
 */
public class Detail_VideoCodec extends A_Detail {

    private static final String TITLE = "Video Codec";

    public Detail_VideoCodec() {
        super(TITLE);
    }

    protected void buildGridBagConstraints() {
        gridBagConstraints = GridBagConstraintBuilder.instance().build(this);
    }

    @Override
    public void update(final VideoFile videoFile) {
        VideoFileInfor info = videoFile.getInfo();
        setContentText(info.getItemStringValue(VideoFileInfor.VIDEO_CODEC));
    }
}
