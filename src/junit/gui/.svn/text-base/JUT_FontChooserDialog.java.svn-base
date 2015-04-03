package junit.gui;

import config.properties.*;
import convert.*;
import gui.swingworker.*;
import gui.util.*;
import gui.util.monitor.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_FontChooserDialog extends JFrame {

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

        Monitor.useGuiMonitor(GuiUtil.frame);

        JPanel panel = new JPanel(new BorderLayout());

        JButton component = new JButton("FontChooserDialog");

        component.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {

                Monitor.instance().setBegin(
                    DialogProperties.instance().
                        getString(DialogProperties.Key.InitialingFontChooserDialog));

                SwingWorkerGui worker =
                    new SwingWorkerGui(new DoShowFontChooserDialog(null, "微软雅黑", null));
                worker.execute();
            }
        });

        panel.add(component, BorderLayout.CENTER);

        return panel;
    }


}
