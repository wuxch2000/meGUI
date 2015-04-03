package log;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xml.XmlUtil;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trace {

    static private Logger logger = null;

    public final static String ln = System.getProperty("line.separator", "\n");

    static private StringBuffer outputBuffer = null;

    static private Logger instance() {
        if (logger != null) {
            return logger;
        }
        logger = Logger.getLogger("LOG");
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        logger.addHandler(new StdOutput());
        try {
            logger.addHandler(new StdFileOutput());
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        logger.setUseParentHandlers(false);
        logger.setLevel(Level.CONFIG);
        // logger.setLevel(Level.WARNING);

        return logger;
    }

    static public void debug(Document dom) {
        try {
            String str = XmlUtil.dom2Concole(dom);
            debug(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static private String nodeToString(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Node[type:");
        switch (node.getNodeType()) {
            case Node.ATTRIBUTE_NODE:
                stringBuilder.append("attr");
                break;
            case Node.ELEMENT_NODE:
                stringBuilder.append("element");
                break;
            case Node.TEXT_NODE:
                stringBuilder.append("text");
                break;
            case Node.COMMENT_NODE:
                stringBuilder.append("comment");
                break;
            case Node.CDATA_SECTION_NODE:
                stringBuilder.append("cdata");
                break;
        }
        stringBuilder.append(",name:");
        stringBuilder.append(node.getNodeName());

        stringBuilder.append(",value:");
        stringBuilder.append(node.getNodeValue());

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static public void debug(Node node) {
        debug(nodeToString(node));
    }

    static public void error(Node node) {
        error(nodeToString(node));
    }

    static public void debug(Object obj) {
        // debug(obj.toString());
        instance().info(obj.toString());
    }

    static public void debug(String str) {
        // System.out.println(str);
        instance().info(str);
    }

    static public void debug(String... args) {
        if (outputBuffer == null) {
            outputBuffer = new StringBuffer();
        }
        outputBuffer.setLength(0);
        for (String str : args) {
            outputBuffer.append(str);
        }
        debug(outputBuffer.toString());
    }

    static public void debug(Object... args) {
        if (outputBuffer == null) {
            outputBuffer = new StringBuffer();
        }
        outputBuffer.setLength(0);
        for (Object obj : args) {
            outputBuffer.append(obj.toString());
        }
        debug(outputBuffer.toString());
    }

    static public void error(Object obj) {
        // error(obj.toString());
        instance().warning(obj.toString());
    }

    static public void error(Exception e) {
        StringWriter wr = new StringWriter();
        e.printStackTrace(new PrintWriter(wr));
        instance().warning(wr.toString());
    }

    static public void error(String str) {
        instance().warning(str);
    }

    static public void error(String... args) {
        if (outputBuffer == null) {
            outputBuffer = new StringBuffer();
        }
        outputBuffer.setLength(0);
        for (String str : args) {
            outputBuffer.append(str);
        }
        error(outputBuffer.toString());
    }

    static public void exception(Exception e, String error) {
        JOptionPane.showMessageDialog(null, e.getMessage(), error,
                JOptionPane.ERROR_MESSAGE);
    }

}
