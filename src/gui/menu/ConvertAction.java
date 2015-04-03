package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ConvertAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().convertVideoFile();
    }

    public ConvertAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.Convert));
    }

}
