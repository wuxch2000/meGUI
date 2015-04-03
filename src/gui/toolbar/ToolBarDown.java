package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarDown extends A_ProcessTableButton {

    public ToolBarDown() {
        super("down_dark.png", "down_inactive.png", "down_light.png");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        AbstractAction action = new DownAction();
        action.actionPerformed(arg0);
    }

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return table != null
               && table.getSelectVideoFiles().length > 0
               && !table.selectRowIsBottom();
    }
}
