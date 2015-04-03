package gui.profile.right.basetype;

import config.encode.*;
import gui.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-14
 * Timex: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
abstract public class A_ComboxPanel implements I_ConfigItem {
    private final JPanel panel;
    private LinkedList<I_ConfigItem> choiceList;
    private int defaultChoose;

    private JComboBox choiceBox;
    private I_ConfigItem previous_selected_item = null;


    class Change implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            I_ConfigItem selected_item = (I_ConfigItem) choiceBox
                    .getSelectedItem();

            if (previous_selected_item != null
                    && (previous_selected_item != selected_item)) {
                getPanel().remove(previous_selected_item.getGUI());
                getPanel().add(selected_item.getGUI());
                getPanel().updateUI();
            }
            previous_selected_item = selected_item;

        }
    }

    protected A_ComboxPanel(I_ConfigItem[] listItem, int defaultChoose) {
        super();
        panel = new JPanel();
        LayoutManager layoutManager = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layoutManager);

        choiceList = new LinkedList<I_ConfigItem>();
        Collections.addAll(choiceList, listItem);
        this.defaultChoose = defaultChoose;

        panel.add(setUpsidePanel());
        panel.add(setDownsidePanel());

        BorderUtil.addBorder(panel, this.toString());

    }

    protected JPanel getPanel() {
        return panel;
    }

    @Override
    public JComponent getGUI() {
        return getPanel();
    }

    private JComponent setUpsidePanel() {

        JPanel upsidePanel = new JPanel();
        upsidePanel.setLayout(new BoxLayout(upsidePanel,
                BoxLayout.LINE_AXIS));

        choiceBox = new JComboBox();

        for (I_ConfigItem item : choiceList) {
            choiceBox.addItem(item);
        }
        SizeUtil.setSize(choiceBox);

        choiceBox.setSelectedIndex(defaultChoose);

        previous_selected_item = (I_ConfigItem) choiceBox
                .getSelectedItem();
        choiceBox.addActionListener(new Change());

        upsidePanel.add(choiceBox);
        upsidePanel.add(Box.createHorizontalGlue());

        BorderUtil.addSpaceBorder(upsidePanel);

        return upsidePanel;


    }

    private JComponent setDownsidePanel() {

        I_ConfigItem item = (I_ConfigItem) choiceBox.getSelectedItem();
        return item.getGUI();
    }

    @Override
    public void setDefault() {
        I_ConfigItem item = (I_ConfigItem) choiceBox.getSelectedItem();
        item.setDefault();

    }

    @Override
    public String toCmdLineArg() {
        I_ConfigItem item = (I_ConfigItem) choiceBox.getSelectedItem();
        return item.toCmdLineArg();
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        I_ConfigItem item = (I_ConfigItem) choiceBox.getSelectedItem();
        item.updateFromFile(file);
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        I_ConfigItem item = (I_ConfigItem) choiceBox.getSelectedItem();
        item.updateToFile(file);
    }

}
