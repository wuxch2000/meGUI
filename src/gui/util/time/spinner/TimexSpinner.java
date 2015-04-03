package gui.util.time.spinner;

import gui.util.time.*;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 下午3:07
 */

public class TimexSpinner extends JSpinner {

    private TimexSpinner(final SpinnerModel spinnerModel) {
        super(spinnerModel);
        TimexSpinnerEditor editor = new TimexSpinnerEditor(this);
        setEditor(editor);
        getModel().addChangeListener(editor);

    }

    @Override
    public Object getValue() {
        return getModel().getValue();
    }

    public Timex getTimexValue() {
        return (Timex) getModel().getValue();
    }

    public void setTimexValue(int second) {
        Timex value = (Timex) getValue();
        value.setSecond(second);
        getModel().setValue(value);
    }

    public static TimexSpinner build(VideoRange videoRange,
                                     Timex defaultTime) {
        return new TimexSpinner(
            new TimexSpinnerModel(defaultTime,
                videoRange.getStart(),
                videoRange.getEnd()));
    }

    public static TimexSpinner build(int value, int min, int max) {
        return new TimexSpinner(
            new TimexSpinnerModel(Timex.build(value),
                Timex.build(min),
                Timex.build(max)));
    }
}
