package gui.major.table;

import config.properties.VideoFileFieldProperties;
import convert.VideoFile;
import gui.util.command.Status;
import gui.util.time.DateUtil;
import gui.util.time.Timex;
import log.Trace;
import xml.StringUtil;

import javax.swing.table.DefaultTableModel;
import java.util.*;

import static config.properties.VideoFileFieldProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-2-22
 * Timex: 上午11:14
 */
public class ProcessTableModel extends DefaultTableModel {

    final static Vector<VideoFileFieldProperties.Key> header = new Vector<>();

    static {
        header.addAll(Arrays.asList(
                SEQUENCE,
                STATUS,
                SOURCE_FILE,
                LENGTH,
                PROGRESS,
                DEST_FILE,
                PROFILE,
                RANGE,
                SCRIPTION,
                START_TIME,
                END_TIME
        ));
    }

    final static int COLUMN_NUMBER = header.size();

    private List<VideoFile> videoFileList;

    public int getSequenceNumber(VideoFile file) {
        return videoFileList.indexOf(file) + 1;
    }

    public void upVideoFile(VideoFile file) {
        int index = videoFileList.indexOf(file);

        if (index == 0) {
            Trace.debug("ProcessTableModel.upVideoFile():",
                    "already reach to the top");
            return;
        }

        changeVideoFileIndex(index, index - 1);
        changeLineValue(index, index - 1);
    }

    public void downVideoFile(VideoFile file) {
        int index = videoFileList.indexOf(file);

        if (index == videoFileList.size() - 1) {
            Trace.debug("ProcessTableModel.upVideoFile():",
                    "already reach to the bottom");
            return;
        }

        changeVideoFileIndex(index, index + 1);
        changeLineValue(index, index + 1);
    }

    private void changeVideoFileIndex(int index1, int index2) {
        VideoFile file1 = videoFileList.get(index1);
        VideoFile file2 = videoFileList.get(index2);

        videoFileList.set(index1, file2);
        videoFileList.set(index2, file1);

        updateVideoFiles(new VideoFile[]{file1, file2});
    }

    public void changeLineValue(int line1, int line2) {
        Vector<Object> row1 = new Vector<>(COLUMN_NUMBER);
        Vector<Object> row2 = new Vector<>(COLUMN_NUMBER);

        for (int i = 0; i < COLUMN_NUMBER; i++) {
            row1.add(getValueAt(line1, i));
            row2.add(getValueAt(line2, i));
        }

        for (int i = 0; i < COLUMN_NUMBER; i++) {
            setValueAt(row1.get(i), line2, i);
            setValueAt(row2.get(i), line1, i);
        }

    }

    public void removeVideoFile(VideoFile file) {
        videoFileList.remove(file);
        Trace.debug("ProcessTableModel.removeVideoFile():", "remove file[", file.toString(), "] from list");
        Trace.debug("ProcessTableModel.removeVideoFile():", "list length:", videoFileList.size());
    }

    public void addVideoFile(VideoFile file) {
        videoFileList.add(file);

        Vector<Object> row = new Vector<>(COLUMN_NUMBER);
        row.add(getColumnIndexByHeader(SEQUENCE), getSequenceNumber(file));
        row.add(getColumnIndexByHeader(STATUS), file.getStatus());
        row.add(getColumnIndexByHeader(SOURCE_FILE), file);
        row.add(getColumnIndexByHeader(LENGTH), Timex.build(file.getLength()));
        row.add(getColumnIndexByHeader(PROGRESS), new ProgressInfo());
        row.add(getColumnIndexByHeader(DEST_FILE), file.getDestinFile());
        row.add(getColumnIndexByHeader(PROFILE), file.getEncodeProfile());
        row.add(getColumnIndexByHeader(RANGE), file.getVideoRange());
        row.add(getColumnIndexByHeader(SCRIPTION), file.getScriptFile());
        row.add(getColumnIndexByHeader(START_TIME), "");
        row.add(getColumnIndexByHeader(END_TIME), "");
        addRow(row);
    }


    public void updateVideoFiles(VideoFile[] files) {
        for (VideoFile file : files) {
            int line = getLineByVideoFile(file);
            if (line == -1) {
                continue;
            }
            setValueAt(getSequenceNumber(file), line, getColumnIndexByHeader(SEQUENCE));
//            setValueAt(file.getStatus(), line, getColumnIndexByHeader(STATUS));
//            setValueAt(file.getSourceFile(), line, getColumnIndexByHeader(SOURCE_FILE));
//            setValueAt(Timex.build(file.getLength()), line, getColumnIndexByHeader(LENGTH));
//            setValueAt(, line, getColumnIndexByHeader(PROGRESS));
            setValueAt(file.getDestinFile(), line, getColumnIndexByHeader(DEST_FILE));
            setValueAt(file.getEncodeProfile(), line, getColumnIndexByHeader(PROFILE));
            setValueAt(file.getVideoRange(), line, getColumnIndexByHeader(RANGE));
            setValueAt(file.getScriptFile(), line, getColumnIndexByHeader(SCRIPTION));
        }
    }

    public ProcessTableModel() {
        setColumnCount(COLUMN_NUMBER);

        videoFileList = new ArrayList<>();
        displayHeader();

    }

    private void displayHeader() {
        Vector<String> displayHeader = new Vector<>();
        for (VideoFileFieldProperties.Key str : header) {
            displayHeader.add(VideoFileFieldProperties.instance().
                    getString(str));
        }
        Trace.debug("Table header:", displayHeader);
        setColumnIdentifiers(displayHeader);
    }

    @Override
    public void removeRow(int row) {
        VideoFile videoFile = getVideoFileByLine(row);
        super.removeRow(row);
        removeVideoFile(videoFile);
    }


    public int getColumnIndexByHeader(VideoFileFieldProperties.Key h) {
        return header.indexOf(h);
    }

//    public void addVideoFiles(VideoFile[] videoFiles) {
//        for (VideoFile videoFile : videoFiles) {
//            addVideoFile(videoFile);
//        }
//    }


    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public VideoFile getVideoFileByLine(int line) {
        return (VideoFile) getValueAt(line, getColumnIndexByHeader(SOURCE_FILE));
    }

    public VideoFile[] getAllVideoFiles() {
        return videoFileList.toArray(new VideoFile[videoFileList.size()]);
    }

    @SuppressWarnings("unchecked")
    public int getLineByVideoFile(VideoFile videoFile) {
        int i = 0;
        for (Object line : getDataVector()) {
            Vector<Object> lineVector;

            lineVector = (Vector<Object>) line;
            if (lineVector == null) {
                return -1;
            }
            VideoFile column1 = (VideoFile) lineVector.
                    get(getColumnIndexByHeader(SOURCE_FILE));
            if (videoFile.equals(column1)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private ProgressInfo getProgressInfo(int line) {
        return (ProgressInfo) getValueAt(line, getColumnIndexByHeader(PROGRESS));
    }

//    private Status getStatus(int line) {
//        return (Status) getValueAt(line, getColumnIndexByHeader(Header.STATUS));
//    }


    public void updateStatus(final VideoFile videoFile) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        Status status = videoFile.getStatus();
        Trace.debug("ProcessTableModel.updateStatus: status update to:", status.toString());

        setValueAt(status,
                line,
                getColumnIndexByHeader(STATUS));
    }

    public void updateStartTime(final VideoFile videoFile, final Date startTime) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        setValueAt(DateUtil.toTime(startTime),
                line,
                getColumnIndexByHeader(START_TIME));
    }

    public void updateEndTime(final VideoFile videoFile, final Date endTime) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        setValueAt(DateUtil.toTime(endTime),
                line,
                getColumnIndexByHeader(END_TIME));
    }

    public void updatePredictStartTime(final VideoFile videoFile, final Date startTime) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        setValueAt(StringUtil.concat(DateUtil.toTime(startTime), " ?"),
                line,
                getColumnIndexByHeader(START_TIME));
    }

    public void updatePredictEndTime(final VideoFile videoFile, final Date endTime) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }
        setValueAt(StringUtil.concat(DateUtil.toTime(endTime), " ?"),
                line,
                getColumnIndexByHeader(END_TIME));
    }

    public void setProgressInfo(VideoFile videoFile, int value) {
        int line = getLineByVideoFile(videoFile);
        if (line == -1) {
            return;
        }

        ProgressInfo progressInfo = getProgressInfo(line);
        if (progressInfo == null) {
            Trace.error("get progressInfo error");
            return;
        }

        progressInfo.setPercentage(value);
        setValueAt(progressInfo,
                line,
                getColumnIndexByHeader(PROGRESS));
    }

    public boolean isEmpty() {
        return videoFileList.isEmpty();
    }


}
