package junit.gui;

import gui.util.*;
import gui.util.time.spinner.*;
import log.*;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_VFS_TimeSpinner extends JFrame {

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    GuiUtil.createAndShowGUI("", initFramePanel());
                }
            });
        } catch (Exception e) {
            Trace.debug(e);
        }
    }


    private static JComponent initFramePanel() {

        JPanel panel = new JPanel(new BorderLayout());

        TimexSpinner comp = TimexSpinner.build(23, 10, 50);

        panel.add(comp, BorderLayout.CENTER);

        return panel;
    }

}
