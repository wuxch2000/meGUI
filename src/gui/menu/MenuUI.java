package gui.menu;

import config.properties.*;
import gui.*;
import gui.util.lookfeel.*;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MenuUI extends A_Menu {

    private ButtonGroup group;

    class UIAction extends AbstractAction {
        private final LookFeelUtil.LF_TYPE lf_type;

        public UIAction(final LookFeelUtil.LF_TYPE lf_type) {
            this.lf_type = lf_type;
        }

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            LookFeelUtil.setLookAndFell(lf_type, MainFrame.instance());
        }
    }

    private JRadioButtonMenuItem add(String item, LookFeelUtil.LF_TYPE lf_type) {
        JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem(item);
        menuItem.addActionListener(new UIAction(lf_type));
        group.add(menuItem);
        add(menuItem);
        return menuItem;
    }

    private JRadioButtonMenuItem add(String item, LookFeelUtil.LF_TYPE lf_type, boolean selected) {
        JRadioButtonMenuItem menuItem = add(item,lf_type);
        menuItem.setSelected(true);
        return menuItem;
    }

    public MenuUI() {
        super(DialogProperties.Key.UI);

        group = new ButtonGroup();

        add("Metal", LookFeelUtil.LF_TYPE.Metal);

        add("Nimbus", LookFeelUtil.LF_TYPE.Nimbus, true);

        add("Motif", LookFeelUtil.LF_TYPE.Motif);

        add("Windows", LookFeelUtil.LF_TYPE.Windows);

        add("Windows Classic", LookFeelUtil.LF_TYPE.WindowsClassic);

        add("System", LookFeelUtil.LF_TYPE.System);
    }
}
