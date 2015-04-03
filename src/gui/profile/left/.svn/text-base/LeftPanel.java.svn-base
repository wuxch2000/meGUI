package gui.profile.left;

import config.encode.*;
import gui.profile.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LeftPanel extends JScrollPane {

    private PDList list;

    public LeftPanel(PDSplitPanel pdSplitPanel) {
        list = new PDList(pdSplitPanel);
        setViewportView(list);
    }

    public EncodeProfile getSelectedProfile() {
        return list.getSelectedProfile();
    }

}
