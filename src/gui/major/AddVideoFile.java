package gui.major;

import config.ConvertLog;
import config.properties.DialogProperties;
import gui.I_GUI;
import gui.util.VideoFileFilter;
import log.Trace;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.FILES_ONLY;

/**
 * User: 吴晓春
 */
public class AddVideoFile implements I_GUI {

    final static private FileFilter filter =
            new FileNameExtensionFilter(
                    DialogProperties.instance().getString(DialogProperties.Key.videoFile),
                    VideoFileFilter.toArray());

    private JFileChooser fileChooser;

    public AddVideoFile() {
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        UIManager.put("FileChooser.cancelButtonText",
                DialogProperties.instance().getString(DialogProperties.Key.Cancel));
        SwingUtilities.updateComponentTreeUI(fileChooser);

        File lastOpenDir = new File(ConvertLog.instance().getLastOpenDir());
        File parentOfLastOpenDir = lastOpenDir.getParentFile();
        File defaultOpenDir = null;
        if (lastOpenDir.exists()) {
            defaultOpenDir = lastOpenDir;
            Trace.debug("default open dir:", defaultOpenDir.getPath());
        } else if (parentOfLastOpenDir != null && parentOfLastOpenDir.exists()) {
            defaultOpenDir = parentOfLastOpenDir;
            Trace.debug("default open dir(using parent):", defaultOpenDir.getPath());
        }
        if (defaultOpenDir != null) {
            Trace.debug("set default open dir:", defaultOpenDir.getPath());
            fileChooser.setCurrentDirectory(defaultOpenDir);
        }

    }

    @Override
    public JComponent getGUI() {
        return fileChooser;
    }

    public File[] getSelectedFiles() {

        int ret = fileChooser.showDialog(null,
                DialogProperties.instance().getString(DialogProperties.Key.Add));

        if (ret == APPROVE_OPTION) {
            ConvertLog.instance().setLastOpenDir(fileChooser.getCurrentDirectory()
                    .getPath());
            return fileChooser.getSelectedFiles();
        }

        return new File[0];
    }
}
