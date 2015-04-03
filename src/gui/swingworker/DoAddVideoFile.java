package gui.swingworker;

import config.properties.*;
import convert.*;
import gui.major.*;
import gui.major.videofilesetting.*;
import gui.util.dialog.*;
import gui.util.monitor.*;

/**
 * User: 吴晓春
 * Date: 11-3-11
 * Timex: 下午3:56
 */

public class DoAddVideoFile implements NeedUsingSwingWorker {
    final private VideoFile[] videofiles;
    private MajorPanel majorPanel;

    public DoAddVideoFile(MajorPanel majorPanel, VideoFile[] videofiles) {
        this.videofiles = videofiles;
        this.majorPanel = majorPanel;
    }

    @Override()
    public void done() throws Exception {
        Monitor.instance().setDone();

        VFS_MainDlg dialog = new VFS_MainDlg(videofiles);
        if (ModuleDialog.showDialog(dialog) == VFS_MainDlg.ReturnValue.OK) {
            majorPanel.getTablePanel().addVideoFiles(videofiles);
        }
    }

    @Override()
    public void doInBackground() throws Exception {
        int number = videofiles.length;
        int i = 0;
        Monitor.instance().setProgress(0);

        VideoFile firstVideo = null;

        for (VideoFile videoFile : videofiles) {

            String prompt = DialogProperties.instance().
                getString(DialogProperties.Key.Processing, videoFile.toString());

            Monitor.instance().setPrompt(prompt);
            videoFile.initVideoFile();


            if (firstVideo == null) {
                firstVideo = videoFile;
            }

            Monitor.instance().setProgress((++i) * 100 / number);
        }


        if (firstVideo != null) {
            majorPanel.getTablePanel().setSelect(firstVideo);
        }
    }
}
