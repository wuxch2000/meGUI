package gui.util;

import javax.swing.*;
import java.awt.*;

public final class SizeUtil {
    public static Dimension getScreenSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();

        return kit.getScreenSize();
    }

    static public void setSize(Window window, double factorOfScreen) {
        Dimension dim = getScreenSize();
        Dimension newDim = new Dimension();
        newDim.setSize(dim.getWidth() * factorOfScreen,
            dim.getHeight() * factorOfScreen);
        window.setSize(newDim);
    }

//    static public int getTextHeight(JComponent jComponent) {
//        FontMetrics f = jComponent.getFontMetrics(jComponent.getFont());
//        return f.getHeight();
//    }

    static private int getCharWidth(JComponent jComponent, char c) {
        FontMetrics f = jComponent.getFontMetrics(jComponent.getFont());
        return f.charWidth(c);
    }

    static private int getStringWidth(JComponent jComponent, String str) {
        int width = 0;
        for (char c : str.toCharArray()) {
            width += getCharWidth(jComponent, c);
        }
        return width;
    }

//    static public void setWidthByString(JComponent jComponent, String str) {
//        int width = getStringWidth(jComponent, str);
//        int height = (int) jComponent.getMinimumSize().getHeight();
//
//        // Trace.debug("width and height is:", width, ",", height);
//        jComponent.setMaximumSize(new Dimension(width, height));
//        jComponent.setPreferredSize(new Dimension(width, height));
//    }

    static public void setSize(JComboBox box) {
        int max = box.getItemCount();
        int maxStrWidth = 0;
        for (int i = 0; i < max; i++) {
            int strWidth = getStringWidth(box, box.getItemAt(i).toString());
            if (strWidth > maxStrWidth) {
                maxStrWidth = strWidth;
            }
        }

        int width = maxStrWidth + 5 * getCharWidth(box, '0');
        int height = (int) box.getMinimumSize().getHeight();

        box.setMaximumSize(new Dimension(width, height));
        box.setPreferredSize(new Dimension(width, height));
    }

    static public void setSize(JSpinner spinner) {
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
        int maxValue = (Integer) model.getMaximum();
        // 计算maxValue的位数
        int n = 1;
        while ((maxValue / 10) > 0) {
            maxValue = maxValue / 10;
            n++;
        }

        n += 5;
        int width = n * getCharWidth(spinner, '0');
        int height = (int) spinner.getMinimumSize().getHeight();

        // Trace.debug("width and height is:", width, ",", height);
        spinner.setMaximumSize(new Dimension(width, height));
        spinner.setPreferredSize(new Dimension(width, height));
    }

//    static public void sameSize(JComponent toBeAdjustComponent,
//                                JComponent mirrorComponent) {
//        sameSize(toBeAdjustComponent, mirrorComponent.getSize());
//    }

    static public void sameSize(JComponent toBeAdjustComponent,
                                int width, int height) {
        sameSize(toBeAdjustComponent, new Dimension(width,height));
    }

    static public void sameSize(JComponent toBeAdjustComponent,
                                Dimension size) {
        toBeAdjustComponent.setPreferredSize(size);
        toBeAdjustComponent.setMaximumSize(size);
        toBeAdjustComponent.setMinimumSize(size);
    }

    static public void sameSize(JComponent toBeAdjustComponent,
                                JComponent mirrorComponent) {
        sameSize(toBeAdjustComponent, mirrorComponent.getSize());
    }


    static public void sameWidth(JComponent toBeAdjustComponent,
                                 int width) {
        Dimension newSize = new Dimension(width,
            toBeAdjustComponent.getPreferredSize().height);

        sameSize(toBeAdjustComponent, newSize);
    }

    static public void sameHeight(JComponent toBeAdjustComponent,
                                  int height) {
        Dimension newSize = new Dimension(toBeAdjustComponent.getWidth(),
            height);

        sameSize(toBeAdjustComponent, newSize);
    }


    static public void sameWidth(JComponent toBeAdjustComponent,
                                 JComponent mirrorComponent) {
       int width = mirrorComponent.getWidth();
       sameWidth(toBeAdjustComponent,width);
    }

    static public void sameHeight(JComponent toBeAdjustComponent,
                                  JComponent mirrorComponent) {
        int height = mirrorComponent.getHeight();
        sameHeight(toBeAdjustComponent, height);
    }

    static public Dimension add(Dimension d1, Dimension d2) {
        return new Dimension(d1.width + d2.width,
            d1.height + d2.height);
    }

}
