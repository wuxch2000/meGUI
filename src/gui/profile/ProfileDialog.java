package gui.profile;

import config.properties.*;
import gui.MainFrame;
import gui.util.LocationUtil;
import gui.util.SizeUtil;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class ProfileDialog extends JDialog {

	private static final double SCREEN_FACTOR = .8;

    public ProfileDialog() {
		super(MainFrame.instance(), true);
		setTitle(DialogProperties.instance().getString(DialogProperties.Key.EditProfile));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		SizeUtil.setSize(this, SCREEN_FACTOR);
		LocationUtil.setCenterOfScreen(this);

        final PDMainPanel profileDialogMainPanel = new PDMainPanel(this);
		setContentPane(profileDialogMainPanel);
	}
}
