/**
 *
 */
package junit.convert.util;

import junit.stub.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author 吴晓春
 */
public class JUT_Convert {

    static private StubVideoFile videoFile;
    static private StubVideoConvert convert;

    private static final File VIDEO_FILE =
        new File("D:\\JavaCode\\meGUI\\examples\\Modern.Family.217.avi");

    @BeforeClass
    public static void setUp() {
        videoFile = StubVideoFile.build(VIDEO_FILE);
        convert = StubVideoConvert.build(videoFile);
        videoFile.initVideoFile();
    }

    @Test
    public void test_getPencentOfTotalVideo() {
        final String OUTPUT_STRING =
            "Pos:  50000.5s   1214f ( 4%) 12.64fps Trem:  33min  76mb  A-V:0.028 [454:128]";
        int i = convert.getPencentOfTotalVideo(OUTPUT_STRING);
        assertTrue(i == 4);
    }


    @Test
    public void test_getPencent() {
        final String OUTPUT_STRING =
            "Pos:50000.5s   1214f ( 4%) 12.64fps Trem:  33min  76mb  A-V:0.028 [454:128]";
        int i = convert.getCompleteLength(OUTPUT_STRING);
        assertTrue(i == 50000);
//        int percentage = completeLength * 100 / totalLength;
    }

    @Test
    public void test_PencentCalc() {
        final String OUTPUT_STRING =
            "Pos:  2500s   1214f ( 4%) 12.64fps Trem:  33min  76mb  A-V:0.028 [454:128]";

        videoFile.setLength(2535);

        convert.parseString(OUTPUT_STRING);
    }

    @Ignore
    @Test
    public void convert() {
        convert.exec();
    }

}
