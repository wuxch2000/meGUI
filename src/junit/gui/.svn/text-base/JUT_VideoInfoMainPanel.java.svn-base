package junit.gui;

import convert.*;
import gui.major.videoinfo.*;
import gui.util.*;

import javax.swing.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_VideoInfoMainPanel extends JFrame {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiUtil.createAndShowGUI("",initFramePanel());
            }
        });
    }

    private static JComponent initFramePanel() {

        VideoFile videoFile = VideoFile.build(
            new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi"));
        videoFile.initVideoFile();
        VideoInfoMainPanel panel = new VideoInfoMainPanel();

        panel.update(videoFile);
        return panel;
    }


}
