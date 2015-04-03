package config;

import convert.VideoFile;
import convert.util.VideoFileInfor;
import gui.util.command.*;
import gui.util.time.*;
import log.*;
import org.w3c.dom.*;
import xml.StringUtil;
import xml.domutil.*;
import xml.domutil.chooser.*;

/**
 * User: 吴晓春
 * Date: 11-3-22
 * Time: 上午10:09
 */
public class ConvertJob {

    private final Status status;
    private final VideoFile videoFile;
    private final CommandInfo commandInfo;

    private ConvertJob(VideoFile videoFile, CommandInfo commandInfo, Status status) {
        this.videoFile = videoFile;
        this.status = status;
        this.commandInfo = commandInfo;
    }


    public static ConvertJob build(final VideoFile videoFile,
                                   final CommandInfo commandInfo,
                                   final Status status) {
        return new ConvertJob(videoFile, commandInfo, status);
    }

    private static final String BASE_ELEMENT = "convert-log";
    private static final String JOB_ELEMENT = "job";

    public void writeToLog() {
        Trace.debug("ConvertJob:", "write log");

        Document dom = ConvertLog.instance().getDom();

        try {
            Element baseElement = DomUtil.getFistChildElement(
                    DomUtil.getRootElement(dom),
                    ChooseElementByName.build(BASE_ELEMENT));
            Element jobElement = DomUtil.newElementWithInsert(
                    dom, baseElement, JOB_ELEMENT);

            writeField(dom, jobElement,
                    "start-time", DateUtil.toDateTimeWithMs(commandInfo.getStartTime()));
            writeField(dom, jobElement,
                    "end-time", DateUtil.toDateTimeWithMs(commandInfo.getEndTime()));
            writeField(dom, jobElement,
                    "source-file", videoFile.getSourceFile().getPath());


            writeSourceFileInfo(dom, jobElement);


            writeField(dom, jobElement,
                    "destination-file", videoFile.getDestinFile().getPath());
            writeField(dom, jobElement,
                    "start-pos", videoFile.getVideoRange().getStart().toString());
            writeField(dom, jobElement,
                    "end-pos", videoFile.getVideoRange().getEnd().toString());

            if (videoFile.getScriptFile() == null) {
                writeField(dom, jobElement,
                        "script-file", "");
            } else {
                writeField(dom, jobElement,
                        "script-file", videoFile.getScriptFile().getPath());
            }
            writeField(dom, jobElement,
                    "profile", videoFile.getEncodeProfile().toString());


            writeField(dom, jobElement,
                    "status", status.toString());

            ConvertLog.instance().write(dom);
        } catch (Exception e) {
            Trace.error(e);
        }
    }

    private void writeSourceFileInfo(Document dom, Element jobElement) throws Exception {

        Element element = newElement(dom, jobElement, "source-file-info");


        writeSourceFileInfoField(dom, element, VideoFileInfor.LENGTH);
        writeSourceFileInfoField(dom, element, VideoFileInfor.FORMAT);
        writeSourceFileInfoField(dom, element, VideoFileInfor.VIDEO_BITRATE);
        writeSourceFileInfoField(dom, element, VideoFileInfor.AUDIO_BITRATE);
        writeSourceFileInfoField(dom, element, VideoFileInfor.VIDEO_CODEC);
        writeSourceFileInfoField(dom, element, VideoFileInfor.AUDIO_CHANNEL);
        writeSourceFileInfoField(dom, element, VideoFileInfor.FPS);
        writeSourceFileInfoField(dom, element, VideoFileInfor.WIDTH);
        writeSourceFileInfoField(dom, element, VideoFileInfor.HEIGHT);

    }

    private void writeSourceFileInfoField(Document dom, Element currentElement, String field) throws Exception {

        VideoFileInfor info = videoFile.getInfo();
        if (info == null) {
            return;
        }
        writeField(dom, currentElement,
                StringUtil.replaceSpace(field, '-'), info.getItemStringValue(field));
    }

    private void writeField(Document dom,
                            Element parentElement,
                            String tag,
                            String value) throws Exception {
        Element element = newElement(
                dom, parentElement, tag);
        element.setTextContent(value);
    }

    private Element newElement(Document dom,
                               Element parentElement,
                               String tag) throws Exception {
        return DomUtil.newElementWithAppend(
                dom, parentElement, tag);
    }
}
