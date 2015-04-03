package gui.major.videofilesetting.button;

import convert.*;
import gui.*;
import gui.major.videofilesetting.*;
import gui.major.videofilesetting.dialog.change_dest_name.*;
import gui.util.TextUtil;
import log.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-17
 */
public class DestNameButton extends A_VFSButton {
    private final VFS_VideoFileSetting vfs_videoFileSetting;

    public ColumnType getColumnType() {
        return ColumnType.DEST_NAME;
    }

    private DestNameButton(final VideoFile videoFile, final VFS_VideoFileSetting vfs_videoFileSetting) {

        String name;
        if (videoFile.getDestinFile() != null) {
            name = videoFile.getDestinFile().getName();
        } else {
            name = videoFile.guessDestinFileName();
        }
        TextUtil.setTextWithToolTip(this, name);

        this.vfs_videoFileSetting = vfs_videoFileSetting;

        addActionListener(new ChangeDestNameAction());
    }

    public static DestNameButton build(final VideoFile videoFile, final VFS_VideoFileSetting vfs_videoFileSetting) {
        return new DestNameButton(videoFile, vfs_videoFileSetting);
    }

    public VFS_VideoFileSetting getVfs_videoFileSetting() {
        return vfs_videoFileSetting;
    }

    private class ChangeDestNameAction implements ActionListener {


        private ChangeDestNameAction() {
        }

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            String oldName = getText();

            String newName;

            ChangeDestNameDialog dlg = new ChangeDestNameDialog(MainFrame.instance(),
                    oldName);
            if (ChangeDestNameDialog.showDialog(dlg) ==
                    ChangeDestNameDialog.ReturnValue.OK) {
                newName = dlg.getText();
                Trace.debug("DestNameButton$ChangeDestNameAction.actionPerformed():",
                        "get newName:", newName);

                if (!oldName.equalsIgnoreCase(newName)) {
                    TextUtil.setTextWithToolTip(DestNameButton.this, newName);
                }

                if (getVfs_videoFileSetting().getVideoFilesNumber() > 1 &&
                        dlg.getNomalizeAll()) {
                    getVfs_videoFileSetting().setDestNameNormalizeToAll();
                }

            } else {
                Trace.debug("ChangeNameDialog return to :", dlg.getRetValue());
            }
        }
    }

}
