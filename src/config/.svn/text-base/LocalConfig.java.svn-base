package config;

import java.awt.*;
import java.util.*;

import static xml.StringUtil.*;

/**
 * User: 吴晓春
 * Date: 11-4-1
 * Time: 上午11:20
 */
public class LocalConfig {

    private static LocalConfig localConfig = null;
    private Config config = Config.instance();

    private Locale locale = null;

    private Font localFontSize = null;

    private Font localFont = null;

    public LocalConfig() {

    }


    public static LocalConfig instance() {
        if (localConfig == null) {
            localConfig = new LocalConfig();
        }
        return localConfig;
    }

    private String getLocalUsing() {
        return config.getStringByXPath("/config/local/using");
    }

    private String buildLocalPath(String content) {
        String using = getLocalUsing();
        if (using == null) {
            return null;
        }

        return concat("/config/local",
            "/local-option[@name=\"", using, "\"]",
            content);
    }

    private String getLocalLanguageString() {
        return config.getStringByXPath(buildLocalPath("/language"));
    }

    private String getLocalCountryString() {
        return config.getStringByXPath(buildLocalPath("/country"));
    }

    public String getLocalFontNameString() {
        return config.getStringByXPath(buildLocalPath("/font/name"));
    }

    private String getLocalFontSizeString() {
        return config.getStringByXPath(buildLocalPath("/font/size"));
    }


    public Locale getLocal() {
        if (locale == null) {
            String language = getLocalLanguageString();
            String country = getLocalCountryString();

            if (language == null ||
                country == null) {
                return Locale.US;
            }

            locale = new Locale(language, country);
        }

        return locale;
    }


    public Font getLocalFontSize() {
        if (localFontSize == null) {
            String fontName = getLocalFontNameString();
            String fontSize = getLocalFontSizeString();
            if (fontName == null) {
                localFontSize = new Font("SansSerif", Font.PLAIN, 12);
                return localFontSize;
            }
            localFontSize = new Font(fontName, Font.PLAIN, new Integer(fontSize));
        }
        return localFontSize;
    }

    public Font getLocalFont() {
        if (localFont == null) {
            String fontName = getLocalFontNameString();
            if (fontName == null) {
                localFont = new Font("SansSerif", Font.PLAIN, 12);
                return localFont;
            }
            localFont = new Font(fontName, Font.PLAIN, 12);
        }
        return localFont;
    }
}
