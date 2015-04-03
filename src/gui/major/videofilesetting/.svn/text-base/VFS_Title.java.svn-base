package gui.major.videofilesetting;

import gui.util.SizeUtil;
import gui.util.font.FontUtil;
import gui.util.layout.LayoutUtil;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-6-9
 */
public class VFS_Title extends JPanel {
    public VFS_Title() {
        LayoutUtil.UsingGridBagLayout(this);

        addTitle();
    }

    private void addTitle() {
        int column = 0;
        addTitle(ColumnType.SOURCE_FILE, column++);
        addTitle(ColumnType.DEST_DIR, column++);
        addTitle(ColumnType.DEST_NAME, column++);
        addTitle(ColumnType.PROFILE, column++);
        addTitle(ColumnType.SCRIPT, column++);
        addTitle(ColumnType.TIME_RANGE, column);

    }

    private void addTitle(ColumnType columnType, int column) {
        int line = 0;
        JComponent jComponent = buildTitle(columnType);
        SizeUtil.sameWidth(jComponent,ColumnWidth.getWidth(columnType));
        GridBagConstraints c = LayoutUtil.buildConstraints(line, column);
        add(jComponent, c);
    }

    private JComponent buildTitle(ColumnType columnType) {
        JLabel label = new JLabel(columnType.toString());

        FontUtil.setLocalFont(label);
        FontUtil.enlargeFont(label,1);

        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

}
