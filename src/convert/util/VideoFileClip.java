package convert.util;

import config.*;
import gui.util.*;
import gui.util.command.*;
import log.*;
import xml.*;

import java.io.*;
import java.util.*;


// mplayer -nosound -vo jpeg -ss 60 -sstep 60 -frames 10 Greys.Anatomy.716.m4v

public class VideoFileClip {

    private static final int CLIP_NUMBER = 10;
    private static final int CLIP_START_TIME = 60; // start from 60 seconds.
    private final File videoFile;

    public static VideoFileClip build(File videoFile, int length) {
        VideoFileClip videoFileClip;

        if (VideoFileCache.instanceOfClip().contain(videoFile)) {
            videoFileClip = VideoFileCache.instanceOfClip().get(videoFile);
        } else {
            videoFileClip = new VideoFileClip(videoFile,length);
            VideoFileCache.instanceOfClip().add(videoFile, videoFileClip);
        }
        return videoFileClip;
    }

    private int length;

    private VideoFileClip(File videoFile, int length) {
        this.videoFile = videoFile;
        this.length = length;
        generateClip();
    }

    public File[] getClipFiles() {
        File imageDir = getImageDir();
        return FileUtil.getFilesByExt(imageDir, "jpg");
    }

    private int getStep() {
        if (length <= (CLIP_START_TIME + CLIP_NUMBER)) {
            return 1;
        }
        int validlength = length - 2 * CLIP_START_TIME;

        return validlength / CLIP_NUMBER;
    }

    private List<String> buildArg() {
        String arg =
            StringUtil.concat("mplayer.exe -nosound -vo jpeg",
                String.format(" -ss %d", CLIP_START_TIME),
                String.format(" -sstep %d", getStep()),
                String.format(" -frames %d", CLIP_NUMBER),
                " "
            );
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arg.split("\\s")));

        list.add(videoFile.getPath());
        return list;
    }

    private File getExecPath() {
        File execPath = getImageDir();
        if (execPath.isDirectory() && execPath.exists()) {
            if (!execPath.delete()) {
                Trace.error("delete execPath error");
            }
        }
        if (!execPath.mkdir()) {
            Trace.error("mkdir execPath error");
        }
        return execPath;
    }

    private File getImageDir() {
        return new File(Config.instance().getVideoTempPath(), videoFile.getName());

    }

    private void generateClip() {
        Command.instance().runSyn(CommandInfo.build(getExecPath(), buildArg()));
    }
}
