package gui.profile;

import config.*;
import config.encode.*;
import config.properties.*;
import gui.util.font.FontUtil;
import gui.util.layout.*;
import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PDMainPanel extends JPanel {

    private final ProfileDialog dlg;
    private final PDSplitPanel splitPanel;

    public PDMainPanel(ProfileDialog dlg) {
        this.dlg = dlg;
        setLayout(new BorderLayout());

        splitPanel = new PDSplitPanel();
        add(splitPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        LayoutUtil.UsingGridBagLayout(buttonPanel);

//        if (Config.debug()) {
//            JButton cmdArg = new JButton("CmdArg");
//            cmdArg.addActionListener(new CmdArg());
//            buttonPanel.add(cmdArg);
//        }

        DialogProperties dp = DialogProperties.instance();
        int line = 0, column = 0;
        GridBagConstraints c;

        c = LayoutUtil.buildConstraints(line, column, 1.0, 0.0, 1);
        c.anchor = GridBagConstraints.EAST;
        JButton buttonDefault = new JButton(dp.getString(DialogProperties.Key.Default));
        FontUtil.setLocalFont(buttonDefault);
        buttonDefault.addActionListener(new Default());
        buttonPanel.add(buttonDefault, c);

        column++;
        c = LayoutUtil.buildConstraints(line, column);
        JButton buttonOK = new JButton(dp.getString(DialogProperties.Key.OK));
        FontUtil.setLocalFont(buttonOK);
        buttonOK.addActionListener(new OK());
        buttonPanel.add(buttonOK, c);

        column++;
        c = LayoutUtil.buildConstraints(line, column);
        JButton buttonCancel = new JButton(dp.getString(DialogProperties.Key.Cancel));
        FontUtil.setLocalFont(buttonCancel);
        buttonCancel.addActionListener(new Cancel());
        buttonPanel.add(buttonCancel, c);


        add(buttonPanel, BorderLayout.SOUTH);
    }

    class Cancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (Config.debug()) {
                System.exit(0);
            }
            dlg.setVisible(false);
        }

    }

    class OK implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            EncodeProfile file = splitPanel.getSelectedProfile();
            Trace.debug("PDMainPanel$OK.actionPerformed():",
                "update config for profile:", file.toString());
            splitPanel.updateToFile(file);
            if (Config.debug()) {
                System.exit(0);
            }
            dlg.setVisible(false);
        }

    }

    class Default implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            splitPanel.setDefault();
        }

    }

}
