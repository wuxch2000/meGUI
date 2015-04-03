package gui.menu;

import config.LocalConfig;
import config.properties.DialogProperties;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-4-8
 * Time: 下午4:14
 */
abstract class A_Menu extends JMenu {
    protected A_Menu(DialogProperties.Key key) {
        super(DialogProperties.instance().getString(key));
        setFont(LocalConfig.instance().getLocalFont());
    }

    public JMenuItem add(AbstractAction action) {
        JMenuItem item = add(new JMenuItem(action));
        item.setFont(LocalConfig.instance().getLocalFont());
        return item;
    }
}
