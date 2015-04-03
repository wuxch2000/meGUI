package gui.major.table.render;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-24
 * Time: 上午9:21
 */
abstract public class CellRender extends DefaultTableCellRenderer {
    public CellRender() {
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
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

}
