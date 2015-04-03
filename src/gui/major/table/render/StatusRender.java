package gui.major.table.render;

import gui.util.*;
import gui.util.command.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 上午9:45
 */
public class StatusRender
    extends JLabel
    implements TableCellRenderer {

    private final HashMap<Status, String> icons = new HashMap<>();

    public StatusRender() {
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);

        icons.put(Status.IDLE, "idle.gif");
        icons.put(Status.WAITING, "waiting.gif");
        icons.put(Status.RUNNING, "running.gif");
        icons.put(Status.DONE, "done.gif");
        icons.put(Status.INTERRUPPTED, "interrupt.gif");
        icons.put(Status.ERROR, "interrupt.gif");

    }


    @Override
    public Component getTableCellRendererComponent
        (final JTable table,
         final Object statusValue,
         final boolean isSelected,
         final boolean hasFocus,
         final int row,
         final int column) {

        Status newStatus = (Status) statusValue;
        Icon icon = ImageUtil.createImageIcon(icons.get(newStatus));

        setIcon(icon);

        ImageIcon imageIcon = (ImageIcon) icon;
        if (imageIcon.getImageObserver() == null) {
            (imageIcon).setImageObserver(new CellImageObserver(table, row,
                column));
        }

        int height = icon.getIconHeight();
        if (table.getRowHeight(row) < height) {
            table.setRowHeight(row, height);
        }

        int width = icon.getIconHeight();

        if(width > table.getColumnModel().getColumn(column).getPreferredWidth()){
            table.getColumnModel().getColumn(column).setPreferredWidth(width);
        }


        return this;
    }

}
