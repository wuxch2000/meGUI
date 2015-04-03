package gui.util.time.spinner;

import gui.util.time.*;

import javax.swing.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 下午3:09
 */
public class TimexSpinnerModel extends AbstractSpinnerModel {
    private Timex value;
    final private Timex minValue;
    final private Timex maxValue;

    public TimexSpinnerModel(final Timex value,
                             final Timex min,
                             final Timex max
    ) {
        super();
        this.value = value;
        this.minValue = min;
        this.maxValue = max;
    }

    @Override
    public Object getValue() {
//        Trace.debug("TimexSpinnerModel.getValue()");
        return value;
    }

    @Override
    public void setValue(final Object o) {
//        Trace.debug("TimexSpinnerModel.setValue()");
        Timex t = (Timex) o;
        if (maxValue.compareTo(t) < 0) {
            value = maxValue;
        } else if (minValue.compareTo(t) > 0) {
            value = minValue;
        } else {
            value = t;
        }

        fireStateChanged();
    }

    @Override
    public Object getNextValue() {
//        Trace.debug("TimexSpinnerModel.getNextValue()");
        if (maxValue.compareTo(value) > 0) {
            value.increase(1);
            return value;
        }
        return null;
    }

    @Override
    public Object getPreviousValue() {
//        Trace.debug("TimexSpinnerModel.getPreviousValue()");
        if (minValue.compareTo(value) < 0) {
            value.decrease(1);
            return value;
        }
        return null;
    }
}
