package gui.util.time.spinner;

import gui.util.time.*;
import log.Trace;

import javax.swing.*;
import javax.swing.event.*;
import java.beans.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-18
 * Timex: 下午3:42
 */
public class TimexSpinnerEditor
        extends JFormattedTextField
        implements ChangeListener, PropertyChangeListener {
    private TimexSpinner spinner;

    public TimexSpinnerEditor(final TimexSpinner spinner) {
        super(Timex.getFormat());
        setValue(spinner.getValue());
        setHorizontalAlignment(JLabel.RIGHT);
        setColumns(5);
        this.spinner = spinner;

        addPropertyChangeListener("value", this);
    }

    @Override
    public void stateChanged(final ChangeEvent changeEvent) {
        Trace.debug("TimexSpinnerEditor.stateChanged()");
        setText(spinner.getValue().toString());
//        super.setValue(spinner.getValue());
    }

    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        Date d = (Date) getValue();
        spinner.setTimexValue(Timex.miliSecondToSecond(d.getTime()));
    }
}
