package gui.tutorial.button;

import config.properties.DialogProperties;
import gui.menu.BrowseLogAction;
import gui.tutorial.TutorialPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午2:56
 */
public class TutorialBorwseLogButton extends TutorialButton implements ActionListener {

    static public TutorialBorwseLogButton build(TutorialPanel tutorialPanel) {
        return new TutorialBorwseLogButton(tutorialPanel);
    }

    @Override
    protected String getIconFileName() {
        return "browseLog_tutorial.png";
    }

    @Override
    protected String getTip() {
        return DialogProperties.instance().getString(DialogProperties.Key.BrowseLog);
    }

    public TutorialBorwseLogButton(TutorialPanel tutorialPanel) {
        super(tutorialPanel);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        closeDialog();

        AbstractAction action = new BrowseLogAction();
        action.actionPerformed(null);
    }
}
