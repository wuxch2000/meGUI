package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RemoveAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().removeVideoFile();
    }

    public RemoveAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.Remove));
    }

}
