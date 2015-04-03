package config;

import gui.util.*;
import log.*;
import org.w3c.dom.*;
import xml.*;
import xml.domutil.*;

import javax.xml.xpath.*;
import java.io.*;
import java.util.*;

public class Config {
    final static private String CONFIG_FILE_NAME = "config.xml";

    static private Config config = null;

    static private Boolean debugFlag = null;

    public static boolean debug() {
        if (debugFlag == null) {
            debugFlag = false;
            String strDebug = System.getProperty("debug");
            if (strDebug != null &&
                    strDebug.equals("true")) {
                debugFlag = true;
            }
        }
        return debugFlag;
    }

    private Config() {
    }

    static private File videoTempPath = null;

    public File getVideoTempPath() {
        if (videoTempPath == null) {

            String pathStr = StringUtil.concat(FileUtil.getSystemTempPath(),
                    FileUtil.sep,
                    "meGUI",
                    FileUtil.sep);

            videoTempPath = new File(pathStr);
            if (!videoTempPath.exists()) {
                boolean ret = videoTempPath.mkdirs();
                if (!ret) {
                    Trace.error("mkdir of ", pathStr, " error");
                }
            }
        }
        return videoTempPath;
    }

    static public Config instance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    private String getFullPath() {
        return FileUtil.getRootPath() + FileUtil.sep + CONFIG_FILE_NAME;
    }


    private Document configDom = null;
    Document getConfigDom() {
        if(configDom != null)
            return configDom;

        try {
            String fileName = getFullPath();
            configDom =  DomUtil.build(new File(fileName));
            Trace.debug("build XML Dom from file:", fileName);
        } catch (Exception e) {
            Trace.error(e);
            System.err.print("XML:get config error, exit");
            System.exit(-1);
        }
        return configDom;
    }

    public String getString(String xpath) throws XPathExpressionException {
        return XmlUtil.xpath(xpath, getConfigDom());
    }

    String getStringByXPath(String xpath) {
        if (xpath == null) {
            return null;
        }
        Trace.debug("XML:get config by \"", xpath, "\"");
        String infoString = StringUtil.concat("get config by \"", xpath, "\"", " ...");
        Splash.info(infoString);
        String result = null;
        try {
            result = XmlUtil.xpath(xpath, getConfigDom());
        } catch (XPathExpressionException e) {
            Trace.error(e);
        }
        Trace.debug("XML:result of  \"", xpath, "\" is:\"", result, "\"");
        Splash.info(infoString + " done!");
        return result;
    }

    public String[] getProfiles() {
        final String profilePath = getStringByXPath("/config/profiles/path");

        final String numStr = getStringByXPath("count(/config/profiles/profile)");
        int num = Integer.parseInt(numStr);

        List<String> profiles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String xpath = "/config/profiles/profile[" + (i + 1) + "]"
                    + "/@name";
            String profile = getStringByXPath(xpath);

            profiles.add(StringUtil.concat(FileUtil.getRootPath(),
                    FileUtil.sep, profilePath, FileUtil.sep, profile));
        }

        return profiles.toArray(new String[profiles.size()]);
    }

    public String getProfileXsl() {
        final String profilePath = getStringByXPath("/config/profiles/path");
        String xpath = "/config/profiles/xsl-file/@name";
        String xslFile = getStringByXPath(xpath);

        return StringUtil.concat(FileUtil.getRootPath(),
                FileUtil.sep,
                profilePath,
                FileUtil.sep,
                xslFile);
    }

}
