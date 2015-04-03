package gui.menu;


import config.properties.DialogProperties;
import gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: 吴晓春
 * Date: 12-3-3
 * Time: 下午9:18
 */
public class OpenSourcePathAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MainPanel.instance().getMajorPanel().
                getTablePanel().openSourcePath();
    }

    public OpenSourcePathAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.OpenSourceFilePath));
    }
}

