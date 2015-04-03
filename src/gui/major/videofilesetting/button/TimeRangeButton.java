package gui.major.videofilesetting.button;

import config.*;
import convert.*;
import gui.*;
import gui.major.videofilesetting.*;
import gui.major.videofilesetting.timerange.*;
import gui.util.TextUtil;
import gui.util.dialog.*;
import gui.util.time.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 上午11:35
 */
public class TimeRangeButton extends A_VFSButton{
    final private VideoFile videoFile;

    public  ColumnType getColumnType() {
        return ColumnType.TIME_RANGE;
    }

    public VideoRange getVideoRange() {
        return videoRange;
    }

    private VideoRange videoRange;

    private TimeRangeButton(final VideoFile videoFile
                            ) {
        TextUtil.setTextWithToolTip(this, videoFile.getVideoRange().toString());
        this.videoFile = videoFile;
//        VFS_VideoFileSetting vfs_videoFileSetting1 = vfs_videoFileSetting;
        videoRange = videoFile.getVideoRange();

        addActionListener(new ChangeTimeRangeAction());
    }

    public static TimeRangeButton build(final VideoFile videoFile) {
        return new TimeRangeButton(videoFile);
    }

    private class ChangeTimeRangeAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            TimeRangeDialog dialog;
            dialog = new TimeRangeDialog(MainFrame.instance(),
                videoFile.getSourceFile().getName(),
                videoRange);
            if (ModuleDialog.showDialog(dialog) == ModuleDialog.ReturnValue.OK) {
                videoRange = dialog.getVideoRange();
                TextUtil.setTextWithToolTip(TimeRangeButton.this,videoRange.toString() );
            }
        }
    }

}
