package gui.toolbar;

import gui.util.SizeUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public abstract class A_PlainToolBarButton
        extends JButton
        implements ActionListener{

    protected enum IconType {
        active,
        inactive,
        mouseOn,
    }

    private Map<IconType, Icon> iconMap;

    protected void addIcon(IconType iconType, Icon icon) {
        iconMap.put(iconType, icon);
    }

    private Icon getIcon(IconType iconType) {
        return iconMap.get(iconType);
    }

    protected void init() {
        // must be called by sub-class after initialized.

        for (IconType iconType : iconMap.keySet()) {
            switch (iconType) {
                case active:
                    setIcon(getIcon(iconType));
                    break;
                case inactive:
                    setDisabledIcon(getIcon(iconType));
                    break;
                case mouseOn:
                    setRolloverIcon(getIcon(iconType));
                    break;
            }
        }

        addActionListener(this);
        setSelected(false);

        final int ICON_SIZE_EDGE = 48;

        SizeUtil.sameSize(this,ICON_SIZE_EDGE,ICON_SIZE_EDGE);
    }

    protected A_PlainToolBarButton() {
        iconMap = new HashMap<>();
    }
}
