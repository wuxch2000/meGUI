package gui.toolbar;

import convert.util.*;
import gui.major.table.*;
import gui.menu.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarStop extends A_ProcessTableButton {

	public ToolBarStop() {
		super("stop_dark.png", "stop_inactive.png","stop_light.png");
        setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        AbstractAction action = new StopAction();
        action.actionPerformed(arg0);
	}

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return !VideoConvertInstances.instance().isEmtpy();
    }
}
