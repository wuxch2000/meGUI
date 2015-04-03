package gui.major.videofilesetting.timerange;

import gui.util.time.*;

import javax.swing.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 上午9:55
 */
public class RangeSlider extends JSlider {
    public static RangeSlider build(final TimeRange range, Timex value) {
        return new RangeSlider(JSlider.HORIZONTAL,
            range.getStartSecond(),
            range.getEndSecond(),
            value.getSecond());
    }

    private static final int LABEL_NUMBER = 3;
    private static final int TRACK_NUMBER = 10;

    private RangeSlider(final int orientation,
                           final int min,
                           final int max,
                           final int value) {
        super(orientation, min, max, value);

        setLable();

    }

    @Override
    public int getValue() {
        return super.getValue();    //To change body of overridden methods use File | Settings | File Templates.
    }

    private void setLable() {
        setPaintLabels(true);
        setPaintTicks(true);
        setMajorTickSpacing(super.getMaximum() / (LABEL_NUMBER - 1));
        setMinorTickSpacing(super.getMaximum() / ((LABEL_NUMBER - 1) * TRACK_NUMBER));

        Hashtable<Integer, JLabel> labelTable;
        labelTable = new Hashtable<Integer, JLabel>();
        for (int i = 0; i < LABEL_NUMBER; i++) {
            int second = i * (getMaximum() / (LABEL_NUMBER - 1));
            Timex time = Timex.build(second);

            labelTable.put(second,new JLabel(time.toString()));
        }

        setLabelTable(labelTable);

    }


}
