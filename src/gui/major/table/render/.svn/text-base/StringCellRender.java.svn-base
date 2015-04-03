package gui.major.table.render;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-24
 * Time: 上午9:21
 */
public class StringCellRender extends CellRender {
    public StringCellRender() {
    }

    @Override
    public Component getTableCellRendererComponent(
        final JTable table,
        final Object value,
        final boolean isSelected,
        final boolean hasFocus,
        final int row,
        final int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setToolTipText(value.toString());
        return label;
    }

}
