package junit.gui;

import convert.*;
import convert.util.*;
import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_ConvertProgressBar extends JFrame {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiUtil.createAndShowGUI("", initFramePanel(),new ExecWhenQuit());
            }
        });
    }


    private static JComponent initFramePanel() {


        final File VIDEO_FILE =
            new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi");

        VideoFile videoFile = VideoFile.build(VIDEO_FILE);
        final VideoConvert convert = VideoConvert.build(videoFile);
        videoFile.initVideoFile();

        final JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JButton buttonConvert = new JButton("Convert");
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {

                convert.setProgressNotify((I_Progress) progressBar);
                convert.exec();
            }
        });

        JButton buttonStop = new JButton("Stop");
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                convert.stop();
            }
        });


        JPanel panel = new JPanel(new BorderLayout());

        panel.add(progressBar, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonConvert);
        buttonPanel.add(buttonStop);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


}
