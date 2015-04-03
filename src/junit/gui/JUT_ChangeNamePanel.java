package junit.gui;

import convert.*;
import gui.major.videofilesetting.dialog.change_dest_name.*;
import gui.util.*;
import log.*;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_ChangeNamePanel extends JFrame {

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

        String oldName = "Modern.Family.S02E07.xvid.avi";
        JPanel contentPanel = new ChangeDestNamePanel(
            oldName, null);

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }


}
