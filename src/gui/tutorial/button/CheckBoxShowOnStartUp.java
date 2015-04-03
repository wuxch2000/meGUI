package gui.tutorial.button;

import config.ConvertLog;
import config.properties.DialogProperties;
import gui.util.font.FontUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-7-19
 * Time: 上午11:52
 */
public class CheckBoxShowOnStartUp extends JCheckBox
        implements ActionListener {
    private CheckBoxShowOnStartUp() {

        String title = DialogProperties.instance().getString(DialogProperties.Key.ShowOnStartUp);
        setText(title);

        setSelected(ConvertLog.instance().getShowtutorailOnStartUp());

        addActionListener(this);

        FontUtil.setLocalFont(this);
    }

    public static CheckBoxShowOnStartUp build() {
        return new CheckBoxShowOnStartUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConvertLog.instance().setShowtutorailOnStartUp(isSelected());
    }
}
