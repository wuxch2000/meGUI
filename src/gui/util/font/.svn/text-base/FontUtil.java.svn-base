package gui.util.font;

import com.sun.istack.internal.Nullable;
import config.LocalConfig;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 吴晓春
 * Date: 11-8-10
 * Time: 下午3:45
 */
public class FontUtil {
    private static Map<Integer, Font> localFontMap = new HashMap<Integer, Font>();

    public static void setLocalFont(JComponent jComponent) {
        Font oldFont = jComponent.getFont();
        int fontSize = oldFont.getSize();

        Font localFont = getFontFromMap(fontSize, null);
        jComponent.setFont(localFont);
    }

    public static void enlargeFont(JComponent jComponent, int increase) {
        Font oldFont = jComponent.getFont();
        int fontSize = oldFont.getSize();
        int newFontSize = fontSize + increase;

        Font localFont = getFontFromMap(newFontSize, oldFont.getFontName());
        jComponent.setFont(localFont);
    }

    private static Font getFontFromMap(int fontSize, String localFontName) {
        // if name==null, using localfontname from xml config file.

        Font localFont = localFontMap.get(fontSize);
        if (localFont == null) {
            if (localFontName == null) {
                localFontName = LocalConfig.instance().getLocalFontNameString();
            }
            localFont = new Font(localFontName, Font.PLAIN, fontSize);
            localFontMap.put(fontSize, localFont);
        }
        return localFont;
    }
}
