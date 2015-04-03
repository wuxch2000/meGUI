package gui.profile;

import config.encode.*;
import gui.profile.left.*;
import gui.profile.right.*;
import gui.profile.right.basetype.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PDSplitPanel extends JSplitPane implements I_ConfigItem {
    private final LeftPanel left;
    private final RightPanel right;

    public PDSplitPanel() {
        super();
        super.setOneTouchExpandable(true);

        left = new LeftPanel(this);
        super.setLeftComponent(left);

        right = new RightPanel();
        super.setRightComponent(right.getGUI());

        updateFromFile(left.getSelectedProfile());
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        right.updateFromFile(file);
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        right.updateToFile(file);
    }

    @Override
    public String toCmdLineArg() {
        return right.toCmdLineArg();
    }

    @Override
    public void setDefault() {
        right.setDefault();
    }

    @Override
    public JComponent getGUI() {
        return this;
    }

    public EncodeProfile getSelectedProfile() {
        return (EncodeProfile) left.getSelectedProfile();
    }
}
