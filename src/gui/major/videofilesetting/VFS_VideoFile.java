package gui.major.videofilesetting;

import convert.VideoFile;
import gui.major.videofilesetting.button.*;
import gui.major.videofilesetting.dialog.change_dest_name.ChangeDestNameUtil;
import gui.util.SizeUtil;
import gui.util.TextUtil;
import gui.util.layout.LayoutUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;


/**
 * User: 吴晓春
 * Date: 11-6-9
 * Time: 上午11:20
 */
public class VFS_VideoFile extends JPanel implements MouseListener {

    private Map<ColumnType, JComponent> videoFileHash;
    private boolean mouseIn = false;

    public VFS_VideoFile(VideoFile videoFile,
                         VFS_VideoFileSetting vfs_videoFileSetting) {

        addMouseListener(this);

        videoFileHash = new Hashtable<ColumnType, JComponent>();

        LayoutUtil.UsingGridBagLayout(this);

        int line = 0, column = 0;

        addColumnComponent(line, column++, GridBagConstraints.LINE_START,
                SourceNameLabel.build(videoFile), ColumnType.SOURCE_FILE);

        addColumnComponent(line, column++, GridBagConstraints.LINE_START,
                DestDirButton.build(videoFile, vfs_videoFileSetting), ColumnType.DEST_DIR);

        addColumnComponent(line, column++, GridBagConstraints.LINE_START,
                DestNameButton.build(videoFile, vfs_videoFileSetting), ColumnType.DEST_NAME);

        addColumnComponent(line, column++, GridBagConstraints.CENTER,
                ProfileComboBox.build(), ColumnType.PROFILE);

        addColumnComponent(line, column++, GridBagConstraints.CENTER,
                ScriptButton.build(videoFile), ColumnType.SCRIPT);

        addColumnComponent(line, column, GridBagConstraints.CENTER,
                TimeRangeButton.build(videoFile), ColumnType.TIME_RANGE);

    }

    private void addColumnComponent(int line, int column, int anchor,
                                    JComponent jComponent, ColumnType columnType
    ) {
        GridBagConstraints c =
                LayoutUtil.buildConstraints(line, column);
        c.anchor = anchor;

        SizeUtil.sameWidth(jComponent, ColumnWidth.getWidth(columnType));
        add(jComponent, c);
        videoFileHash.put(columnType, jComponent);
    }

    void setDestDir(File destDir) {
        DestDirButton destDirButton = (DestDirButton)
                videoFileHash.get(ColumnType.DEST_DIR);
        if (destDirButton != null) {
            TextUtil.setTextWithToolTip(destDirButton, destDir.getPath());
        }
    }

    String getDestDir() {
        JButton button = (JButton) videoFileHash.get(ColumnType.DEST_DIR);
        return button.getText();
    }

    void setDestNameNormalize() {
        JComponent jComponent = videoFileHash.get(ColumnType.DEST_NAME);
        if (jComponent != null) {
            String oldName = ((JButton) jComponent).getText();
            String recommentString = ChangeDestNameUtil.getRecommentString(oldName);
            ((JButton) jComponent).setText(recommentString);
            jComponent.revalidate();
        }
    }

    String getDestName() {
        JButton button = (JButton) videoFileHash.get(ColumnType.DEST_NAME);
        return button.getText();
    }

    ScriptButton getScriptButton() {
        return (ScriptButton) videoFileHash.get(ColumnType.SCRIPT);
    }

    ProfileComboBox getProfileComboBox() {
        return (ProfileComboBox) videoFileHash.get(ColumnType.PROFILE);
    }

    TimeRangeButton getTimeRangeButton() {
        return (TimeRangeButton) videoFileHash.get(ColumnType.TIME_RANGE);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Dimension size = getSize();

        Graphics2D g2 = (Graphics2D) g;

        if (mouseIn) {
            g2.setColor(Color.blue);
            g2.drawRect(0,0,size.width-1,size.height-1);
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseIn = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseIn = false;
        repaint();
    }
}
