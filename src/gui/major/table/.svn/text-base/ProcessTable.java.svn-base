package gui.major.table;

import config.properties.DialogProperties;
import config.properties.VideoFileFieldProperties;
import convert.VideoFile;
import convert.util.I_Progress;
import gui.major.MajorPanel;
import gui.major.table.render.*;
import gui.major.videofilesetting.VFS_MainDlg;
import gui.menu.PopMenu;
import gui.toolbar.MainToolBar;
import gui.util.command.Status;
import gui.util.dialog.ModuleDialog;
import gui.util.dialog.OptionPaneDialog;
import log.Trace;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-18
 */
public class ProcessTable extends JTable {


    private ProcessTableModel model;

    public ProcessTableModel getModel() {
        return model;
    }


    private ProcessTableSelectionModel selectionModel;

    public ProcessTableSelectionModel getSelectionModel() {
        return selectionModel;
    }

    private MajorPanel majorPanel;

    public void setToolbar(final MainToolBar toolbar) {
        this.toolbar = toolbar;
    }

    private MainToolBar toolbar = null;


    public ProcessTable(MajorPanel majorPanel) {
        this.majorPanel = majorPanel;
        model = new ProcessTableModel();
        setModel(model);
        selectionModel = new ProcessTableSelectionModel();
        setSelectionModel(selectionModel);
        selectionModel.addListSelectionListener(new ListSelectionHandle());

        setAutoCreateRowSorter(true);
        setFillsViewportHeight(true);

        setCellRender();

        setTransferHandler(new ProcessTableTransferHandler());
        setDragEnabled(true);
        setFillsViewportHeight(true);

        addMouseListener(new ProcessTableMouse(this, new PopMenu()));

        setPreferredScrollableViewportSize(getPreferredSize());

        setHeaderRender();
    }

    @Override
    public void tableChanged(final TableModelEvent tableModelEvent) {
        super.tableChanged(tableModelEvent);
        if (toolbar != null) {
            toolbar.updateButtonEnable(this);
        }
    }

    private void setCellRender() {
        TableCellRenderer progressBarRender = new ProgressBarRender();
        StatusRender statusRender = new StatusRender();
        StringCellRender stringCellRender = new StringCellRender();
        FileNameCellRender fileNameCellRender = new FileNameCellRender();

        setDefaultRenderer(ProgressInfo.class, progressBarRender);
        setDefaultRenderer(Status.class, statusRender);
        setDefaultRenderer(String.class, stringCellRender);
        setDefaultRenderer(File.class, fileNameCellRender);
    }

    private void setHeaderRender() {
        getTableHeader().setDefaultRenderer(new HeaderRender());
    }

    /*
    * JTable uses this method to determine the default renderer/
    * editor for each cell.  If we didn't implement this method,
    * then the last column would contain text ("true"/"false"),
    * rather than a check box.
    */
    public Class getColumnClass(int c) {
        if (c == getModel().getColumnIndexByHeader(
                VideoFileFieldProperties.Key.PROGRESS)) {
            return ProgressInfo.class;
        } else if (c == getModel().getColumnIndexByHeader(
                VideoFileFieldProperties.Key.STATUS)) {
            return Status.class;
        } else if (
                c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.SEQUENCE) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.LENGTH) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.RANGE) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.PROFILE) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.START_TIME) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.END_TIME)
                ) {
            return String.class;
        } else if (
                c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.SOURCE_FILE) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.DEST_FILE) ||
                        c == getModel().getColumnIndexByHeader(VideoFileFieldProperties.Key.SCRIPTION)
                ) {
            return File.class;
        } else {
            return super.getColumnClass(c);
        }
    }

    private class ListSelectionHandle implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if (!listSelectionEvent.getValueIsAdjusting()) {

                if (toolbar != null) {
                    toolbar.updateButtonEnable(ProcessTable.this);
                }

                int row = getSelectedRow();
                if (row == -1) {
                    updateMajorPanel(null);
                    return;
                }
                VideoFile videoFile = getModel().getVideoFileByLine(row);
                updateMajorPanel(videoFile);

            }
        }
    }

    private void updateMajorPanel(VideoFile videoFile) {
        if (majorPanel != null) {
            majorPanel.update(videoFile);
        }
    }

    public void setSelect(VideoFile videoFile) {
        int line = getModel().getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        setSelect(line);
    }

    public VideoFile[] getSelectVideoFiles() {
        ArrayList<VideoFile> videoFiles = new ArrayList<>();
        for (int line : getSelectedRows()) {
            videoFiles.add(model.getVideoFileByLine(line));
        }
        return videoFiles.toArray(new VideoFile[videoFiles.size()]);
    }

    private VideoFile getSelectVideoFile() {
        int row = getSelectedRow();
        if (row == -1) {
            return null;
        }
        return getModel().getVideoFileByLine(row);
    }

    public VideoFile[] getAllVideoFiles() {
        return getModel().getAllVideoFiles();
    }


    public class ProgressBarNofify implements I_Progress {
        @Override
        public void setValue(final VideoFile videoFile, final int value) {
            getModel().setProgressInfo(videoFile, value);
        }
    }

    public void updateStartTime(final VideoFile videoFile, final Date startTime) {
        getModel().updateStartTime(videoFile, startTime);
    }

    public void updateEndTime(final VideoFile videoFile, final Date endTime) {
        getModel().updateEndTime(videoFile, endTime);
    }

    public void updatePredictStartTime(final VideoFile videoFile, final Date startTime) {
        getModel().updatePredictStartTime(videoFile, startTime);
    }

    public void updatePredictEndTime(final VideoFile videoFile, final Date endTime) {
        getModel().updatePredictEndTime(videoFile, endTime);
    }

    public void changeVideoFileSetting() {
        VideoFile[] selectFiles = getSelectVideoFiles();
        VFS_MainDlg dialog = new VFS_MainDlg(selectFiles);
        if (ModuleDialog.showDialog(dialog) == VFS_MainDlg.ReturnValue.OK) {
            getModel().updateVideoFiles(selectFiles);
        }
    }

    public void openInfoPanel() {
        VideoFile file = getSelectVideoFile();
        if (file == null) {
            return;
        }
        majorPanel.openInfoPanel(file);
    }


    public ProgressBarNofify getProgressBarNofify() {
        return progressBarNofify;
    }

    private ProgressBarNofify progressBarNofify = new ProgressBarNofify();

    public void removeVideoFile() {
        VideoFile[] selectFiles = getSelectVideoFiles();
        if (selectFiles.length == 0) {
            return;
        }
        int ret;
        if (selectFiles.length == 1) {
            ret = OptionPaneDialog.showWarningDialog(null,
                    DialogProperties.Key.RemoveSingleVideoFileConfirm, selectFiles[0].toString());
        } else {
            ret = OptionPaneDialog.showWarningDialog(null,
                    DialogProperties.Key.RemoveMultiVideoFilesConfirm,
                    String.format("%d", selectFiles.length));
        }
        if (ret != OptionPaneDialog.YES_OPTION) {
            return;
        }

        for (VideoFile videoFile : selectFiles) {
            removeVideoFile(videoFile);
        }

    }


    private void removeVideoFile(VideoFile videoFile) {
        int line = getModel().getLineByVideoFile(videoFile);
        if (line == -1) {
            Trace.error("VideoFile:", videoFile.toString(), " is not in table");
            return;
        }

        if (videoFile.getStatus() == Status.RUNNING) {
            int ret = OptionPaneDialog.showWarningDialog(null,
                    DialogProperties.Key.RemoveRunningVideoFileConfirm, videoFile.toString());
            if (ret != OptionPaneDialog.YES_OPTION) {
                return;
            }
            majorPanel.stopConverting(videoFile);
        }

        getModel().removeRow(line);

        Trace.debug("ProcessTable.removeVideoFile():",
                "remove line:", line, " for videoFile:", videoFile.toString());

        int lineNumber = getModel().getRowCount();
        if (lineNumber > 0) {
            if (line > 0) {
                setSelect(line - 1);
            } else {
                setSelect(0);
            }
        }
    }

    private void setSelect(int line) {
        Trace.debug("ProcessTable.setSelect():",
                "select line:", line);
        getSelectionModel().setSelectionInterval(line, line);
    }

    public void upVideoFile() {
        int row = getSelectedRow();
        if (row == -1) {
            return;
        }
        VideoFile videoFile = getSelectVideoFile();
        getModel().upVideoFile(videoFile);
        setSelect(row - 1);
    }

    public void downVideoFile() {
        int row = getSelectedRow();
        if (row == -1) {
            return;
        }
        VideoFile videoFile = getModel().getVideoFileByLine(row);
        getModel().downVideoFile(videoFile);
        setSelect(row + 1);
    }

    public boolean selectRowIsTop() {
        int row = getSelectedRow();
        return row != -1 && row == 0;
    }

    public boolean selectRowIsBottom() {
        int row = getSelectedRow();

        return (row != -1) && (row == (getModel().getRowCount() - 1));
    }

    public boolean isEmpty() {
        return getModel().isEmpty();
    }

    private void openFilePath(File file) {
        try {
            Desktop.getDesktop().open(file.getParentFile());
        } catch (IOException e) {
            Trace.error(e);
        }
    }

    public void openSourcePath() {
        VideoFile videoFile = getSelectVideoFile();
        if (videoFile == null)
            return;

        File file = videoFile.getSourceFile();
        openFilePath(file);
    }

    public void openDestinationPath() {
        VideoFile videoFile = getSelectVideoFile();
        if (videoFile == null)
            return;

        File file = videoFile.getDestinFile();
        openFilePath(file);
    }

}
