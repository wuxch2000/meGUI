package gui.major.videofilesetting.timerange;

import gui.util.dialog.*;
import gui.util.time.*;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 下午2:06
 */
public class TimeRangeDialog extends ModuleDialog{
    private static final String TITLE = "Time Range Setting";

    public VideoRange getVideoRange() {
        return videoRange;
    }

    public void setVideoRange(final VideoRange videoRange) {
        this.videoRange = videoRange;
    }

    private VideoRange videoRange = null;

    public TimeRangeDialog(Frame frame, String fileName, VideoRange videoRange) {
        super(frame, TITLE);
        JPanel mainPanel = new TimeRangePanel(this,fileName,videoRange);

        this.videoRange = videoRange;

        this.setContentPane(mainPanel);

        this.pack();
    }
}
