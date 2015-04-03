package gui.tutorial.button;

import config.properties.DialogProperties;
import gui.menu.EditProfileAction;
import gui.tutorial.TutorialPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午2:56
 */
public class TutorialEditProfileButton extends TutorialButton implements ActionListener {

    static public TutorialEditProfileButton build(TutorialPanel tutorialPanel) {
        return new TutorialEditProfileButton(tutorialPanel);
    }

    @Override
    protected String getIconFileName() {
        return "profile_tutorial.png";
    }

    @Override
    protected String getTip() {
        return DialogProperties.instance().getString(DialogProperties.Key.EditProfile);
    }

    public TutorialEditProfileButton(TutorialPanel tutorialPanel) {
        super(tutorialPanel);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        closeDialog();

        AbstractAction action = new EditProfileAction();
        action.actionPerformed(null);
    }
}
