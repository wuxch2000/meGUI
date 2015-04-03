package gui.util.time;

import config.properties.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 上午8:52
 */
public class VideoRange extends TimeRange {

//    private static final String TOTAL = "TOTAL";

    private int videoLength;

    public static VideoRange build(final int videoLength) {
        return new VideoRange(videoLength);
    }


    private VideoRange(final int videoLength) {
        super(0,videoLength);
        this.videoLength = videoLength;
    }

    public void setRangeToTotal() {
        setStartSecond(0);
        setEndSecond(videoLength);
    }

    public boolean rangeIsTotal() {
        return getStartSecond() == 0 &&
               getEndSecond() == videoLength;
    }

    @Override
    public VideoRange clone() {
        return VideoRange.build(videoLength);
    }

    @Override
    public String toString() {
        if (rangeIsTotal()) {
            return VideoFileFieldProperties.instance().
                getString(VideoFileFieldProperties.Key.TIME_RANGE_TOTAL);
        } else {
            return super.toString();
        }

    }
}
