package gui.menu;

import config.properties.*;
import gui.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EditConvertAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().
            getTablePanel().changeVideoFileSetting();
	}

	public EditConvertAction() {
		super(DialogProperties.instance().getString(DialogProperties.Key.editConvertOption));
	}

}
