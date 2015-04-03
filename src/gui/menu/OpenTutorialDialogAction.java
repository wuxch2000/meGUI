package gui.menu;

import config.properties.DialogProperties;
import gui.MainFrame;
import gui.tutorial.TutorialDlg;
import gui.util.dialog.ModuleDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OpenTutorialDialogAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
        ModuleDialog dlg = TutorialDlg.build(MainFrame.instance());
        ModuleDialog.showDialog(dlg);
	}

	public OpenTutorialDialogAction() {
		super(DialogProperties.instance().getString(DialogProperties.Key.OpenTutorialDialog));
	}

}
