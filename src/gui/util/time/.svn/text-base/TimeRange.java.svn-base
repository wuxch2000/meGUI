package gui.util.time;

import xml.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 上午9:17
 */

public class TimeRange {

    private Pair<Timex, Timex> range;

    protected TimeRange(int startSecond, int endSecond) {
        super();
        range = new Pair<Timex, Timex>(Timex.build(startSecond),
            Timex.build(endSecond));
    }

    public static TimeRange build(int startSecond, int endSecond) {
        return new TimeRange(startSecond, endSecond);
    }

    public Timex getStart() {
        return range.getFirst();
    }

    public Timex getEnd() {
        return range.getSecond();
    }

    public int getTimeLength() {
        return  getEndSecond() - getStartSecond();
    }

    public int getStartSecond() {
        return getStart().getSecond();
    }

    public int getEndSecond() {
        return getEnd().getSecond();
    }

    public void setStartSecond(int second) {
        getStart().setSecond(second);
    }

    public void setEndSecond(int second) {
        getEnd().setSecond(second);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getStart().toString())
            .append(" -- ")
            .append(getEnd().toString());
        return builder.toString();
    }
}
