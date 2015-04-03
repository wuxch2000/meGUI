/**
 *
 */
package junit.convert.util;

import convert.util.*;
import org.junit.*;

import java.io.*;

import static convert.util.VideoFileInfor.*;
import static convert.util.VideoFileInfor.AUDIO_CHANNEL;
import static org.junit.Assert.*;

/**
 * @author 吴晓春
 */
public class JUnitTestVideoFileInfor {

    static private VideoFileInfor videoFileInfor;

    private static final File VIDEO_FILE =
        new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi");

    @BeforeClass
    public static void setUp() {
        if (videoFileInfor == null) {
            videoFileInfor = build(VIDEO_FILE);
        }
    }

    private static final int LENGTH = 1271;

    @Test
    public void getVideoInfoLength() {

        int length = videoFileInfor.getItemIntValue(VideoFileInfor.LENGTH);
//        System.out.println("length:" + length);
        assertTrue(length == LENGTH);
    }

    private static final String FORMAT = "XVID";

    @Test
    public void getVideoInfoFormat() {

        String result = videoFileInfor.getItemStringValue(VideoFileInfor.FORMAT);
//        System.out.println("result:" + result);
        assertTrue(result.equals(FORMAT));
    }

    private static final int VIDEO_BITRATE = 1005088;
    private static final String VIDEO_BITRATE_STRING = "1.005 mbps";

    @Test
    public void getVideoInfoVideoBitrate() {

        String result = videoFileInfor.getItemStringValue(VideoFileInfor.VIDEO_BITRATE);
        int result_int = videoFileInfor.getItemIntValue(VideoFileInfor.VIDEO_BITRATE);
        System.out.println("result:" + result);
        assertTrue(result_int == VIDEO_BITRATE);
        assertTrue(result.equals(VIDEO_BITRATE_STRING));
    }

    private static final int AUDIO_BITRATE = 135672;
    private static final String AUDIO_BITRATE_STRING = "135.672 kbps";

    @Test
    public void getVideoInfoAudioBitrate() {

        String result = videoFileInfor.getItemStringValue(VideoFileInfor.AUDIO_BITRATE);
        int result_int = videoFileInfor.getItemIntValue(VideoFileInfor.AUDIO_BITRATE);
        System.out.println("result:" + result);
        assertTrue(result_int == AUDIO_BITRATE);
        assertTrue(result.equals(AUDIO_BITRATE_STRING));
    }


    private static final int WIDTH = 624;

    @Test
    public void getVideoInfoWidth() {

        int result = videoFileInfor.getItemIntValue(VideoFileInfor.WIDTH);
        System.out.println("WIDTH:" + result);
        assertTrue(result == WIDTH);
    }

    private static final int HEIGHT = 352;

    @Test
    public void getVideoInfoHeight() {

        int result = videoFileInfor.getItemIntValue(VideoFileInfor.HEIGHT);
        System.out.println("HEIGHT:" + result);
        assertTrue(result == HEIGHT);
    }


    private static final double FPS = 23.976;

    @Test
    public void getVideoInfoFps() {

        double result = videoFileInfor.getItemDoubleValue(VideoFileInfor.FPS);
        System.out.println("FPS:" + result);
        assertTrue(result == FPS);
    }

    private static final String AUDIOCODEC = "mp3";

    @Test
    public void getVideoInfoAudiocodec() {

        String result = videoFileInfor.getItemStringValue(AUDIO_CODEC);
        System.out.println("AUDIO_CODEC:" + result);
        assertTrue(result.equals(AUDIOCODEC));
    }

    private static final String VIDEOCODEC = "ffodivx";

    @Test
    public void getVideoInfoVideocodec() {

        String result = videoFileInfor.getItemStringValue(VIDEO_CODEC);
        System.out.println("VIDEO_CODEC:" + result);
        assertTrue(result.equals(VIDEOCODEC));
    }

    private static final int AUDIOCHANNEL = 2;

    @Test
    public void getVideoInfoAudiochannel() {

        int result = videoFileInfor.getItemIntValue(AUDIO_CHANNEL);
        System.out.println("AUDIO_CHANNEL:" + result);
        assertTrue(result == AUDIOCHANNEL);
    }


    @Ignore
//    @Test
    public void getVideoClip() {

        int length = videoFileInfor.getItemIntValue(VideoFileInfor.LENGTH);

        VideoFileClip clip = VideoFileClip.build(VIDEO_FILE, length);
        File[] imageFiles = clip.getClipFiles();
        for (File file : imageFiles) {
            System.out.println("imageFiles:" + file);
        }

    }


}
