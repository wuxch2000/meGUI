package junit.gui;

import convert.*;
import gui.major.videofilesetting.*;
import gui.util.*;
import junit.stub.StubVideoFile;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_VFS_MainPanel extends JFrame {

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

        final VideoFile videoFile = StubVideoFile.build(VIDEO_FILE);
        final VideoFile videoFile1 = StubVideoFile.build(VIDEO_FILE);

        VFS_MainPanel vfs_panel =
            new VFS_MainPanel(null,new VideoFile[] {videoFile,videoFile1});

        panel.add(vfs_panel, BorderLayout.CENTER);

        return panel;
    }


}
