package gui.profile.left;

import config.encode.*;
import gui.profile.*;
import gui.util.font.FontUtil;
import log.*;

import javax.swing.*;
import javax.swing.event.*;

/**
 * @author 吴晓春
 *         <p/>
 *         PD: Profile Description file
 */

public class PDList extends JList<EncodeProfile> {

    private final PDSplitPanel pdSplitPanel;

    class Selection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                EncodeProfile profile = getSelectedProfile();
                Trace.debug("select profile:", profile.toString());
                pdSplitPanel.updateFromFile(profile);
            }
        }
    }

    public PDList(PDSplitPanel pdSplitPanel) {
        super(new PDListModel());

        FontUtil.setLocalFont(this);
        FontUtil.enlargeFont(this, 1);

        this.pdSplitPanel = pdSplitPanel;
        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        setLayoutOrientation(JList.VERTICAL);
        setVisibleRowCount(-1);
        setSelectedIndex(0);
        addListSelectionListener(new Selection());
    }

    public EncodeProfile getSelectedProfile() {
        return getSelectedValue();
    }

}
