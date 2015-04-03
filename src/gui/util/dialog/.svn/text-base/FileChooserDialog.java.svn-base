package gui.util.dialog;

import config.properties.DialogProperties;

import javax.swing.*;
import java.io.File;

/**
 * User: 吴晓春
 * Date: 12-3-3
 * Time: 下午10:02
 */
public class FileChooserDialog extends JFileChooser {
    private void setUI() {
        DialogProperties dialogProperties = DialogProperties.instance();
        UIManager.put("FileChooser.cancelButtonText",
                dialogProperties.getString(DialogProperties.Key.Cancel));
        UIManager.put("FileChooser.cancelButtonToolTipText",
                dialogProperties.getString(DialogProperties.Key.Cancel));

        UIManager.put("FileChooser.okButtonText",
                dialogProperties.getString(DialogProperties.Key.OK));
        UIManager.put("FileChooser.okButtonToolTipText",
                dialogProperties.getString(DialogProperties.Key.OK));

        UIManager.put("FileChooser.openButtonText",
                dialogProperties.getString(DialogProperties.Key.Open));
        UIManager.put("FileChooser.openButtonToolTipText",
                dialogProperties.getString(DialogProperties.Key.Open));

        UIManager.put("FileChooser.saveButtonText",
                dialogProperties.getString(DialogProperties.Key.Save));
        UIManager.put("FileChooser.saveButtonToolTipText",
                dialogProperties.getString(DialogProperties.Key.Save));

        SwingUtilities.updateComponentTreeUI(this);


    }

    public FileChooserDialog(String currentDirectoryPath) {
        super(currentDirectoryPath);
        setUI();
    }

    public FileChooserDialog(File currentDirectory) {
        super(currentDirectory);
        setUI();
    }

}
