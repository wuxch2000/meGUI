package gui.major.videofilesetting.timerange;

import config.*;
import config.properties.*;
import gui.util.layout.*;
import gui.util.time.*;
import gui.util.time.spinner.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-17
 * Timex: 下午2:26
 */
public class TimeRangeSetting extends JPanel {
    static final private int gap = 5;
    static final private Insets insets = new Insets(gap, gap, gap, gap);

    private RangeSlider sliderBegin;
    private TimexSpinner spinnerBegin;
    private RangeSlider sliderEnd;
    private TimexSpinner spinnerEnd;
    private JLabel beginLabel;
    private JLabel endLabel;

    private JCheckBox totalLength;

    public VideoRange getVideoRange() {
        if (totalLength.isSelected()) {
            videoRange.setRangeToTotal();
        } else {
            videoRange.setStartSecond(sliderBegin.getValue());
            videoRange.setEndSecond(sliderEnd.getValue());
        }

        return videoRange;
    }

    private VideoRange videoRange;

    public TimeRangeSetting(final String fileName,
                            VideoRange videoRange) {

        LayoutUtil.UsingGridBagLayout(this);

        GridBagConstraints c = LayoutUtil.buildConstraints(0, 0, insets);
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(fileName), c);

        this.videoRange = videoRange.clone();

        sliderBegin = RangeSlider.build(videoRange, videoRange.getStart());
        sliderBegin.addChangeListener(new SliderBeginChange());
        spinnerBegin = TimexSpinner.build(videoRange, videoRange.getStart());
        spinnerBegin.addChangeListener(new SpinnerBeginChange());


        sliderEnd = RangeSlider.build(videoRange, videoRange.getEnd());
        sliderEnd.addChangeListener(new SliderEndChange());
        spinnerEnd = TimexSpinner.build(videoRange, videoRange.getEnd());
        spinnerEnd.addChangeListener(new SpinnerEndChange());

        int line;
        line = 1;
        c = LayoutUtil.buildConstraints(line, 0, insets);
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.LINE_START;
        totalLength = new JCheckBox(
                DialogProperties.instance().getString(DialogProperties.Key.TotalLength));
        totalLength.setFont(LocalConfig.instance().getLocalFont());
        totalLength.setSelected(videoRange.rangeIsTotal());
        totalLength.addItemListener(new checkBoxChange());
        add(totalLength, c);

        line++;
        beginLabel = new JLabel(
                DialogProperties.instance().getString(DialogProperties.Key.begin));
        beginLabel.setFont(LocalConfig.instance().getLocalFont());
        add(beginLabel,
                LayoutUtil.buildConstraints(line, 0, insets));
        add(spinnerBegin,
                LayoutUtil.buildConstraints(line, 1, insets));
        add(sliderBegin,
                LayoutUtil.buildConstraints(line, 2, insets));

        line++;
        endLabel = new JLabel(
                DialogProperties.instance().getString(DialogProperties.Key.end));
        endLabel.setFont(LocalConfig.instance().getLocalFont());
        add(endLabel,
                LayoutUtil.buildConstraints(line, 0, insets));
        add(spinnerEnd,
                LayoutUtil.buildConstraints(line, 1, insets));
        add(sliderEnd,
                LayoutUtil.buildConstraints(line, 2, insets));

        setTimeRangeEnable(!videoRange.rangeIsTotal());

    }

    private class checkBoxChange implements ItemListener {

        @Override
        public void itemStateChanged(final ItemEvent itemEvent) {
            Object source = itemEvent.getItemSelectable();
            if (source == totalLength) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    setTimeRangeEnable(false);
                } else {
                    setTimeRangeEnable(true);
                }
            }
        }
    }

    private void setTimeRangeEnable(boolean rangeEnable) {
        sliderBegin.setEnabled(rangeEnable);
        spinnerBegin.setEnabled(rangeEnable);
        sliderEnd.setEnabled(rangeEnable);
        spinnerEnd.setEnabled(rangeEnable);
        beginLabel.setEnabled(rangeEnable);
        endLabel.setEnabled(rangeEnable);
    }

    private class SpinnerBeginChange implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent changeEvent) {
            int beginValue = getSecond(spinnerBegin);

            if (sliderBegin.getValue() != beginValue) {
                sliderBegin.setValue(beginValue);
            }

            if (getSecond(spinnerEnd) < beginValue) {
                setSecond(spinnerEnd, beginValue);
            }

            if (sliderEnd.getValue() < beginValue) {
                sliderEnd.setValue(beginValue);
            }

        }
    }

    private class SliderBeginChange implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent changeEvent) {

            int beginValue = sliderBegin.getValue();

            if (getSecond(spinnerBegin) != beginValue) {
                setSecond(spinnerBegin, beginValue);
            }

            if (getSecond(spinnerEnd) < beginValue) {
                setSecond(spinnerEnd, beginValue);
            }

            if (sliderEnd.getValue() < beginValue) {
                sliderEnd.setValue(beginValue);
            }
        }
    }

    private class SpinnerEndChange implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent changeEvent) {
            int endValue = getSecond(spinnerEnd);
            if (sliderEnd.getValue() != endValue) {
                sliderEnd.setValue(endValue);
            }

            if (getSecond(spinnerBegin) > endValue) {
                setSecond(spinnerBegin, endValue);
            }

            if (sliderBegin.getValue() > endValue) {
                sliderBegin.setValue(endValue);
            }
        }
    }

    private class SliderEndChange implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent changeEvent) {

            int endValue = sliderEnd.getValue();

            if (getSecond(spinnerEnd) != endValue) {
                setSecond(spinnerEnd, endValue);
            }

            if (getSecond(spinnerBegin) > endValue) {
                setSecond(spinnerBegin, endValue);
            }

            if (sliderBegin.getValue() > endValue) {
                sliderBegin.setValue(endValue);
            }
        }
    }

    private int getSecond(TimexSpinner spinner) {
        return spinner.getTimexValue().getSecond();
    }

    private void setSecond(TimexSpinner spinner, int second) {
        spinner.setTimexValue(second);
    }

}
