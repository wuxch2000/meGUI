package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarBrowseLog extends A_ProcessTableButton {

	public ToolBarBrowseLog() {
		super("browseLog-dark.png", "browseLog-inactive.png","browseLog-light.png");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        BrowseLogAction action = new BrowseLogAction();
		action.actionPerformed(arg0);
	}


    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return true;
    }
}
