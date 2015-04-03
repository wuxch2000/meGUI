package gui.major;

import config.properties.*;
import convert.*;
import convert.util.*;
import gui.*;
import gui.major.table.*;
import gui.major.videoinfo.*;
import gui.swingworker.*;
import gui.util.monitor.*;
import log.*;

import javax.swing.*;
import java.io.*;

import static javax.swing.JSplitPane.*;

/**
 * User: 吴晓春
 * Date: 11-2-18
 * Timex: 上午11:43
 */
public class MajorPanel implements I_GUI, I_Update, I_Progress {

    private JSplitPane splitPane;

    private TablePanel tablePanel;

    public VideoInfoMainPanel getVideoInfoMainPanel() {
        return videoInfoMainPanel;
    }

    private VideoInfoMainPanel videoInfoMainPanel;

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public MajorPanel() {


        tablePanel = new TablePanel(this);


        splitPane = new JSplitPane();
        splitPane.setOrientation(VERTICAL_SPLIT);
        splitPane.setTopComponent(tablePanel);

//        splitPane.setBottomComponent(null);
        videoInfoMainPanel = new VideoInfoMainPanel();
            splitPane.setBottomComponent(videoInfoMainPanel);
//        getVideoInfoMainPanel();
        splitPane.getBottomComponent().setVisible(false);

        splitPane.setOneTouchExpandable(true);
    }

    public void update(VideoFile videoFile) {
        if (infoPanelIsClose()) {
            Trace.debug("MajorPanel.update():",
                "infoPanelIsClose == true");
            return;
        }
        ProgressMonitor progressMonitor = new ProgressMonitor(
            tablePanel,
            "Get Video Files Info ...",
            "", 0, 100);
        progressMonitor.setMillisToDecideToPopup(500);
        progressMonitor.setMillisToPopup(500);
        progressMonitor.setProgress(0);
        if (videoFile != null) {
            Trace.debug("MajorPanel:update, file is:", videoFile.toString());
        }
        getVideoInfoMainPanel().update(videoFile);
        progressMonitor.setProgress(50);
        adjustSplitBar(videoFile);
        progressMonitor.setProgress(100);

//        setSplitPanelSize();

        progressMonitor.close();
        if (videoFile != null) {
            Trace.debug("MajorPanel:update, videoInfoHeight:",
                getVideoInfoMainPanel().getHeight());
        }
    }

    private void closeInfoPanel() {
//        if (infoPanelIsClose()) {
//            return;
//        }
//        splitPane.getRightComponent().setMinimumSize(new Dimension());
//        splitPane.setDividerLocation(1.0d);
//        Trace.debug("MajorPanel.closeInfoPanel():",
//            "splitPane.setDividerLocation(-1);");
        splitPane.getBottomComponent().setVisible(false);
    }

    public void openInfoPanel(VideoFile videoFile) {
        splitPane.getBottomComponent().setVisible(true);
        update(videoFile);
        setSplitPanelSize();
    }

    private boolean infoPanelIsClose() {
//        int d = splitPane.getDividerLocation();
//        return d == 1;
        return !splitPane.getBottomComponent().isVisible();
    }

    public void setSplitPanelSize() {
        splitPane.setResizeWeight(1.0);
        int videoInfoHeight = 200;
        double proportionalLocation = (double) videoInfoHeight / (double) splitPane.getHeight();
        splitPane.setDividerLocation(1.0 - proportionalLocation);
    }

    public void adjustSplitBar(VideoFile videoFile) {
        if (videoFile == null) {
            closeInfoPanel();
        }
//        int videoInfoHeight = getVideoInfoMainPanel().getHeight();
//        openInfoPanel();
    }

    @Override()
    public JComponent getGUI() {
        return splitPane;
    }

    @Override
    public void setValue(final VideoFile videoFile, final int value) {
        tablePanel.setProgressInfo(videoFile, value);
    }

    private class CancelExec implements SupportCancel {
        private final SwingWorkerGui worker;

        public CancelExec(SwingWorkerGui worker) {
            this.worker = worker;
        }

        @Override
        public void cancel() {
            if (!worker.isCancelled()) {
                Trace.debug("cancel current work");
                worker.cancel(true);
            }
        }
    }

    public void addVideoFile(VideoFile[] files) {
        if (files.length == 0) {
            return;
        }
        Monitor.instance().setBegin(
            DialogProperties.instance().
                getString(DialogProperties.Key.AddingVideoFiles));
        SwingWorkerGui worker = new SwingWorkerGui(new DoAddVideoFile(this, files));
        Monitor.instance().setCancel(new CancelExec(worker));
        worker.execute();
    }

    public void removeVideoFile() {
        tablePanel.removeVideoFile();
    }

    public void convertVideoFile() {
        VideoFile[] files = tablePanel.getSelectVideoFiles();
        if (files == null || files.length == 0) {
            files = getTablePanel().getAllVideoFiles();
        }

        SwingWorkerGui worker = new SwingWorkerGui(
            new DoConvertFile(this, files));
        worker.execute();
    }

    public void stopConverting() {
        VideoFile[] files = getTablePanel().getSelectVideoFiles();
        if (files == null || files.length == 0) {
            files = getTablePanel().getAllVideoFiles();
        }

        SwingWorkerGui worker = new SwingWorkerGui(
            new DoStopConverting(this, files));
        worker.execute();
    }

    public void stopConverting(VideoFile videoFile) {
        SwingWorkerGui worker = new SwingWorkerGui(
            new DoStopConverting(this, new VideoFile[]{videoFile}));
        worker.execute();
    }

    public void upVideoFile() {
        getTablePanel().upVideoFile();
    }

    public void downVideoFile() {
        getTablePanel().downVideoFile();
    }


    public boolean isDuplicateDestFileName(String fileName) {
        VideoFile[] files = getTablePanel().getAllVideoFiles();
        for (VideoFile file : files) {
            File destFile = file.getDestinFile();
            if (destFile != null) {
                if (destFile.getPath().equalsIgnoreCase(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
