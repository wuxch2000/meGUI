package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarUp extends A_ProcessTableButton {

    public ToolBarUp() {
        super("up_dark.png", "up_inactive.png", "up_light.png");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        AbstractAction action = new UpAction();
        action.actionPerformed(arg0);
    }

    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return table != null
               && table.getSelectVideoFiles().length > 0
               && !table.selectRowIsTop();
    }
}
