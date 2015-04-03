package junit.gui.tutorial;

import convert.ExecWhenQuit;
import gui.tutorial.TutorialPanel;
import gui.util.GuiUtil;
import log.Trace;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_TutorialPanel extends JFrame {

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

        JPanel contentPanel = new TutorialPanel(null);

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }


}
