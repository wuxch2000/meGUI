package gui.util.os;

import log.*;

import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * User: 吴晓春
 * Date: 11-4-14
 * Time: 下午5:14
 */
public class OsWindows7 extends OsTask{
    private Desktop desktop = null;
    @Override
    protected void init() {
        Trace.debug("OsWindows7.init():","init ...");
        Splash.info("OsWindows7.init():","init ...");
        desktop = Desktop.getDesktop();
    }

    @Override
    public void browse(final URI uri){
        try {
            desktop.browse(uri);
        } catch (IOException e) {
            Trace.error(e);
        }
    }
}
