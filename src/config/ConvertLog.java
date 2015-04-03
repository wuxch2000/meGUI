package config;

import config.properties.DialogProperties;
import gui.MainPanel;
import gui.util.FileUtil;
import gui.util.dialog.OptionPaneDialog;
import log.Trace;
import org.w3c.dom.Document;
import xml.StringUtil;
import xml.XmlUtil;
import xml.domutil.DomUtil;

import javax.xml.xpath.XPathExpressionException;
import java.io.File;

import static xml.XmlUtil.updateElementValue;

/**
 * User: 吴晓春
 * Date: 11-3-22
 * Time: 上午9:32
 */
public class ConvertLog {
    private static ConvertLog convertLogInstance = new ConvertLog();

    public static ConvertLog instance() {
        return convertLogInstance;
    }

    final static private String CONVERT_LOG_FILE_NAME = "convert_log.xml";
    final static private String CONVERT_LOG_XSL_NAME = "convert_log.xsl";

    public static String getLogFileName() {
        return CONVERT_LOG_FILE_NAME;
    }

    public static String getLogXslName() {
        return CONVERT_LOG_XSL_NAME;
    }

    private ConvertLog() {
    }

    private String getFullPath() {
        return StringUtil.concat(FileUtil.getRootPath(), FileUtil.sep, CONVERT_LOG_FILE_NAME);
    }

    public Document getDom() {
        try {
            return DomUtil.build(new File(getFullPath()));
        } catch (Exception e) {
            Trace.error(e);
            System.err.print("XML:get config error, exit");
            if (MainPanel.instance() != null) {
//                Object[] options = new Object[1];
//                options[0] = DialogProperties.instance().getString(DialogProperties.Key.OK);
//                JOptionPane.showOptionDialog(null,
//                        "Open file: " + getFullPath() + " error.",
//                        "Error",
//                        JOptionPane.YES_OPTION,
//                        JOptionPane.ERROR_MESSAGE,
//                        null,     //do not use a custom Icon
//                        options,  //the titles of buttons
//                        options[0]); //default button title

                OptionPaneDialog.showErrorDialog(null,
                        DialogProperties.Key.OpenFileError,
                        getFullPath());
            }
            System.exit(-1);
        }
        return null;
    }

    private String getStringByXPath(String xpath) {
        Trace.debug("XML:get config by \"", xpath, "\"");
        String result = null;
        try {
            result = XmlUtil.xpath(xpath, getDom());
        } catch (XPathExpressionException e) {
            Trace.error(e);
        }
        Trace.debug("XML:result of  \"", xpath, "\" is:\"", result, "\"");
        return result;
    }

    private static final String LAST_OPEN_DIRECTORY_PATH = "/log/run-time-info/last-open-directory";

    public String getLastOpenDir() {
        return getStringByXPath(LAST_OPEN_DIRECTORY_PATH);
    }

    public void setLastOpenDir(String dir) {
        try {
            Document dom = getDom();
            updateElementValue(dir, LAST_OPEN_DIRECTORY_PATH, dom);
            write(dom);
        } catch (Exception e) {
            Trace.error(e);
        }
    }

    private static final String LAST_DEST_DIRECTORY_PATH = "/log/run-time-info/last-dest-directory";

    public String getLastDestDir() {
        return getStringByXPath(LAST_DEST_DIRECTORY_PATH);
    }

    public void setLastDestDir(String dir) {
        try {
            Document dom = getDom();
            updateElementValue(dir, LAST_DEST_DIRECTORY_PATH, dom);
            write(dom);
        } catch (Exception e) {
            Trace.error(e);
        }
    }


    private static final String SHOW_TUTORIAL_ON_START_UP_PATH = "/log/run-time-info/show-tutorial-on-shartup";

    public boolean getShowtutorailOnStartUp() {
        String s = getStringByXPath(SHOW_TUTORIAL_ON_START_UP_PATH);
        return Boolean.valueOf(s);
    }

    public void setShowtutorailOnStartUp(boolean b) {
        try {
            String boolStr = Boolean.toString(b);
            Document dom = getDom();
            updateElementValue(boolStr, SHOW_TUTORIAL_ON_START_UP_PATH, dom);
            write(dom);
        } catch (Exception e) {
            Trace.error(e);
        }
    }

    public void write(Document dom) {
        try {
            XmlUtil.dom2xml(dom, getFullPath());
        } catch (Exception e) {
            Trace.error(e);
        }
    }

}
