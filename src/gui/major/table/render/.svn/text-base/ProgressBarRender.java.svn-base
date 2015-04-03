package gui.major.table.render;

import gui.major.table.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 上午9:45
 */
public class ProgressBarRender extends JProgressBar implements TableCellRenderer {
    public ProgressBarRender() {
        //        setOpaque(true);

        setMinimum(0);
        setMaximum(100);
        setStringPainted(true);
        setBorderPainted(true);

//
//        ProgressBar.background is the background color
//ProgressBar.foreground is the cell color
//ProgressBar.selectionBackground is the text color outside cells
//ProgressBar.selectionForeground is the text colot INSIDE cells

//        Property String	Object Type
//ProgressBar.background	Color
//ProgressBar.border	Border
//ProgressBar.cellLength	Integer
//ProgressBar.cellSpacing	Integer
//ProgressBar.cycleTime	Integer
//ProgressBar.font	Font
//ProgressBar.foreground	Color
//ProgressBar.highlight	Color
//ProgressBar.horizontalSize	Dimension
//ProgressBar.repaintInterval	Integer
//ProgressBar.selectionBackground	Color
//ProgressBar.selectionForeground	Color
//ProgressBar.shadow	Color
//ProgressBar.verticalSize	Dimension
//ProgressBarUI	String

//        UIDefaults defaults = UIManager.getDefaults();
//        Font font = new Font("Arial", Font.BOLD, 12);
//        defaults.put("ProgressBar.font", font);
//        defaults.put("ProgressBar.background",Color.GREEN);
//        defaults.put("ProgressBar.foreground",Color.GREEN);
//        defaults.put("ProgressBar.highlight",Color.GREEN);
//        defaults.put("ProgressBar.selectionBackground",Color.GREEN);

//        BasicProgressBarUI ui = (BasicProgressBarUI) this.getUI();
//        ui.put("ProgressBar.selectionForeground",Color.GREEN);
//        setForeground(Color.yellow);
//          setBackground(Color.green);

//        UIManager.put("ProgressBar.foreground", new Color(8, 32, 128));
    }

    @Override
    public Component getTableCellRendererComponent
        (final JTable jTable,
         final Object progressInfo,
         final boolean isSelected,
         final boolean hasFocus,
         final int row,
         final int column) {

        ProgressInfo info = (ProgressInfo) progressInfo;

        final int percent = info.getPercentage();

        setValue(percent);

//        if (percent == 100) {
//            setBackground(Color.green);
//        }

        return this;
    }
}
