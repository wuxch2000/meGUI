package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarAdd extends A_ProcessTableButton {

	public ToolBarAdd() {
		super("open_dark.png", "open_inactive.png","open_light.png");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        AbstractAction action = new AddAction();
        action.actionPerformed(arg0);
	}

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return true;
    }
}
