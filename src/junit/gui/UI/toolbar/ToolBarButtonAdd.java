package junit.gui.UI.toolbar;

import gui.toolbar.A_PlainToolBarButton;
import gui.util.ImageUtil;

import java.awt.event.ActionEvent;

/**
 * User: 吴晓春
 * Date: 11-8-12
 * Time: 下午3:26
 */
public class ToolBarButtonAdd extends A_PlainToolBarButton {

    public ToolBarButtonAdd() {
        addIcon(IconType.active,
                ImageUtil.createImageIcon("open_dark.png"));
        addIcon(IconType.inactive,
                ImageUtil.createImageIcon("open_inactive.png"));
        addIcon(IconType.mouseOn,
                ImageUtil.createImageIcon("open_light.png"));

        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
