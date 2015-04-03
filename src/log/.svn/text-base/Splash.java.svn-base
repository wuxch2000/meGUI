package log;

import xml.*;

import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-4-26
 * Time: 上午9:54
 */
public class Splash {
    private static Graphics2D g = null;

    private static SplashScreen splash;

    private static final Point zeroPoint = new Point(10,250);


    static private void drawTextBackground() {
        final Color backgroundColor = new Color(204,204,237);
//        final Color backgroundColor = Color.yellow;
        final Dimension size = new Dimension(400,30);
        final Point recPoint = new Point(zeroPoint.x, zeroPoint.y-20);
        final Rectangle rec = new Rectangle(recPoint,size);

        g.setColor(backgroundColor);
        g.fill(rec);
    }

    static private void drawText(String str) {
        final Color textColor = Color.black;
        g.setColor(textColor);
        g.drawString(str, zeroPoint.x, zeroPoint.y);
    }

    static public void info(String str) {
        splash = SplashScreen.getSplashScreen();
        if (splash == null || !splash.isVisible()) {
            return;
        }

        if (g == null) {
            if (!initGraphics2D()) {
                return;
            }
        }
        Trace.debug("Splash.info():", "drawString:", str);

        drawTextBackground();
        drawText(str);
        splash.update();
    }

    static private boolean initGraphics2D() {
        splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            Trace.debug("Splash.getGraphics2D():",
                "SplashScreen.getSplashScreen() returned null");
            return false;
        }
        g = splash.createGraphics();
        if (g == null) {
            Trace.debug("Splash.getGraphics2D():",
                "g is null");
            return false;
        }
        return true;
    }

    static public void info(String... args) {
        info(StringUtil.concat(args));
    }
}
