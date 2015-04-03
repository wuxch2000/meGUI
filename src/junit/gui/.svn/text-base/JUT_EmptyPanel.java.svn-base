package junit.gui;

import convert.ExecWhenQuit;
import gui.major.table.EmptyPanel;
import gui.util.GuiUtil;
import gui.util.SizeUtil;
import log.Trace;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_EmptyPanel extends JFrame {

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

        JPanel contentPanel = new EmptyPanel();

        SizeUtil.sameSize(contentPanel, 400, 300);

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }


}
