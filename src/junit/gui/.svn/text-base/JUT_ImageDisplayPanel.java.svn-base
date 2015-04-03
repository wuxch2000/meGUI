package junit.gui;

import gui.major.videoinfo.videoimage.thumbview.*;
import gui.util.*;

import javax.swing.*;
import java.io.*;

public class JUT_ImageDisplayPanel {

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
        ImageThumbDispalyPanel panel = new ImageThumbDispalyPanel();
        panel.setImage(
            ImageUtil.loadImage(
                new File("D:\\JavaCode\\meGUI\\examples\\00000007.jpg")));

        return panel;
    }

}
