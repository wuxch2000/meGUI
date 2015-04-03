package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UpAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().upVideoFile();
    }

    public UpAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.Up));
    }

}
