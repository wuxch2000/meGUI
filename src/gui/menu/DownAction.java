package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DownAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().downVideoFile();
    }

    public DownAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.Down));
    }

}
