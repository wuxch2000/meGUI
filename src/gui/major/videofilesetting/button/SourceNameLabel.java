package gui.major.videofilesetting.button;

import convert.*;
import gui.major.videofilesetting.*;
import gui.util.TextUtil;
import gui.util.font.FontUtil;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-3-16
 * Timex: 下午4:01
 */
public class SourceNameLabel extends JLabel implements GetColumnType {

    private SourceNameLabel(final VideoFile videoFile) {
        super(videoFile.getSourceFile().getName());
        TextUtil.setTextWithToolTip(this, videoFile.getSourceFile().getPath());
        addMouseListener(new MouseAction(this));
        FontUtil.setLocalFont(this);
    }

    public static SourceNameLabel build(final VideoFile videoFile) {
        return new SourceNameLabel(videoFile);
    }

    public ColumnType getColumnType() {
        return ColumnType.SOURCE_FILE;
    }

}
