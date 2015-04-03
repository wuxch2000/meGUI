package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarRemove extends A_ProcessTableButton {

    public ToolBarRemove() {
        super("remove_dark.png", "remove_inactive.png", "remove_light.png");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        RemoveAction action = new RemoveAction();
        action.actionPerformed(arg0);
    }

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return table != null
               && table.getSelectVideoFiles().length > 0
               ;
    }
}
