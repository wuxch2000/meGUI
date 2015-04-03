package gui.util.monitor;

import config.properties.*;
import gui.util.*;

import javax.swing.*;
import java.awt.event.*;

public class ProgressDialog implements WindowListener {
    private ProgressPanel progressPanel;

    public void setCancel(SupportCancel cancel) {
        progressPanel.setCancel(cancel);
    }

    public ProgressDialog(JFrame frame) {
        super();

        String title = DialogProperties.instance().getString(DialogProperties.Key.Progress);
        final JDialog dialog = new JDialog(frame, title, false);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(),
            BoxLayout.PAGE_AXIS));

        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dialog.addWindowListener(this);
//        dialog.setSize(400, 140);
//        dialog.setLocationRelativeTo(frame);
//        dialog.setLocationRelativeTo(null);
        progressPanel = new ProgressPanel(dialog);
        dialog.setContentPane(progressPanel);

        dialog.pack();
        LocationUtil.setCenterOfScreen(dialog);

    }

    public void setPrompt(String str) {
        progressPanel.setPrompt(str);
    }

    public void setProgress(int progress) {
        progressPanel.setProgress(progress);
    }

    public void close() {
        progressPanel.close();
    }
    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent arg0) {
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        progressPanel.cancel();
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

    }
}
