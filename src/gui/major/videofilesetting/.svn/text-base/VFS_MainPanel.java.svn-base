package gui.major.videofilesetting;

import config.*;
import config.properties.*;
import convert.*;
import gui.util.*;
import gui.util.font.FontUtil;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 下午2:52
 */
public class VFS_MainPanel extends JPanel {

    private VFS_VideoFileSetting videoFileSetting;
    private VFS_MainDlg dlg;

    public VFS_MainDlg getDlg() {
        return dlg;
    }

    public VFS_MainPanel(VFS_MainDlg dlg, VideoFile[] videoFiles) {

        this.dlg = dlg;

        LayoutUtil.UsingGridBagLayout(this);

        int line = 0, column = 0;
        final int MAX_COLUMN = 4;
        GridBagConstraints c;

        videoFileSetting = new VFS_VideoFileSetting(this, videoFiles);
        c = LayoutUtil.buildConstraints(line, column);
        c.gridwidth = MAX_COLUMN;
        add(videoFileSetting, c);

        final JButton buttonOK = new JButton(
                DialogProperties.instance().getString(DialogProperties.Key.OK));
        FontUtil.setLocalFont(buttonOK);
        buttonOK.addActionListener(new okAction());
        line++;
        column = MAX_COLUMN-1;
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.EAST;
        add(buttonOK, c);

        BorderUtil.addSpaceBorder(this);

    }

    private class okAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (!videoFileSetting.updateVideoFileSetting()) {
                return;
            }

            if (dlg != null) {
                dlg.setRetValue(VFS_MainDlg.ReturnValue.OK);
                dlg.setVisible(false);
            }
        }
    }

}
