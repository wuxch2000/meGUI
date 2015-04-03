package convert.util;

import config.ConvertJob;
import config.encode.PlainProfile;
import convert.VideoFile;
import gui.MainPanel;
import gui.major.table.TablePanel;
import gui.util.command.*;
import gui.util.time.VideoRange;
import log.Trace;
import xml.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static gui.util.command.Status.*;

/**
 * User: 吴晓春
 * Date: 11-3-11
 * Timex: 下午4:03
 */
public class VideoConvert implements I_ParseString, I_CommandStatusUpdate {
    private VideoFile videoFile = null;
    private I_Progress progressNotify = null;

    protected VideoConvert(final VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public static VideoConvert build(final VideoFile videoFile) {
        return new VideoConvert(videoFile);
    }

    private CommandInfo commandInfo = null;

    public void exec() {
        doExec(buildArg());
    }

    private void doExec(List<String> arg) {
        Trace.debug("VideoConvert.exec():" + arg);
        if (commandInfo != null &&
                commandInfo.getStatus() == RUNNING) {
            Trace.debug("there's command running already");
            return;
        }
        commandInfo = CommandInfo.build(
                videoFile.getSourceFile().getParentFile(),
                arg,
                this,
                this);
        Command.instance().runAsyn(commandInfo);
    }


    public void stop() {
        Trace.debug("VideoConvert.stop()");
        if (progressNotify != null) {
            progressNotify.setValue(videoFile, 0);
        }
        if (commandInfo != null) {
            Command.instance().stopAsyn(commandInfo);
        }
    }

    private List<String> buildArg() {
        final String arg = "mencoder.exe ";
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arg.split("\\s")));
        list.add(videoFile.getSourceFile().getPath());

        if (videoFile.getScriptFile() != null) {
            list.add("-sub");
            list.add(videoFile.getScriptFile().getPath());
        }

        VideoRange range = videoFile.getVideoRange();
        if (!range.rangeIsTotal()) {
            list.add("-ss");
            list.add(StringUtil.format(range.getStartSecond()));

            list.add("-endpos");
            list.add(StringUtil.format(range.getTimeLength()));

        }

        if (videoFile.getDestinFile() != null) {
            list.add("-o");
            list.add(videoFile.getDestinFile().getPath());
        }

        PlainProfile plainProfile = PlainProfile.build(videoFile.getEncodeProfile());
        File plainProfileFile = plainProfile.getPlainProfile();
        if (plainProfileFile != null) {
            list.add("-include");
            list.add(plainProfileFile.getPath());
        }
        return list;
    }

    private int completeLength = -1;
    private int totalLength = -1;

    public void setProgressNotify(I_Progress progressNotify) {
        this.progressNotify = progressNotify;
    }

    @Override
    public void parseString(final String string) {
//        Trace.debug("convert:", string);
        int newCompleteLength = getCompleteLength(string);
        if (totalLength == -1) {
            if (videoFile.getVideoRange().rangeIsTotal()) {
                totalLength = videoFile.getLength();
            } else {
                totalLength = videoFile.getVideoRange().getTimeLength();
            }
        }

        if (newCompleteLength != -1 && newCompleteLength != completeLength) {
            completeLength = newCompleteLength;
            int percentage = completeLength * 100 / totalLength;
            Trace.debug("completeLength:", completeLength,
                    " percentage:", percentage);
            if (progressNotify != null) {
                progressNotify.setValue(videoFile, percentage);
                updatePredictEndTime(percentage);
            }
        }
    }

    // Pos:  50.5s   1214f ( 4%) 12.64fps Trem:  33min  76mb  A-V:0.028 [454:128]
    static private Pattern patternPencentOfTotalVidel; // get 4%

    static {
        patternPencentOfTotalVidel = Pattern.compile(".*Pos:.*\\(\\s*(\\d+)%\\).*$");
    }


    static private Pattern patternCompleteLength; // get 50.5

    static {
        patternCompleteLength = Pattern.compile(".*Pos:\\s*(\\d+\\.*\\d*)s.*$");
    }


    public int getPencentOfTotalVideo(String s) {
        String match = getStringFromOutput(s, patternPencentOfTotalVidel, 1);
        if (match != null) {
            Trace.debug("VideoConvert.getPencentOfTotalVideo():",
                    "matched:", match);
            return new Integer(match);
        }

        return -1;
    }

    public int getCompleteLength(String s) {
        String match = getStringFromOutput(s, patternCompleteLength, 1);
        if (match != null) {
            Trace.debug("VideoConvert.getCompleteLength():",
                    "matched:", match);
            Double percent = new Double(match);

            return percent.intValue();
        }
        return -1;
    }

    public String getStringFromOutput(String output, Pattern pattern, int group) {
        Matcher m = pattern.matcher(output);
        if (m.matches()) {
            return (m.group(group));
        } else {
            Trace.debug("VideoConvert.getStringFromOutput():",
                    "match failed!",
                    " String:", output,
                    " Regex:", pattern.toString());
        }
        return null;
    }


    private void updatePredictEndTime(int percentage) {
        if (percentage <= 0 || percentage >= 100) {
            return;
        }

        long startTimeMillis = commandInfo.getStartTime().getTime();
        long now = System.currentTimeMillis();

        long predictEndTimeMills = (now - startTimeMillis) * 100 / percentage + startTimeMillis;
        Date predictEndTime = new Date(predictEndTimeMills);

        if (videoFile.getStatus() == RUNNING) {
            MainPanel.instance().getMajorPanel().
                    getTablePanel().updatePredictEndTime(videoFile, predictEndTime);
            VideoConvertInstances.instance().updateAllStartEndTime(this,
                    calculateRate(startTimeMillis, now, percentage), predictEndTime);
        }
    }

    // rate means: how many mill-second needed to covert 1 second video file.
    private int calculateRate(long startTimeMills, long now, int percentage) {
        long processedSecondOfVideofile = percentage * videoFile.getLength() / 100;
        return (int) ((now - startTimeMills) / processedSecondOfVideofile);
    }

    public Date updatePredictStartEndTime(int rate, Date predictStartTime) {
        if (videoFile.getStatus() != Status.WAITING)
            return null;
        TablePanel tablePanel = MainPanel.instance().getMajorPanel().
                getTablePanel();
        long predictEndTimeMills = predictStartTime.getTime() + videoFile.getLength() * rate;
        Date predictEndTime = new Date(predictEndTimeMills);
        tablePanel.updatePredictStartTime(videoFile, predictStartTime);
        tablePanel.updatePredictEndTime(videoFile, predictEndTime);
        return predictEndTime;
    }

    @Override
    public void commandStatusUpdate(final Status status) {
        Status preStatus = videoFile.getStatus();
        Trace.debug("VideoConvert:",
                "commandStatusUpdate:status:", status);
        videoFile.setStatus(status);
        TablePanel table = MainPanel.instance().getMajorPanel().
                getTablePanel();

        switch (status) {
            case IDLE:
                break;
            case WAITING:
                break;
            case RUNNING:
                if (preStatus == IDLE ||
                        preStatus == WAITING) {
                    table.updateStartTime(videoFile, commandInfo.getStartTime());
                }
                break;
            case DONE:
                writeLog(status);
                if (progressNotify != null) {
                    progressNotify.setValue(videoFile, 100);
                }
                if (preStatus == RUNNING) {
                    table.updateEndTime(videoFile, commandInfo.getEndTime());
                }
                break;
            case INTERRUPPTED:
                writeLog(status);
                break;
            default:
                break;
        }
        table.updateStatus(videoFile);
    }

    private void writeLog(final Status status) {
        ConvertJob convertJob = ConvertJob.build(
                videoFile,
                commandInfo,
                status
        );

        convertJob.writeToLog();
    }
}
