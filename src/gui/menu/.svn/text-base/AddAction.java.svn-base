package gui.menu;

import config.properties.DialogProperties;
import convert.VideoFile;
import gui.MainPanel;
import gui.major.AddVideoFile;
import gui.util.VideoFileFilter;
import log.Trace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Vector;

@SuppressWarnings("serial")
public class AddAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent arg0) {

        AddVideoFile addVideoFile = new AddVideoFile();
        File[] files = addVideoFile.getSelectedFiles();

        Vector<VideoFile> videoFiles = new Vector<>();
        for (File file : files) {
            if (VideoFileFilter.isVideoFile(file)) {
                videoFiles.add(VideoFile.build(file));
            } else {
                Trace.error("File [", file.getPath(),
                        File.pathSeparator, file.getName(), "] is not a video file");
            }

        }

        MainPanel.instance().getMajorPanel().
                addVideoFile(videoFiles.toArray(new VideoFile[videoFiles.size()]));

    }

    public AddAction() {
        super(DialogProperties.instance().
                getString(DialogProperties.Key.AddVideoFile));
    }

}
