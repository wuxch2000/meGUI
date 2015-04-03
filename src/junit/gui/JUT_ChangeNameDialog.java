package junit.gui;

import convert.*;
import gui.major.videofilesetting.dialog.change_dest_name.*;
import gui.util.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-7
 * Timex: 下午3:28
 */
abstract public class JUT_ChangeNameDialog extends JFrame {

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

//        SizeUtil.sameSize(panel,new Dimension(500,300));

        JButton component = new JButton("ChangeNameDialog");

        component.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                ChangeDestNameDialog dlg = new ChangeDestNameDialog(null,
                    "Modern.Family.S02E07.xvid.avi");
                if (ChangeDestNameDialog.showDialog(dlg) == ChangeDestNameDialog.ReturnValue.OK) {
                    Trace.debug("ChangeNameDialog OK");
                    Trace.debug("JUT_ChangeNameDialog.actionPerformed():",
                        "new Name:", dlg.getText());
                }
                else {
                    Trace.debug("ChangeNameDialog return to :", dlg.getRetValue());
                }
            }
        });

        panel.add(component, BorderLayout.CENTER);

        return panel;
    }


}
