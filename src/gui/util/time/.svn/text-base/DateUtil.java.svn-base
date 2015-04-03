package gui.util.time;

import java.text.*;
import java.util.*;

public final class DateUtil {
    public static String toString(Date date) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dataFormat.format(date);
    }

    public static String toDateTimeWithMs(Date date) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
        return dataFormat.format(date);
    }

    public static String toDateTime(Date date) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dataFormat.format(date);
    }

    public static String toTimeWithNS(Date date) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss(.SSS)");
        return dataFormat.format(date);
    }

    public static String toTime(Date date) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
        return dataFormat.format(date);
    }
}
