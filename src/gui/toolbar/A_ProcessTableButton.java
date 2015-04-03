package gui.toolbar;

import gui.major.table.*;
import gui.util.ImageUtil;

/**
 * User: 吴晓春
 * Date: 11-4-18
 * Time: 上午9:53
 */
public abstract class A_ProcessTableButton extends A_PlainToolBarButton {
    public A_ProcessTableButton(String activeGifString,
                                String inactiveGifString,
                                String activeMouseIconString) {

        addIcon(IconType.active,
                ImageUtil.createImageIcon(activeGifString));
        addIcon(IconType.inactive,
                ImageUtil.createImageIcon(inactiveGifString));
        addIcon(IconType.mouseOn,
                ImageUtil.createImageIcon(activeMouseIconString));

        init();
    }

    abstract public boolean getNewButtonEnable(ProcessTable table);
}
