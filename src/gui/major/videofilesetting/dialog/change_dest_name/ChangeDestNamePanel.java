package gui.major.videofilesetting.dialog.change_dest_name;

import config.*;
import config.properties.*;
import gui.util.*;
import gui.util.dialog.*;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static config.properties.DialogProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-3-28
 * Time: 下午8:04
 */
public class ChangeDestNamePanel extends JPanel {

    private JTextField newNameField;
    private JCheckBox chcekBoxNormalizeAll;

    public ChangeDestNamePanel(String oldName, final ChangeDestNameDialog dialog) {

        LayoutUtil.UsingGridBagLayout(this);
        GridBagConstraints c;

        final int MAX_COLUMN = 4;
        int line, column;
        line = 2;

        column = MAX_COLUMN - 1;
        JButton buttonCancel = new JButton(DialogProperties.instance().getString(Cancel));
        buttonCancel.setFont(LocalConfig.instance().getLocalFont());
        buttonCancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (dialog != null) {
                    dialog.close(ModuleDialog.ReturnValue.Cancel);
                }
            }
        });
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.LINE_END;
        add(buttonCancel, c);

        column--;
        JButton buttonOK = new JButton(DialogProperties.
                instance().getString(OK));
        buttonOK.setFont(LocalConfig.instance().getLocalFont());
        buttonOK.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (dialog != null) {
                    dialog.close(ModuleDialog.ReturnValue.OK);
                }
            }
        });
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.LINE_END;
        add(buttonOK, c);

        column--;
        JButton buttonNormalize = new JButton(DialogProperties.instance().getString(Normalize));
        buttonNormalize.setFont(LocalConfig.instance().getLocalFont());
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.LINE_END;
        buttonNormalize.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                normalize();
            }
        });
        add(buttonNormalize, c);

        column--;
        chcekBoxNormalizeAll = new JCheckBox(
                DialogProperties.instance().getString(NormalizeAll));
        chcekBoxNormalizeAll.setSelected(false);
        chcekBoxNormalizeAll.setFont(LocalConfig.instance().getLocalFont());
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.LINE_END;
        c.weightx = 1;
        add(chcekBoxNormalizeAll, c);


        final int MAX_FIELD_LENGTH = 30;
        line = 1;
        column = 0;
        newNameField = new JTextField(oldName, MAX_FIELD_LENGTH);
        int selectEndPos = oldName.lastIndexOf('.');
        if (selectEndPos == -1) {
            newNameField.selectAll();
        } else {
            newNameField.select(0, selectEndPos);
        }


        c = LayoutUtil.buildConstraints(line, column);
        c.gridwidth = MAX_COLUMN;
        c.anchor = GridBagConstraints.LINE_START;
        add(newNameField, c);


        line = 0;
        column = 0;
        JLabel labelPrompt = new JLabel();
        labelPrompt.setText(DialogProperties.instance().getString(ChangeNamePrompt));
        labelPrompt.setFont(LocalConfig.instance().getLocalFont());
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.LINE_START;
        add(labelPrompt, c);


        BorderUtil.addSpaceBorder(this, 10);

    }

    private void normalize() {
        chcekBoxNormalizeAll.setSelected(true);

        String recommentString = ChangeDestNameUtil.getRecommentString(newNameField.getText());
        newNameField.setText(recommentString);
        newNameField.selectAll();
        newNameField.requestFocus();
    }

    public String getText() {
        return newNameField.getText();
    }

    public boolean getNomalizeAll() {
        return chcekBoxNormalizeAll.isSelected();
    }

}
