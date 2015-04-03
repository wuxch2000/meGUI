package junit.gui;

import gui.util.*;
import gui.util.monitor.*;

import javax.swing.*;

public class JUT_ProgressPanel {

    private static ProgressPanel mainPanel;

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                GuiUtil.createAndShowGUI("", initFramePanel());
                mainPanel.setPrompt("测试");
//                mainPanel.setProgress(10);
            }
        });
    }

    private static JComponent initFramePanel() {
        mainPanel = new ProgressPanel(GuiUtil.frame);


        return mainPanel;
    }
}
