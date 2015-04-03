package gui.toolbar;

import convert.util.*;
import gui.major.table.*;
import gui.menu.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarConvert extends A_ProcessTableButton {

	public ToolBarConvert() {
		super("convert.png", "convert_inactive.png","convert_light.png");
//        setEnable(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        AbstractAction action = new ConvertAction();
        action.actionPerformed(arg0);
	}

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {

        return VideoConvertInstances.instance().isEmtpy() &&
               (table != null) && !table.isEmpty();
    }
}
