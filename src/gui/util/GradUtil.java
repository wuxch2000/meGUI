package gui.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-3-2
 * Timex: 上午9:25
 * To change this template use File | Settings | File Templates.
 */
public class GradUtil {
    static private final Color FROM_COLOR = new Color(234,234,234);
    static private final Color TO_COLOR = new Color(160,160,160);

    static private final Point ZERO = new Point(0,0);

    static public GradientPaint buildGrad(JComponent component) {
        Point p2 = new Point(0, (int) component.getSize().getHeight());
        GradientPaint grad = new GradientPaint(ZERO,FROM_COLOR,p2,TO_COLOR);
        return grad;
    }
}
