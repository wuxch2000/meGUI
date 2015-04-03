package gui.major.videofilesetting;

import config.properties.DialogProperties;
import config.properties.VideoFileFieldProperties;
import convert.VideoFile;
import gui.MainPanel;
import gui.major.videofilesetting.button.ProfileComboBox;
import gui.major.videofilesetting.button.ScriptButton;
import gui.major.videofilesetting.button.TimeRangeButton;
import gui.util.FileUtil;
import gui.util.dialog.OptionPaneDialog;
import gui.util.layout.LayoutUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 下午3:38
 */
public class VFS_VideoFileSetting extends JPanel {

    final private VideoFile[] videoFiles;

    public int getVideoFilesNumber() {
        return videoFiles.length;
    }

    private final VFS_MainPanel vfs_mainPanel;

    public VFS_MainPanel getVfs_mainPanel() {
        return vfs_mainPanel;
    }

    private Map<VideoFile, VFS_VideoFile> map_vfs_videoFile;

    public VFS_VideoFileSetting(VFS_MainPanel vfs_mainPanel,
                                VideoFile[] videoFiles) {

        this.videoFiles = videoFiles;
        this.vfs_mainPanel = vfs_mainPanel;

        map_vfs_videoFile = new HashMap<>();

        LayoutUtil.UsingGridBagLayout(this);

        int line = 0, column = 0;
        GridBagConstraints c;

        c = LayoutUtil.buildConstraints(line, column);
        VFS_Title vfs_title = new VFS_Title();

        add(vfs_title, c);


        line++;
        for (VideoFile videoFile : videoFiles) {

            VFS_VideoFile vfs_videoFile = new VFS_VideoFile(videoFile, this);
            map_vfs_videoFile.put(videoFile, vfs_videoFile);
            c = LayoutUtil.buildConstraints(line, column);
            add(vfs_videoFile, c);

            line++;
        }

    }

    public void setDestDir(VideoFile videoFile, File destDir) {
        map_vfs_videoFile.get(videoFile).setDestDir(destDir);
    }

    public void setDestDirToAll(File destDir) {
        for (Map.Entry<VideoFile, VFS_VideoFile> entry : map_vfs_videoFile.entrySet()) {
            setDestDir(entry.getKey(), destDir);
        }
    }

    private String getDestDir(VideoFile videoFile) {
        return map_vfs_videoFile.get(videoFile).getDestDir();
    }


    public void setDestNameNormalize(VideoFile videoFile) {
        map_vfs_videoFile.get(videoFile).setDestNameNormalize();
    }

    public void setDestNameNormalizeToAll() {
        for (Map.Entry<VideoFile, VFS_VideoFile> entry : map_vfs_videoFile.entrySet()) {
            setDestNameNormalize(entry.getKey());
        }
    }

    private String getDestName(VideoFile videoFile) {
        return map_vfs_videoFile.get(videoFile).getDestName();
    }

    private ScriptButton getScriptButton(VideoFile videoFile) {
        return map_vfs_videoFile.get(videoFile).getScriptButton();
    }

    private ProfileComboBox getProfileComboBox(VideoFile videoFile) {
        return map_vfs_videoFile.get(videoFile).getProfileComboBox();
    }

    private TimeRangeButton getTimeRangeButton(VideoFile videoFile) {
        return map_vfs_videoFile.get(videoFile).getTimeRangeButton();
    }


    public boolean updateVideoFileSetting() {
        for (Map.Entry<VideoFile, VFS_VideoFile> entry : map_vfs_videoFile.entrySet()) {
            VideoFile videoFile = entry.getKey();

            String newDestFileName = getDestDir(videoFile) + FileUtil.sep +
                    getDestName(videoFile);
            if (MainPanel.instance().getMajorPanel() != null) {
                if (MainPanel.instance().getMajorPanel().isDuplicateDestFileName(newDestFileName)) {

                    if (OptionPaneDialog.showOptionDialogOkCancel(
                            null,
                            VideoFileFieldProperties.Key.DupFile,
                            DialogProperties.Key.Warning,
                            OptionPaneDialog.YES_NO_OPTION,
                            OptionPaneDialog.WARNING_MESSAGE,
                            null)
                            == OptionPaneDialog.NO_OPTION) {
                        return false;
                    }

                }
            }

            videoFile.setDestinFile(new File(newDestFileName));

            videoFile.setScriptFile(getScriptButton(videoFile).getScriptFile());

            videoFile.setEncodeProfile(getProfileComboBox(videoFile).getSelectProfile());

            videoFile.setVideoRange(getTimeRangeButton(videoFile).getVideoRange());
        }
        return true;
    }

    public void pack() {
        if (getVfs_mainPanel() != null &&
                getVfs_mainPanel().getDlg() != null) {
            getVfs_mainPanel().getDlg().pack();
        }
    }

}
