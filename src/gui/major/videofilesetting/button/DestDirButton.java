package gui.major.videofilesetting.button;

import config.ConvertLog;
import config.properties.DialogProperties;
import convert.VideoFile;
import gui.major.videofilesetting.ColumnType;
import gui.major.videofilesetting.VFS_VideoFileSetting;
import gui.util.TextUtil;
import gui.util.dialog.FileChooserDialog;
import gui.util.dialog.OptionPaneDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 上午9:25
 */
public class DestDirButton extends A_VFSButton {
    final private VideoFile videoFile;
    private final VFS_VideoFileSetting vfs_videoFileSetting;

    public ColumnType getColumnType() {
        return ColumnType.DEST_DIR;
    }


    private DestDirButton(final VideoFile videoFile, final VFS_VideoFileSetting vfs_videoFileSetting) {
        TextUtil.setTextWithToolTip(this, ConvertLog.instance().getLastDestDir());
        this.vfs_videoFileSetting = vfs_videoFileSetting;
        this.videoFile = videoFile;

        addActionListener(new ChangeDestDirAction());
    }

    public static DestDirButton build(final VideoFile videoFile, final VFS_VideoFileSetting vfs_videoFileSetting) {
        return new DestDirButton(videoFile, vfs_videoFileSetting);
    }

    public VFS_VideoFileSetting getVfs_videoFileSetting() {
        return vfs_videoFileSetting;
    }

    private class ChangeDestDirAction implements ActionListener {

        private ChangeDestDirAction() {
        }

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            File dir = new File(ConvertLog.instance().getLastDestDir());
            FileChooserDialog fc = new FileChooserDialog(dir);
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setMultiSelectionEnabled(false);

            if (fc.showOpenDialog(null) != FileChooserDialog.APPROVE_OPTION) {
                return;
            }
            final File destDir = fc.getSelectedFile();

            if (getVfs_videoFileSetting().getVideoFilesNumber() > 1) {
                final int applayToAll = OptionPaneDialog.showConfirmDialog(
                        null,
                        DialogProperties.Key.ApplyToAll,
                        DialogProperties.Key.ApplyToAll,
                        OptionPaneDialog.YES_NO_OPTION);

                if (applayToAll == OptionPaneDialog.YES_OPTION) {
                    getVfs_videoFileSetting().setDestDirToAll(destDir);
                } else {
                    getVfs_videoFileSetting().setDestDir(videoFile, destDir);
                }
            } else {
                getVfs_videoFileSetting().setDestDir(videoFile, destDir);
            }

            ConvertLog.instance().setLastDestDir(destDir.getPath());
        }
    }
}
