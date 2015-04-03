package gui.menu;

import config.properties.*;
import gui.profile.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EditProfileAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ProfileDialog dlg = new ProfileDialog();
		dlg.setVisible(true);
	}

	public EditProfileAction() {
		super(DialogProperties.instance().getString(DialogProperties.Key.EditProfile));
	}

}
