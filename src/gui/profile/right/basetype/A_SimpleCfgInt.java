package gui.profile.right.basetype;

import config.encode.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;
import gui.util.*;

import javax.swing.*;
import javax.swing.event.*;
import java.text.*;

/**
 * @author 吴晓春
 *         <p/>
 *         用于配置简单的a=number的基类
 */
public abstract class A_SimpleCfgInt extends A_SimpleCfgBase {

    private final JSpinner spinner;
    final SpinnerNumberModel model;

    static private final int step = 1;
    final Integer defaultValue;

    class Change implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            hilightNoDefaultValue();
        }

    }

    public A_SimpleCfgInt(String label,
                          String xmlPath,
                          I_DefaultBehaviour defaultBehaviour,
                          I_ArgOutputFormat argOutputFormat,
                          int defaultValue, int minValue,
                          int maxValue) {
        super(label, defaultBehaviour, argOutputFormat, xmlPath);

        spinner = new JSpinner();
        this.defaultValue = defaultValue;
        model = new SpinnerNumberModel(defaultValue, minValue, maxValue, step);
        spinner.setModel(model);
        spinner.addChangeListener(new Change());
        SizeUtil.setSize(spinner);

        addValueComponent(spinner);
    }

    protected int getValue() {
        return model.getNumber().intValue();
    }

    @Override
    public String toCmdLineArg() {
        if (isDefaultValue() && defaultBehaviour.noOutputForDefault())
            return "";

        return argOutputFormat.getArgString(getLabel(), getValue());
    }

    @Override
    public void setDefault() {
        model.setValue(defaultValue);
        hilightNoDefaultValue();
    }

    @Override
    protected boolean isDefaultValue() {
        return defaultValue.equals(this.spinner.getValue());
    }

    private String getStringByInt(int v) {
        return MessageFormat.format("{0,number,###}", v);
    }

    private int getIntByString(String s) {
        if (s.equals("")) {
            return defaultValue;
        }

        return new Integer(s);
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        String xmlValue = getValueFromFile(file);
        int value = getIntByString(xmlValue);
        model.setValue(value);
        hilightNoDefaultValue();
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        setValueToFile(file, getStringByInt(getValue()));
    }
}
