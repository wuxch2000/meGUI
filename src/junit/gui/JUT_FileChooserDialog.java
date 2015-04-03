package junit.gui;

import gui.util.GuiUtil;
import gui.util.SizeUtil;
import gui.util.dialog.FileChooserDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JUT_FileChooserDialog {

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

    private static void pop() {
        FileChooserDialog fc = new FileChooserDialog("d:\\Download");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setMultiSelectionEnabled(false);

        if (fc.showOpenDialog(null) != FileChooserDialog.APPROVE_OPTION) {
        }
    }

    private static JComponent initFramePanel() {
        JPanel mainPanel = new JPanel(new FlowLayout());
        SizeUtil.sameSize(mainPanel, new Dimension(400, 300));

        JButton pop = new JButton("pop");
        mainPanel.add(pop);

        pop.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                pop();
            }
        });

        return mainPanel;
    }
}
