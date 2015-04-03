package gui.major.videofilesetting.dialog.change_dest_name;

import log.*;
import xml.*;

import java.text.*;
import java.util.regex.*;

/**
 * User: 吴晓春
 * Date: 11-3-30
 * Time: 上午8:45
 */
public class ChangeDestNameUtil {


    //"Modern.Family.S02E07.xvid.avi"

    static private Pattern pattern;

    static {
//        pattern = Pattern.compile(".*Pos:\\s*(\\d+\\.*\\d*)s.*$");
        pattern = Pattern.compile(StringUtil.concat(
            "(.*)\\.+",
            "[sS](\\d+)",
            "[eE](\\d+)",
            ".*$"
        ));
    }

    public static String getRecommentString(String oldString) {
        Matcher m = pattern.matcher(oldString);
        if (!m.matches()) {
            Trace.debug("ChangeDestNameUtil.getRecommentString():",
                "match failed");
            return oldString;
        }
        String name = m.group(1);
        Integer season = new Integer(m.group(2));
        Integer episode = new Integer(m.group(3));

        Trace.debug("ChangeDestNameUtil.getRecommentString():",
            "match sucessed." +
            " name:", name,
            " season:", season,
            " episode:", episode);

        NumberFormat seasonFormat = NumberFormat.getNumberInstance();
        seasonFormat.setGroupingUsed(false);
        seasonFormat.setMaximumIntegerDigits(2);
        seasonFormat.setMinimumFractionDigits(0);

        NumberFormat episodeFormat = NumberFormat.getNumberInstance();
        episodeFormat.setGroupingUsed(false);
        episodeFormat.setMaximumIntegerDigits(2);
        episodeFormat.setMinimumIntegerDigits(2);

        return StringUtil.concat(name, ".",
            seasonFormat.format(season),
            episodeFormat.format(episode),
            ".m4v");

    }
}
