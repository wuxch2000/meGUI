package gui.tutorial;

import config.properties.DialogProperties;
import config.properties.VideoFileFieldProperties;
import gui.MainFrame;
import gui.major.videofilesetting.VFS_MainPanel;
import gui.util.dialog.ModuleDialog;

import javax.swing.*;
import java.awt.*;

import static config.properties.VideoFileFieldProperties.Key.ConvertOptionsSetting;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午2:03
 */
public class TutorialDlg extends ModuleDialog {
    private TutorialDlg(Frame frame) {

        super(MainFrame.instance(),
                DialogProperties.instance().getString(DialogProperties.Key.Tutorial));

        setContentPane(new TutorialPanel(this));

        pack();
    }

    public static TutorialDlg build(Frame frame) {
        return new TutorialDlg(frame);
    }
}
