package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarProfile extends A_ProcessTableButton {

	public ToolBarProfile() {
		super("profile_dark.png", "profile_inactive.png","profile_light.png");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        EditProfileAction action = new EditProfileAction();
		action.actionPerformed(arg0);
	}


    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return true;
    }
}
