package gui.util;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: 吴晓春
 * Date: 11-12-26
 * Time: 下午10:29
 */
public class VideoFileFilter {
    private final static String[] video_ext_string = {"avi",
            "mpeg",
            "m4v",
            "mp4",
            "rmvb"};
    private final static Set<String> video_ext = new HashSet<>();

    static {
        Collections.addAll(video_ext, video_ext_string);
    }

    public static boolean isVideoFile(File file) {
        return video_ext.contains(getExtension(file).toLowerCase());
    }

    public static String[] toArray() {
        return video_ext.toArray(new String[video_ext.size()]);
    }

    /*
    * Get the extension of a file.
    */
    private static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

}
