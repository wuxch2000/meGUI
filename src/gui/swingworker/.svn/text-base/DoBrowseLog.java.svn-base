package gui.swingworker;

import config.*;
import config.properties.*;
import gui.util.*;
import gui.util.monitor.*;
import gui.util.os.*;
import log.*;
import xml.xslt2.*;

import java.io.*;
import java.net.*;

/**
 * User: 吴晓春
 * Date: 11-3-11
 * Timex: 下午3:56
 */

public class DoBrowseLog implements NeedUsingSwingWorker {

    private final File source;
    private final File xsl;
    private final File dest;
    private final File sourceCss;
    private final File destCss;


    public DoBrowseLog() {
        final String htmlFileName = "log.html";
        source = FileUtil.buildFile(FileUtil.getRootPath(), ConvertLog.getLogFileName());
        xsl = FileUtil.buildFile(FileUtil.getRootPath(), ConvertLog.getLogXslName());
        dest = FileUtil.buildFile(Config.instance().getVideoTempPath(), htmlFileName);
        final String cssFileName = "log.css";
        sourceCss = FileUtil.buildFile(FileUtil.getRootPath(), cssFileName);
        destCss = FileUtil.buildFile(Config.instance().getVideoTempPath(), cssFileName);


    }

    @Override()
    public void done() throws Exception {
        Monitor.instance().setDone();

    }

    @Override()
    public void doInBackground() throws Exception {
        Monitor.instance().setProgress(0);
        copyCssFile();
        xslt();
        URI uri = getURI();
        if (uri != null) {
            setPrompt(DialogProperties.Key.openhtml);
            OsTask.instance().browse(uri);
            Monitor.instance().setProgress(100);
        }

    }

    private void xslt() {
        setPrompt(DialogProperties.Key.xslt);
        XsltSaxon.build().xslt(source, xsl, dest);
        Monitor.instance().setProgress(90);
    }

    private URI getURI() {
        return FileUtil.buildURI(dest);
    }

    private void copyCssFile() {
        try {
            setPrompt(DialogProperties.Key.copyCss);
            FileUtil.copyFile(sourceCss, destCss);
            Monitor.instance().setProgress(50);
        } catch (IOException e) {
            Trace.error(e);
        }
    }

    private void setPrompt(DialogProperties.Key key) {
        String prompt = DialogProperties.instance().
            getString(key);
        Monitor.instance().setPrompt(prompt);
    }

}
