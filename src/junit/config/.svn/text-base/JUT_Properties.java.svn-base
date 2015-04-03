/**
 *
 */
package junit.config;

import config.properties.*;
import log.*;
import org.junit.*;

import java.awt.*;

/**
 * @author 吴晓春
 */
public class JUT_Properties {

    @Ignore
    @Test
    public void test_ProcessTableModel() {
        Trace.debug("STATUS =", VideoFileFieldProperties.instance().
            getString(VideoFileFieldProperties.Key.STATUS));
    }

    @Test
    public void test_font() {
        GraphicsEnvironment ge = GraphicsEnvironment.
            getLocalGraphicsEnvironment();

        for (String s : ge.getAvailableFontFamilyNames()) {
            Trace.debug("JUT_Properties.test_font():",
                "font:", s);
        }
    }

    @Test
    public void test_font_heiti() {
        String fontName = "黑体";
        Font heiti = Font.getFont(fontName);
        if (heiti != null) {
            Trace.debug("JUT_Properties.test_font_heiti():",
                "get font heiti OK, font is", heiti.toString());
        } else {
            Trace.debug("JUT_Properties.test_font_heiti():",
                "get font ", fontName," failed");
        }
    }

}
