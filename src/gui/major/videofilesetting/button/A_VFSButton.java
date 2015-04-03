package gui.major.videofilesetting.button;

import gui.util.font.FontUtil;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-8-15
 * Time: 下午12:07
 */
abstract public class A_VFSButton extends JButton implements GetColumnType {
    protected A_VFSButton() {
        setFocusable(false);
        addMouseListener(new MouseAction(this));
        FontUtil.setLocalFont(this);
    }
}
