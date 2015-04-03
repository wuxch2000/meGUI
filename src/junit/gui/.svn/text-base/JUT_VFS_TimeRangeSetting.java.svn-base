package junit.gui;

import convert.*;
import gui.major.videofilesetting.timerange.*;
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
abstract public class JUT_VFS_TimeRangeSetting extends JFrame {

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

        VideoFile videoFile = StubVideoFile.build(VIDEO_FILE);
        videoFile.initVideoFile();

        TimeRangePanel contentPanel =
            new TimeRangePanel(null,videoFile.getSourceFile().getName(),
                videoFile.getVideoRange());

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }


}
