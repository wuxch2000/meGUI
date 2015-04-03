package junit.gui.profile;

import gui.profile.right.audio.others.*;
import gui.util.*;

import javax.swing.*;

public class JUT_AudioOthers {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiUtil.createAndShowGUI("", initFramePanel());
            }
        });
    }

    private static JComponent initFramePanel() {

        return new CfgAudioOthers().getGUI();

    }
}

