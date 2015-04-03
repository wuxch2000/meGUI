package gui.profile.right.basetype;

import config.encode.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author 吴晓春
 *         <p/>
 *         用于配置简单的enable/disable的基类
 */
public abstract class A_SimpleCfgBool extends A_SimpleCfgBase {

    private final JCheckBox checkBox;

    final boolean defaultValue;

    class Change implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent arg0) {
            hilightNoDefaultValue();
        }

    }

    public A_SimpleCfgBool(String label,
                           String xmlPath,
                           I_DefaultBehaviour defaultBehaviour,
                           I_ArgOutputFormat argOutputFormat,
                           boolean defaultValue) {
        super(label, defaultBehaviour, argOutputFormat, xmlPath);

        this.defaultValue = defaultValue;
        checkBox = new JCheckBox("", defaultValue);

        checkBox.addItemListener(new Change());

        addValueComponent(checkBox);
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        String xmlValue = getValueFromFile(file);
        boolean value = getBoolByString(xmlValue);

        checkBox.setSelected(value);
        hilightNoDefaultValue();
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        setValueToFile(file,getStringByBool(getValue()));
    }


    private static final String TRUE_STRING = "yes";
    private static final String FALSE_STRING = "no";

    private String getStringByBool(boolean v) {
        if (v){
            return TRUE_STRING;
        }
        else {
            return FALSE_STRING;
        }
    }

    private boolean getBoolByString(String s) {
        boolean value = defaultValue;
        if (s.equalsIgnoreCase(TRUE_STRING)) {
            value = true;
        } else if (s.equalsIgnoreCase(FALSE_STRING)) {
            value = false;
        }
        return value;
    }


    protected boolean getValue() {
        return checkBox.isSelected();
    }

    @Override
    public String toCmdLineArg() {
        if (isDefaultValue() && defaultBehaviour.noOutputForDefault())
            return "";

        return argOutputFormat.getArgString(
                getLabel(),
                getStringByBool(getValue()));

    }

    @Override
    public void setDefault() {
        checkBox.setSelected(defaultValue);
        hilightNoDefaultValue();
    }

    @Override
    protected boolean isDefaultValue() {
        return defaultValue == getValue();
    }
}
