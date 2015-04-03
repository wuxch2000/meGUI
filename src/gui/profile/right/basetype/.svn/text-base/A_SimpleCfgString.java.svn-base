package gui.profile.right.basetype;

import config.encode.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author 吴晓春
 *         <p/>
 *         用于配置简单的a=string的基类
 */
public abstract class A_SimpleCfgString extends A_SimpleCfgBase {

    public JButton getButton() {
        return button;
    }

    private final JButton button;

    private final String defaultValue;

    class Click implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {

        }
    }

    public A_SimpleCfgString(String label,
                             String xmlPath,
                             I_DefaultBehaviour defaultBehaviour,
                             I_ArgOutputFormat argOutputFormat,
                             String defaultValue
    ) {
        super(label, defaultBehaviour, argOutputFormat, xmlPath);

        this.defaultValue = defaultValue;
        button = new JButton(defaultValue);
        button.addActionListener(new Click());

        addValueComponent(button);

    }

    protected String getValue() {
        return button.getText();
    }

    public void setValue(String newVal) {
        button.setText(newVal);
    }

    @Override
    public String toCmdLineArg() {
        if (isDefaultValue() && defaultBehaviour.noOutputForDefault()) {
            return "";
        }

        return argOutputFormat.getArgString(getLabel(), getValue());
    }

    @Override
    public void setDefault() {
        setValue(defaultValue);
        hilightNoDefaultValue();
    }

    @Override
    protected boolean isDefaultValue() {
        return defaultValue.equals(this.getValue());
    }

    @Override
    public void updateFromFile(EncodeProfile file) {
        String xmlValue = getValueFromFile(file);
        setValue(xmlValue);
        hilightNoDefaultValue();
    }

    @Override
    public void updateToFile(EncodeProfile file) {
        setValueToFile(file, getValue());
    }
}
