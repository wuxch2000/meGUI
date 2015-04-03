package gui.menu;

import config.properties.DialogProperties;
import gui.MainFrame;
import gui.util.dialog.OptionPaneDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AboutAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        OptionPaneDialog.showMessageDialogEx(
                MainFrame.instance(),
                DialogProperties.Key.GUIForMecoder,
                DialogProperties.Key.About,
                "2012/3/3");
    }

    public AboutAction() {
        super(DialogProperties.instance().getString(DialogProperties.Key.About));
    }

}
