package config.properties;

import config.*;

import java.util.*;

import static java.lang.String.*;

/**
 * User: 吴晓春
 * Date: 11-3-26
 * Time: 下午3:33
 */
public class VideoFileFieldProperties {

    public enum Key {

        SEQUENCE("SEQUENCE"),
        STATUS("STATUS"),
        SOURCE_FILE("SOURCE"),
        LENGTH("LENGTH"),
        PROGRESS("PROGRESS"),
        DEST_FILE("DEST"),
        PROFILE("PROFILE"),
        RANGE("TIME_RANGE"),
        SCRIPTION("SCRIPTION"),
        START_TIME("START_TIME"),
        END_TIME("END_TIME"),
//        INVALID("INVALID"),

        DEST_DIR("DEST_DIR"),
        DEST_NAME("DEST_NAME"),
        NO_SELECTION("NO_SELECTION"),

        OK("OK"),
        Cancel("Cancel"),
//        Open("Open"),
//        Warning("Warning"),
//        Error("Error"),
//        Infor("Infor"),
//        Question("Question"),
//
//        ChangeName("ChangeName"),
//        Normalize("Normalize"),
//        NormalizeAll("NormalizeAll"),
//
//        RemoveSingleVideoFileConfirm("RemoveSingleVideoFileConfirm"),
//        RemoveMultiVideoFilesConfirm("RemoveMultiVideoFilesConfirm"),
//        RemoveRunningVideoFileConfirm("RemoveRunningVideoFileConfirm"),
//
//        ChangeNamePrompt("ChangeNamePrompt"),
//
//        Processing("Processing"),
        NO_SCRIPT("NO_SCRIPT"),
        TIME_RANGE_TOTAL("TIME_RANGE_TOTAL"),

        ConvertOptionsSetting("ConvertOptionsSetting"),
        DupFile("DupFile")
        ;

        private final String str;

        public String value() {
            return str;
        }

        Key(final String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }

    }


    private static VideoFileFieldProperties videoFileFieldProperties = null;

    public static VideoFileFieldProperties instance() {
        if (videoFileFieldProperties == null) {
            videoFileFieldProperties = new VideoFileFieldProperties();
//            Font font = LocalConfig.instance().getLocalFont();
        }
        return videoFileFieldProperties;
    }




    private ResourceBundle getBundle() {
        return ResourceBundle.getBundle("properties.VideoFileField",
            LocalConfig.instance().getLocal());
    }

    private String getString(String str) {
        return getBundle().getString(str);
    }

    public String getString(Key key) {
        return getString(key.toString());
    }

    public String getString(Key key, String additionalStr) {
        return format(getString(key), additionalStr);
    }
}


