package gui.tutorial.button;

import gui.tutorial.TutorialPanel;
import gui.util.ImageUtil;
import gui.util.SizeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午2:54
 */
abstract public class TutorialButton extends JButton implements MouseListener {

    abstract protected String getIconFileName();

    abstract protected String getTip();

    private final TutorialPanel tutorialPanel;

    protected TutorialButton(TutorialPanel tutorialPanel) {
        this.tutorialPanel = tutorialPanel;

        Icon icon = ImageUtil.createImageIcon(getIconFileName());
        setIcon(icon);

        addMouseListener(this);

        final int SIZE_HEIGHT = 128;
        final int SIZE_WIDTH = 256;
        SizeUtil.sameSize(this,SIZE_WIDTH,SIZE_HEIGHT);
    }

    protected void closeDialog() {
        TutorialPanel panel = (TutorialPanel) getParent();
        if (panel != null) {
            panel.closeDialog();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tutorialPanel.setTip(getTip());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        final String NULL_STR = "";
        tutorialPanel.setTip(NULL_STR);
    }
}
