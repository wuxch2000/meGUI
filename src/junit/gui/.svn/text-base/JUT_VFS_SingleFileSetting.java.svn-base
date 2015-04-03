package junit.gui;

import convert.*;
import gui.major.videofilesetting.*;
import gui.util.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_VFS_SingleFileSetting extends JFrame {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    GuiUtil.createAndShowGUI("", initFramePanel(), new ExecWhenQuit());
                }
            });
        } catch (Exception e) {
            Trace.debug(e);
        }
    }


    private static JComponent initFramePanel() {

        JPanel panel = new JPanel(new BorderLayout());

//        SizeUtil.sameSize(panel,new Dimension(500,300));

        final File VIDEO_FILE =
            new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi");

        final VideoFile videoFile = VideoFile.build(VIDEO_FILE);
        videoFile.initVideoFile();
        final VideoFile videoFile1 = VideoFile.build(VIDEO_FILE);
        videoFile1.initVideoFile();

        VFS_VideoFileSetting vfs_singleFileSetting =
            new VFS_VideoFileSetting(null,new VideoFile[] {videoFile,videoFile1});

        panel.add(vfs_singleFileSetting, BorderLayout.CENTER);

        return panel;
    }


}
