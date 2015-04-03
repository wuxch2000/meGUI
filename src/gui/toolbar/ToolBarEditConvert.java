package gui.toolbar;

import gui.major.table.*;
import gui.menu.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolBarEditConvert extends A_ProcessTableButton {

    public ToolBarEditConvert() {
        super("edit_dark.png", "edit_inactive.png", "edit_light.png");

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        EditConvertAction action = new EditConvertAction();
        action.actionPerformed(arg0);
    }


    @Override
    public boolean getNewButtonEnable(final ProcessTable table) {
        return table != null
               && table.getSelectVideoFiles().length > 0
            ;
    }
}
