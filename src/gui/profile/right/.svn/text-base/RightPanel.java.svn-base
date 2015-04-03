package gui.profile.right;

import gui.profile.right.audio.*;
import gui.profile.right.basetype.*;
import gui.profile.right.container.*;
import gui.profile.right.font.*;
import gui.profile.right.video.*;
import gui.util.font.FontUtil;

import javax.swing.*;

public class RightPanel extends A_CfgItems {

    private JTabbedPane tabbedPane;
    private JScrollPane scrollPane;

    public RightPanel() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);

        tabbedPane = new JTabbedPane();

        FontUtil.setLocalFont(tabbedPane);

        addTab(new CfgContainer());
        addTab(new CfgVideo());
        addTab(new CfgAudio());
        addTab(new CfgFont());

        tabbedPane.setSelectedIndex(0);

        scrollPane = new JScrollPane(tabbedPane);
    }

    private void addTab(I_ConfigItem configItem) {
        addItem(configItem);

        tabbedPane.addTab(configItem.toString(), configItem.getGUI());
    }

    @Override
    public JComponent getGUI() {
        return scrollPane;
    }

}
