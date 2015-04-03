package gui.tutorial.button;

import gui.util.SizeUtil;
import gui.util.font.FontUtil;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-7-28
 * Time: 下午2:55
 */
public class TutorialTipDisplayArea extends JLabel {
    private TutorialTipDisplayArea() {
        SizeUtil.sameSize(this, 100, 15);
        FontUtil.setLocalFont(this);
    }

    public static TutorialTipDisplayArea build() {
        return new TutorialTipDisplayArea();
    }

    public void setTip(String text) {
        setText(text);
    }
}
