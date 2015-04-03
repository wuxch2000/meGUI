package junit.gui;

import gui.util.*;
import gui.util.monitor.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JUT_ProgressDialog {

   public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiUtil.createAndShowGUI("",initFramePanel());
            }
        });
    }

    private static void pop() {
        ProgressDialog progressDialog = new ProgressDialog(null);
        progressDialog.setPrompt("测试");
        progressDialog.setProgress(10);
    }

    private static JComponent initFramePanel() {
        JPanel mainPanel = new JPanel(new FlowLayout());
        SizeUtil.sameSize(mainPanel,new Dimension(400,300));

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
