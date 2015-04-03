package junit.gui;

import gui.major.videoinfo.videoimage.thumbview.*;
import gui.util.*;

import javax.swing.*;
import java.io.*;

public class JUT_ThumbViewPanel {


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

        ThumbViewPanel panel = new ThumbViewPanel();
        File[] imageFiles = FileUtil.getFilesByExt(
            new File("D:\\JavaCode\\meGUI\\examples"), "jpg");
        panel.setImages(imageFiles);

        return panel;

    }
}
