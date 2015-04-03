package gui.profile.right.basetype;

import config.encode.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;
import gui.util.*;
import xml.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author 吴晓春
 *         <p/>
 *         用于配置简单的a={list}的基类
 */
public abstract class A_SimpleCfgList extends A_SimpleCfgBase {

    class Change implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            hilightNoDefaultValue();
        }

    }

    /**
     * 前一个String是在Combox显示值，后一个String是实际生成arg的参数值
     *
     * @author 吴晓春
     */
    static public class ValueType extends Pair<String, String> {

        /**
         * @param first : 在JComboBox里的显示项
         * @param v     :选中后实际输出的参数值
         */
        public ValueType(String first, String v) {
            super(first, v);
        }

        @Override
        public String toString() {
            return getFirst();
        }

    }

    private final JComboBox comboBox;

    private final ValueType defaultValue;

    public A_SimpleCfgList(String label,
                           String xmlPath,
                           I_DefaultBehaviour defaultBehaviour,
                           I_ArgOutputFormat argOutputFormat,
                           ValueType defaultValue,
                           ValueType[] values) {
        super(label, defaultBehaviour, argOutputFormat, xmlPath);

        this.defaultValue = defaultValue;

        comboBox = new JComboBox(values);
        comboBox.setSelectedItem(defaultValue);
        comboBox.addActionListener(new Change());

        SizeUtil.setSize(comboBox);

        addValueComponent(comboBox);
    }

    @Override
    public JComponent getGUI() {
        return panel;
    }

    protected String getValue() {
        return ((ValueType) comboBox.getSelectedItem()).getSecond();
    }

    @Override
    protected boolean isDefaultValue() {
        ValueType currentValue = (ValueType) comboBox.getSelectedItem();
        return currentValue.equals(defaultValue);
    }

    @Override
    public void setDefault() {
        comboBox.setSelectedItem(defaultValue);
        hilightNoDefaultValue();
    }

    @Override
    public String toCmdLineArg() {
        if (isDefaultValue() && defaultBehaviour.noOutputForDefault())
            return "";

        return argOutputFormat.getArgString(getLabel(), getValue());
    }

    private ValueType getItemByString(String s) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            ValueType item = (ValueType) comboBox.getItemAt(i);
            if (item.getSecond().equalsIgnoreCase(s)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        String xmlValue = getValueFromFile(file);
        ValueType value = getItemByString(xmlValue);
        if (value != null) {
            comboBox.setSelectedItem(value);
            hilightNoDefaultValue();
        }
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        setValueToFile(file, getValue());
    }

}
