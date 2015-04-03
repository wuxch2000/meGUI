package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class StopAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().stopConverting();
    }

    public StopAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.StopConvert));
    }

}
