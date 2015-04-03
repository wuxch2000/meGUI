package gui.profile.right.basetype;

import config.encode.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;
import gui.util.layout.*;

import javax.swing.*;
import java.awt.*;

/**
 * 实现基本A=B的基类，其中A就是label，B的具体形式由派生类实现，B可以是int或者bool或者list等
 *
 * @author 吴晓春
 */
public abstract class A_SimpleCfgBase implements I_ConfigItem {

    protected final JPanel panel;
    protected final JLabel label;
    protected final I_DefaultBehaviour defaultBehaviour;
    protected final I_ArgOutputFormat argOutputFormat;
    protected final String xmlPath;

    public A_SimpleCfgBase(String label,
                           I_DefaultBehaviour defaultBehaviour,
                           I_ArgOutputFormat argOutputFormat, String xmlPath) {
        super();
        this.defaultBehaviour = defaultBehaviour;
        this.argOutputFormat = argOutputFormat;
        this.xmlPath = xmlPath;
        panel = new JPanel();


//        LayoutManager layout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
//        panel.setLayout(layout);
        LayoutUtil.UsingGridBagLayout(panel);

        int line = 0, column = 0;
        this.label = new JLabel(label);

        GridBagConstraints c = LayoutUtil.buildConstraints(line, column);
        c.insets = LayoutUtil.buildInsets(3, 3, 3, 3);

        panel.add(this.label, c);
        // panel.add(new JLabel(":"));
    }

    protected void addValueComponent(JComponent component) {
        int line = 0, column = 1;

        GridBagConstraints c = LayoutUtil.buildConstraints(line, column);
        c.insets = LayoutUtil.buildInsets(3, 3, 3, 3);

        panel.add(component, c);
    }

    protected void afterInit() {
        panel.add(Box.createHorizontalGlue());
    }

    @Override
    public JComponent getGUI() {
        return panel;
    }

    protected String getLabel() {
        return label.getText();
    }

    protected void hilightNoDefaultValue() {
        if (isDefaultValue()) {
            label.setForeground(Color.BLACK);
        } else {
            label.setForeground(Color.BLUE);
        }
        label.updateUI();
    }

    protected abstract boolean isDefaultValue();

    protected abstract boolean alwaysSaveToConfig();

    protected void setToolTip(String tip) {
        label.setToolTipText(tip);
    }


    protected String getValueFromFile(EncodeProfile file) {
        return file.getValueByPath(xmlPath);
    }

    protected void setValueToFile(EncodeProfile file, String value) {
        if (!isDefaultValue() || alwaysSaveToConfig()) {
            file.setValueByPath(xmlPath, value);
        }
    }


}
