package gui.profile.left;

import config.*;
import config.encode.*;

import javax.swing.*;
import java.io.*;

@SuppressWarnings("serial")
public class PDListModel extends DefaultListModel<EncodeProfile> {

	public PDListModel() {

        String[] profiles = Config.instance().getProfiles();
		for (String string : profiles) {
			addElement(new EncodeProfile(new File(string)));
		}
	}
}
