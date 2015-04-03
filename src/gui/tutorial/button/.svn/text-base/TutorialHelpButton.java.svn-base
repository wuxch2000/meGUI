package gui.tutorial.button;

import config.properties.DialogProperties;
import gui.menu.AboutAction;
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
public class TutorialHelpButton extends TutorialButton implements ActionListener {

    static public TutorialHelpButton build(TutorialPanel tutorialPanel) {
        return new TutorialHelpButton(tutorialPanel);
    }

    @Override
    protected String getIconFileName() {
        return "help_tutorial.png";
    }

    @Override
    protected String getTip() {
        return DialogProperties.instance().getString(DialogProperties.Key.Help);
    }

    public TutorialHelpButton(TutorialPanel tutorialPanel) {
        super(tutorialPanel);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        closeDialog();

        AbstractAction action = new AboutAction();
        action.actionPerformed(null);
    }
}
