package gui.util.time;

import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 上午10:26
 */
public class Timex extends Time {

    public static Timex build(int second) {
        return new Timex(second);
    }

    public static Timex build(Date date) {
        return new Timex(date);
    }

    public int compareTo(Timex o) {
        if (getSecond() < o.getSecond()) {
            return -1;
        } else if (getSecond() > o.getSecond()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setSecond(int second) {
        setTime(secondToMiliSecond(second));
    }

    public void increase(int second) {
        setSecond(getSecond() + second);
    }

    public void decrease(int second) {
        int newSecond = getSecond() - second;
        if (newSecond < 0) {
            return;
        }

        setSecond(newSecond);
    }

    static public long secondToMiliSecond(int second) {
        return ((long) second) * 1000;
    }

    static public int miliSecondToSecond(long miliSecond) {
        return (int) (miliSecond / 1000);
    }

    static private DateFormat df = null;

    static public TimeZone timeZone = TimeZone.getTimeZone(("GMT-0"));

    static public Format getFormat() {
        if (df == null) {
            df = DateFormat.getTimeInstance();
            df.setTimeZone(timeZone);
        }
        return df;
    }

    private Timex(int second) {
        super(secondToMiliSecond(second));
    }

    private Timex(Date date) {
        super(date.getTime());
    }

    public int getSecond() {
        return miliSecondToSecond(super.getTime());
    }

    @Override
    public String toString() {
        return getFormat().format(this);
    }
}
