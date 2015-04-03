package gui.major.videofilesetting;

import config.properties.*;
import convert.*;
import gui.*;
import gui.util.dialog.*;

import javax.swing.*;

import static config.properties.VideoFileFieldProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 下午2:50
 */
public class VFS_MainDlg extends ModuleDialog {
    private VFS_MainPanel mainPanel;

    public VFS_MainDlg(VideoFile[] videoFiles) {
        super(MainFrame.instance(), VideoFileFieldProperties.instance().getString(ConvertOptionsSetting));

        mainPanel = new VFS_MainPanel(this, videoFiles);

        setContentPane(new JScrollPane(mainPanel));

        pack();
    }
}
