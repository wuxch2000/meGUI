package gui.major.videofilesetting.button;

import config.properties.VideoFileFieldProperties;
import convert.VideoFile;
import gui.major.videofilesetting.ColumnType;
import gui.util.TextUtil;
import gui.util.dialog.FileChooserDialog;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 上午11:46
 */
public class ScriptButton extends A_VFSButton {
    private VideoFile videoFile;
    private File scriptFile = null;

    public ColumnType getColumnType() {
        return ColumnType.SCRIPT;
    }

    private ScriptButton(final VideoFile videoFile) {
        this.videoFile = videoFile;

        String strTitle;
        String strToolTip;
        if (videoFile.getScriptFile() == null) {
            strTitle = VideoFileFieldProperties.instance().
                    getString(VideoFileFieldProperties.Key.NO_SCRIPT);
            strToolTip = strTitle;
        } else {
            strTitle = videoFile.getScriptFile().getName();
            strToolTip = videoFile.getScriptFile().getPath();
        }

        TextUtil.setTextWithToolTip(this, strTitle, strToolTip);
        addActionListener(new ChangeScriptAction());

    }

    public static ScriptButton build(final VideoFile videoFile) {
        return new ScriptButton(videoFile);
    }

    public File getScriptFile() {
        return scriptFile;
    }


    private class ChangeScriptAction implements ActionListener {

        private ChangeScriptAction() {
        }

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            File dir = new File(videoFile.getSourceFile().getParent());
            FileChooserDialog fc = new FileChooserDialog(dir);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setMultiSelectionEnabled(false);
            fc.setFileFilter(new FileNameExtensionFilter(
                    "script file",
                    "srt"
            ));

            if (fc.showOpenDialog(null) != FileChooserDialog.APPROVE_OPTION) {
                return;
            }

            scriptFile = fc.getSelectedFile();

            TextUtil.setTextWithToolTip(ScriptButton.this, scriptFile.getName(), scriptFile.getPath());

        }
    }
}
