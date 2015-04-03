package gui.major.table;

import convert.VideoFile;
import gui.major.MajorPanel;
import gui.toolbar.MainToolBar;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * User: 吴晓春
 * Date: 11-8-12
 * Time: 上午11:31
 */
public class TablePanel extends JPanel {

    private ProcessTable table;
    private JScrollPane tableScrollPane;
    private EmptyPanel emptyPanel;
    private boolean isEmptyPanel;


    public TablePanel(MajorPanel majorPanel) {
        super(new BorderLayout());
        table = new ProcessTable(majorPanel);
        tableScrollPane = new JScrollPane(table);

        emptyPanel = new EmptyPanel();

        add(emptyPanel, BorderLayout.CENTER);
        isEmptyPanel = true;
    }

    private void changeNewDisplay(JComponent jComponent) {
        removeAll();
        add(jComponent, BorderLayout.CENTER);
        revalidate();
        getParent().revalidate();
        update(getGraphics());
    }

    public void updateGUI() {

        if (table.isEmpty()) {
            if (!isEmptyPanel) {
                changeNewDisplay(emptyPanel);
                isEmptyPanel = true;
            }
        } else {
            if (isEmptyPanel) {
                changeNewDisplay(tableScrollPane);
                isEmptyPanel = false;
            }
        }
    }

    public void addVideoFile(VideoFile videoFile) {
        table.getModel().addVideoFile(videoFile);
        updateGUI();
    }

    public void addVideoFiles(VideoFile[] videoFiles) {
        for (VideoFile videoFile : videoFiles) {
            addVideoFile(videoFile);
        }
    }

    public ProcessTable.ProgressBarNofify getProgressBarNofify() {
        return table.getProgressBarNofify();
    }

    public void updateStatus(final VideoFile videoFile) {
        table.getModel().updateStatus(videoFile);
    }

    public void removeVideoFile() {
        table.removeVideoFile();
        updateGUI();
    }

    public void upVideoFile() {
        table.upVideoFile();
    }

    public void downVideoFile() {
        table.downVideoFile();
    }

    public void setProgressInfo(VideoFile videoFile, int value) {
        table.getModel().setProgressInfo(videoFile, value);
    }

    public VideoFile[] getSelectVideoFiles() {
        return table.getSelectVideoFiles();
    }


    public VideoFile[] getAllVideoFiles() {
        return table.getAllVideoFiles();
    }

    public void setSelect(VideoFile videoFile) {
        table.setSelect(videoFile);
    }

    public void changeVideoFileSetting() {
        table.changeVideoFileSetting();
    }

    public void updateStartTime(final VideoFile videoFile, final Date startTime) {
        table.updateStartTime(videoFile, startTime);
    }

    public void updateEndTime(final VideoFile videoFile, final Date endTime) {
        table.updateEndTime(videoFile, endTime);
    }

    public void updatePredictEndTime(final VideoFile videoFile, final Date endTime) {
        table.updatePredictEndTime(videoFile, endTime);
    }

    public void updatePredictStartTime(final VideoFile videoFile, final Date startTime) {
        table.updatePredictStartTime(videoFile, startTime);
    }

    public void setToolbar(final MainToolBar toolbar) {
        table.setToolbar(toolbar);
    }

    public void openSourcePath() {
        table.openSourcePath();
    }

    public void openDestinationPath() {
        table.openDestinationPath();
    }
}
