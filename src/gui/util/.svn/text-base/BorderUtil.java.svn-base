package gui.util;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-4-18
 * Time: 下午2:38
 */
public class BorderUtil {
    public static void addBorder(JComponent panel, String title) {
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder;
        titledBorder = BorderFactory.createTitledBorder(border, title, TitledBorder.LEFT, TitledBorder.TOP);
//        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);
    }

    final private static int edgeValue = 5;

    public static void addSpaceBorder(JComponent panel) {
        Border emptyBorder = BorderFactory.createEmptyBorder(edgeValue, edgeValue, edgeValue, edgeValue);

        Border border = panel.getBorder();
        if (border != null) {
            panel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, border));
        } else {
            panel.setBorder(emptyBorder);
        }
    }

    public static void addSpaceBorder(JComponent panel, int edge) {
        Border emptyBorder = BorderFactory.createEmptyBorder(edge, edge, edge, edge);

        Border border = panel.getBorder();
        if (border != null) {
            panel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, border));
        } else {
            panel.setBorder(emptyBorder);
        }
    }

    public static void addSolidBorder(JComponent panel) {
        Border solidBorder = BorderFactory.createLineBorder(Color.BLUE);
        panel.setBorder(solidBorder);
    }

    public static void removeBorder(JComponent panel) {
        panel.setBorder(null);
    }
}
