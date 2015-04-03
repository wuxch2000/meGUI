package gui.tutorial;

import config.properties.DialogProperties;
import gui.tutorial.button.*;
import gui.util.dialog.ModuleDialog;
import gui.util.font.FontUtil;
import gui.util.layout.LayoutUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-7-18
 * Time: 下午1:56
 */
public class TutorialPanel extends JPanel {

    private ModuleDialog dlg;
    private TutorialTipDisplayArea tutorialTipDisplayArea;

    public TutorialPanel(ModuleDialog dlg) {

        this.dlg = dlg;
        LayoutUtil.UsingGridBagLayout(this);

        GridBagConstraints c;
        int line = 0, column = 0;

        final int BUTTON_WIDTH = 2;
        final int TOTAL_WIDTH = BUTTON_WIDTH * 2;
        final int GAP = 15;
        final Insets insets = new Insets(GAP, GAP, GAP, GAP);

        c = LayoutUtil.buildConstraints(line, column, BUTTON_WIDTH, insets);
        TutorialButton button = TutorialAddButton.build(this);
        add(button, c);

        line = 0;
        column = 2;
        c = LayoutUtil.buildConstraints(line, column, BUTTON_WIDTH, insets);
        button = TutorialEditProfileButton.build(this);
        add(button, c);

        line++;
        column = 0;
        c = LayoutUtil.buildConstraints(line, column, BUTTON_WIDTH, insets);
        button = TutorialBorwseLogButton.build(this);
        add(button, c);

        column = 2;
        c = LayoutUtil.buildConstraints(line, column, BUTTON_WIDTH, insets);
        button = TutorialHelpButton.build(this);
        add(button, c);

        line++;
        column = 0;
        c = LayoutUtil.buildConstraints(line, column, TOTAL_WIDTH, insets);
        c.anchor = GridBagConstraints.WEST;
        tutorialTipDisplayArea = TutorialTipDisplayArea.build();
        add(tutorialTipDisplayArea, c);

        line++;
        column = 0;
        c = LayoutUtil.buildConstraints(line, column, insets);
        c.anchor = GridBagConstraints.WEST;
        add(CheckBoxShowOnStartUp.build(), c);

        column = 3;
        c = LayoutUtil.buildConstraints(line, column, insets);
        c.anchor = GridBagConstraints.EAST;
        String title = DialogProperties.instance().getString(DialogProperties.Key.Quit);
        JButton quitButton = new JButton(title);

        FontUtil.setLocalFont(quitButton);

        quitButton.addActionListener(new QuitProcess());
        add(quitButton, c);

    }

    class QuitProcess implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            closeDialog();
        }
    }

    public void closeDialog() {
        if (dlg != null) {
            dlg.close(ModuleDialog.ReturnValue.Cancel);
        }
    }

    public void setTip(String text) {
        tutorialTipDisplayArea.setTip(text);
    }
}
