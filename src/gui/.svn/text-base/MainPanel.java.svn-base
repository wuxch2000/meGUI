package gui;

import gui.major.MajorPanel;
import gui.toolbar.MainToolBar;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.PAGE_START;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

    public MainToolBar getToolBar() {
        return toolBar;
    }

    private MainToolBar toolBar;

    public MajorPanel getMajorPanel() {
        return majorPanel;
    }

    private MajorPanel majorPanel;

    private MainPanel() {
        LayoutManager layoutManager = new BorderLayout();
        setLayout(layoutManager);

        toolBar = new MainToolBar();
        add(toolBar, PAGE_START);

        majorPanel = new MajorPanel();
        add(majorPanel.getGUI(), CENTER);

        majorPanel.getTablePanel().setToolbar(toolBar);

        setOpaque(true);

    }

    static private MainPanel mainPanel = null;

    public static MainPanel initial() {
        mainPanel = new MainPanel();
        return mainPanel;
    }


    public static MainPanel instance() {
        return mainPanel;
    }


}
