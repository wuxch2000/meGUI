package gui.major.table.render;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

/**
 * User: 吴晓春
 * Date: 11-3-23
 * Time: 下午2:49
 */
class CellImageObserver implements ImageObserver {
    private JTable table;

    private int row;
    private int col;

    CellImageObserver(JTable table, int row, int col) {
        this.table = table;
        this.row = row;
        this.col = col;
    }

    public boolean imageUpdate(Image img, int flags, int x, int y, int w,
                               int h) {
        if ((flags & (FRAMEBITS | ALLBITS)) != 0) {
            Rectangle rect = table.getCellRect(row, col, false);
            table.repaint(rect);
        }
        return (flags & (ALLBITS | ABORT)) == 0;
    }
}
