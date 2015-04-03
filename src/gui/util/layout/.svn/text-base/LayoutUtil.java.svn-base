package gui.util.layout;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-10
 * Timex: 上午10:36
 */
public class LayoutUtil {
    final public static int RELATIVE = GridBagConstraints.RELATIVE;
    final public static Insets defaultInsets = buildInsets(5, 5, 5, 5);

    public static Insets buildInsets(int top, int left, int bottom, int right) {
        return new Insets(top, left, bottom, right);
    }

    public static GridBagConstraints buildConstraints(int line, int column, double weightx, double weighty, int gridwidth) {
        GridBagConstraints c = buildConstraints(line, column);
        c.weightx = weightx;
        c.weighty = weighty;
        c.gridwidth = gridwidth;
//        c.anchor = GridBagConstraints.WEST;
        c.anchor = GridBagConstraints.NORTHWEST;
        return c;
    }

    public static GridBagConstraints buildConstraints(int line, int column) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = column;
        c.gridy = line;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = defaultInsets;
        return c;
    }

    public static GridBagConstraints buildConstraints(int line, int column, Insets insets) {
        GridBagConstraints c = buildConstraints(line, column);
        c.insets = insets;
        return c;
    }

    public static GridBagConstraints buildConstraints(int line, int column, int width, Insets insets) {
        GridBagConstraints c = buildConstraints(line, column, width);
        c.insets = insets;
        return c;
    }


    public static GridBagConstraints buildConstraints(int line, int column, int width) {
        GridBagConstraints c = buildConstraints(line, column);
        c.gridwidth = width;
        return c;
    }

    public static GridBagConstraints buildConstraints(int line, int column, Insets insets, int width) {
        GridBagConstraints c = buildConstraints(line, column, insets);
        c.gridwidth = width;
        return c;
    }

    public static GridBagConstraints buildFlowGBCons(int line, int column) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = column;
        c.gridy = line;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        return c;
    }

    public static void UsingGridBagLayout(JComponent jComponent) {
        LayoutManager layoutManager = new GridBagLayout();
        jComponent.setLayout(layoutManager);
    }

    public static void UsingBorderLayout(JComponent jComponent) {
        LayoutManager layoutManager = new BorderLayout();
        jComponent.setLayout(layoutManager);
    }
}
