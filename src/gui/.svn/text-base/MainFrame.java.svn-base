package gui;

import config.ConvertLog;
import convert.ExecWhenQuit;
import gui.menu.MainMenuBar;
import gui.tutorial.TutorialDlg;
import gui.util.ImageUtil;
import gui.util.LocationUtil;
import gui.util.SizeUtil;
import gui.util.dialog.ModuleDialog;
import gui.util.monitor.GuiMonitor;
import log.Trace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements WindowListener {

    public MainPanel getPanel() {
        return panel;
    }

    private final MainPanel panel;

    static private MainFrame mainFrame = null;
    final static private String frameTitle = "meGUI";

    static public MainFrame instance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame(frameTitle);
            GuiMonitor.useGuiMonitor(mainFrame);
        }
        return mainFrame;
    }

    final static private double screenFactor = .8;

    public MainFrame(String arg0) throws HeadlessException {
        super(arg0);
        SizeUtil.setSize(this, screenFactor);
        LocationUtil.setCenterOfScreen(this);
        addWindowListener(this);

        panel = MainPanel.initial();

        add(panel);

        setJMenuBar(new MainMenuBar());

        ArrayList<Image> icons = new ArrayList<>();
        icons.add(ImageUtil.createImage("main_icon.16.png"));
        icons.add(ImageUtil.createImage("main_icon.32.png"));
        icons.add(ImageUtil.createImage("main_icon.48.png"));
        icons.add(ImageUtil.createImage("main_icon.64.png"));
        icons.add(ImageUtil.createImage("main_icon.128.png"));

        setIconImages(icons);

//        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);


    }

    private void popTutorial() {
        final boolean showtutorailOnStartUp = ConvertLog.instance().getShowtutorailOnStartUp();
        if (!showtutorailOnStartUp) {
            return;
        }

        ModuleDialog dlg = TutorialDlg.build(this);
        ModuleDialog.showDialog(dlg);

    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent arg0) {

    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        Trace.debug("Windows closing...");
        new ExecWhenQuit().run();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {

    }

    @Override
    public void windowIconified(WindowEvent arg0) {

    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        popTutorial();
    }

}
