package junit.gui;

import convert.*;
import convert.util.*;
import gui.major.table.*;
import gui.util.*;
import gui.util.command.*;
import junit.stub.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_ProcessTable extends JFrame {

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

        SizeUtil.sameSize(panel, new Dimension(600, 300));

        final TablePanel tablePanel = new TablePanel(null);
        panel.add(tablePanel, BorderLayout.CENTER);


        final StubVideoFile videoFile = StubVideoFile.build(null);
        videoFile.setSOURCE_FILE(new File("a.avi"));
        final VideoConvert convert = StubVideoConvert.build(videoFile);
        videoFile.initVideoFile();

        final StubVideoFile videoFile1 = StubVideoFile.build(null);
        videoFile1.setSOURCE_FILE(new File("b.avi"));
//        final VideoConvert convert1 = StubVideoConvert.build(videoFile1);
        videoFile1.initVideoFile();

        final StubVideoFile videoFile2 = StubVideoFile.build(null);
        videoFile2.setSOURCE_FILE(new File("c.avi"));
        videoFile2.initVideoFile();


        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton buttonAdd = new JButton("Add");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.addVideoFile(videoFile);
                tablePanel.addVideoFile(videoFile1);
                tablePanel.addVideoFile(videoFile2);
            }
        });
        buttonPanel.add(buttonAdd);

        JButton buttonConvert = new JButton("Convert");
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {

                convert.setProgressNotify(tablePanel.getProgressBarNofify());
//                convert.exec();
            }
        });
        buttonPanel.add(buttonConvert);

        JButton buttonStop = new JButton("Stop");
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
//                convert.stop();
            }
        });
        buttonPanel.add(buttonStop);

        JButton buttonWaiting = new JButton("Waiting");
        buttonWaiting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                videoFile.setStatus(Status.WAITING);
                tablePanel.updateStatus(videoFile);
            }
        });
//        buttonWaiting.setIcon(ImageUtil.createImageIcon("waiting.gif"));
//        JButton t = new JButton(ImageUtil.createImageIcon("waiting.gif"));
        buttonPanel.add(buttonWaiting);
//        buttonPanel.add(t);

        JButton buttonRunning = new JButton("Running");
        buttonRunning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                videoFile.setStatus(Status.RUNNING);
                tablePanel.updateStatus(videoFile);
            }
        });
        buttonPanel.add(buttonRunning);

        JButton buttonRemove = new JButton("Remove");
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                tablePanel.removeVideoFile();
            }
        });
        buttonPanel.add(buttonRemove);

        JButton buttonUp = new JButton("Up");
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                tablePanel.upVideoFile();
            }
        });
        buttonPanel.add(buttonUp);

        JButton buttonDown = new JButton("Down");
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                tablePanel.downVideoFile();
            }
        });
        buttonPanel.add(buttonDown);

        panel.add(buttonPanel, BorderLayout.SOUTH);


        return panel;
    }


}
