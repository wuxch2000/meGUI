package junit.gui;

import gui.profile.*;
import gui.util.*;

import javax.swing.*;

public class JUT_PDMainPanel {

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

        return new PDMainPanel(null);
    }
}
