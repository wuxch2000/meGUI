package gui.swingworker;

import convert.*;
import convert.util.*;
import gui.*;
import gui.major.*;
import gui.util.monitor.*;

/**
 * User: 吴晓春
 * Date: 11-3-11
 * Timex: 下午3:56
 */

public class DoStopConverting implements NeedUsingSwingWorker {
    final private VideoFile[] videoFiles;
    private MajorPanel majorPanel;

    public DoStopConverting(MajorPanel majorPanel, VideoFile[] videoFiles) {
        this.videoFiles = videoFiles;
        this.majorPanel = majorPanel;
    }

    @Override()
    public void done() throws Exception {
        MainPanel.instance().getToolBar().updateButtonEnable();
    }

    @Override()
    public void doInBackground() throws Exception {
        for (VideoFile videoFile : videoFiles) {
            VideoConvertInstances.instance().stopConvert(videoFile);
        }
    }
}
