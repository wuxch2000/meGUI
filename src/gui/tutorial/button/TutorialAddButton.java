package gui.tutorial.button;

import config.properties.DialogProperties;
import gui.menu.AddAction;
import gui.tutorial.TutorialPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午2:56
 */
public class TutorialAddButton extends TutorialButton implements ActionListener {

    static public TutorialAddButton build(TutorialPanel tutorialPanel) {
        return new TutorialAddButton(tutorialPanel);
    }

    @Override
    protected String getIconFileName() {
        return "open_tutorial.png";
    }

    @Override
    protected String getTip() {
        return DialogProperties.instance().getString(DialogProperties.Key.AddVideoFile);
    }

    public TutorialAddButton(TutorialPanel tutorialPanel) {
        super(tutorialPanel);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        closeDialog();

        AbstractAction action = new AddAction();
        action.actionPerformed(null);
    }
}
