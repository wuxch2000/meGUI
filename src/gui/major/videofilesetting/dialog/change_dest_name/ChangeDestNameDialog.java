package gui.major.videofilesetting.dialog.change_dest_name;

import config.properties.*;
import gui.util.dialog.*;

import java.awt.*;

import static config.properties.DialogProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-3-28
 * Time: 下午7:50
 */
public class ChangeDestNameDialog extends ModuleDialog {
    private ChangeDestNamePanel mainPanel;

    public ChangeDestNameDialog(final Frame frame, String oldName) {
        super(frame, DialogProperties.instance().getString(ChangeName));

        mainPanel = new ChangeDestNamePanel(oldName, this);

        this.setContentPane(mainPanel);
        this.pack();

    }

    public String getText() {
        return mainPanel.getText();
    }

    public boolean getNomalizeAll() {
        return mainPanel.getNomalizeAll();
    }

}
