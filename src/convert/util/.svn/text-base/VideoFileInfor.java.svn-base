package convert.util;

import convert.util.info.*;
import gui.util.command.*;
import log.*;

import java.io.*;
import java.util.*;

/**
 * libavformat file format detected.
 * ID_VIDEO_ID=0
 * [lavf] Video stream found, -vid 0
 * ID_AUDIO_ID=1
 * [lavf] Audio stream found, -aid 1
 * VIDEO:  [avc1]  432x240  24bpp  30.000 fps    0.0 kbps ( 0.0 kbyte/s)
 * ID_FILENAME=Modern.Family.215.m4v
 * ID_DEMUXER=lavfpref
 * ID_VIDEO_FORMAT=avc1
 * ID_VIDEO_BITRATE=0
 * ID_VIDEO_WIDTH=432
 * ID_VIDEO_HEIGHT=240
 * ID_VIDEO_FPS=30.000
 * ID_VIDEO_ASPECT=1.7778
 * ID_AUDIO_FORMAT=255
 * ID_AUDIO_BITRATE=0
 * ID_AUDIO_RATE=48000
 * ID_AUDIO_NCH=2
 * ID_LENGTH=1266.45
 * ID_SEEKABLE=1
 * ID_CHAPTERS=0
 * ==========================================================================
 * Opening video decoder: [ffmpeg] FFmpeg's libavcodec codec family
 * Selected video codec: [ffh264] vfm: ffmpeg (FFmpeg H.264)
 * ==========================================================================
 * ID_VIDEO_CODEC=ffh264
 * ==========================================================================
 * Opening audio decoder: [faad] AAC (MPEG2/4 Advanced Audio Coding)
 * FAAD: compressed input bitrate missing, assuming 128kbit/s!
 * AUDIO: 48000 Hz, 2 ch, s16le, 128.0 kbit/8.33% (ratio: 16000->192000)
 * ID_AUDIO_BITRATE=128000
 * ID_AUDIO_RATE=48000
 * ID_AUDIO_NCH=2
 * Selected audio codec: [faad] afm: faad (FAAD AAC (MPEG-2/MPEG-4 Audio))
 * ==========================================================================
 * AO: [dsound] 48000Hz 2ch s16le (2 bytes per sample)
 * ID_AUDIO_CODEC=faad
 * Starting playback...
 * <p/>
 * <p/>
 * Exiting... (End of file)
 * ID_EXIT=EOF
 */
public class VideoFileInfor {
    private final File videoFile;

    public static VideoFileInfor build(File videoFile) {
        VideoFileInfor videoFileInfor;

        if (VideoFileCache.instanceOfInfo().contain(videoFile)) {
            videoFileInfor = VideoFileCache.instanceOfInfo().get(videoFile);
        } else {
            videoFileInfor = new VideoFileInfor(videoFile);
            VideoFileCache.instanceOfInfo().add(videoFile, videoFileInfor);
        }
        return videoFileInfor;
    }

    public String[] getRawInforStringArray() {
        if (rawInforStringArray == null) {
            rawInforStringArray = Command.instance().runSyn(
                CommandInfo.build(getPath(), buildArg(), null)).
                split("\n");
            Trace.debug("raw String is:");
            for (String s : rawInforStringArray) {
                Trace.debug(s);
            }
        }
        return rawInforStringArray;
    }

    private String[] rawInforStringArray;

    private HashMap<String, A_VideoInfo> items;

    public String getItemStringValue(String key) {
        A_VideoInfo item = items.get(key);
        if (item != null) {
            return item.getStringValue();
        }
        return "";
    }

    public int getItemIntValue(String key) {
        A_VideoInfo item = items.get(key);
        if (item != null) {
            return item.getIntValue();
        }
        return -1;
    }

    public double getItemDoubleValue(String key) {
        A_VideoInfo item = items.get(key);
        if (item != null) {
            return item.getDoubleValue();
        }
        return -1.0;
    }

    public static final String LENGTH = "length";
    public static final String FORMAT = "format";
    public static final String VIDEO_BITRATE = "video bitrate";
    public static final String AUDIO_BITRATE = "audio bitrate";
    public static final String VIDEO_CODEC = "video codec";
    public static final String AUDIO_CODEC = "audio codec";

    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String FPS = "fps";

    public static final String AUDIO_CHANNEL = "audio channel";

    private VideoFileInfor(File videoFile) {
        this.videoFile = videoFile;
        rawInforStringArray = null;
        items = new HashMap<>();

        items.put(LENGTH, new VI_Length(this));
        items.put(FORMAT, new VI_Format(this));
        items.put(VIDEO_BITRATE, new VI_VideoBitrate(this));
        items.put(AUDIO_BITRATE, new VI_AudioBitrate(this));
        items.put(VIDEO_CODEC, new VI_VideoCodec(this));
        items.put(AUDIO_CODEC, new VI_AudioCodec(this));
        items.put(WIDTH, new VI_Width(this));
        items.put(HEIGHT, new VI_Height(this));
        items.put(FPS, new VI_Fps(this));
        items.put(AUDIO_CHANNEL, new VI_AudioChannel(this));

    }


    private List<String> buildArg() {
        final String arg = "mplayer.exe -frames 0 -identify";
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arg.split("\\s")));

        list.add(videoFile.getPath());
        return list;
    }

    private File getPath() {
        return videoFile.getParentFile();

    }
}
