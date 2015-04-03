package gui.major.table.render;

import config.*;
import sun.swing.table.*;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-24
 * Time: 上午9:11
 */
public class HeaderRender extends DefaultTableCellHeaderRenderer {
    public HeaderRender() {
        setHorizontalAlignment(JTextField.CENTER);
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
//        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setFont(LocalConfig.instance().getLocalFontSize());
        return label;
    }
}
