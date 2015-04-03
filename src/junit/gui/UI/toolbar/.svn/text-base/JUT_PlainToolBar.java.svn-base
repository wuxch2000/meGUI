package junit.gui.UI.toolbar;

import gui.util.*;
import gui.util.lookfeel.*;
import xml.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JUT_PlainToolBar {

    final private static String TITLE = "JUT_ToolBar";
    private static JTextArea textArea;
    private static JToolBar toolBar;

    public static void main(String[] args) throws Exception {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LookFeelUtil.setLookAndFell(LookFeelUtil.LF_TYPE.Windows);
                GuiUtil.createAndShowGUI(TITLE, initFramePanel());
            }
        });
    }

    private static void setToolbar(JComponent container) {

        ToolBarButtonAdd  buttonTest = new ToolBarButtonAdd();
        JUT_PlainToolBar.toolBar = new JToolBar();
        JUT_PlainToolBar.toolBar.add(buttonTest);



        buttonTest.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                outputString("buttonTest is clicked");
            }
        });

        container.add(JUT_PlainToolBar.toolBar, BorderLayout.PAGE_START);

    }

    public static void toolbarRepaint() {
        toolBar.repaint();
    }

    private static JComponent initFramePanel() {
        final JPanel mainPanel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);

        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        SizeUtil.sameSize(mainPanel, 400, 250);
        setToolbar(mainPanel);
        return mainPanel;
    }

    public static void outputString(String string) {
        textArea.append(string + StringUtil.NEW_LINE);
    }
}
