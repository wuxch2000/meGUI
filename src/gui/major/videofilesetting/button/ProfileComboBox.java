package gui.major.videofilesetting.button;

import config.*;
import config.encode.*;
import gui.major.videofilesetting.*;

import javax.swing.*;
import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 上午11:56
 */
public class ProfileComboBox extends JComboBox implements GetColumnType{

    public  ColumnType getColumnType() {
        return ColumnType.PROFILE;
    }

    private ProfileComboBox() {
        String[] profiles = Config.instance().getProfiles();

        for (String profile : profiles) {
            EncodeProfile ep = new EncodeProfile(new File(profile));
            addItem(ep);
        }
        setFocusable(false);
        addMouseListener(new MouseAction(this));
    }

    public static ProfileComboBox build() {
        return new ProfileComboBox();
    }

    public EncodeProfile getSelectProfile() {
        return (EncodeProfile) getSelectedItem();
    }
}
