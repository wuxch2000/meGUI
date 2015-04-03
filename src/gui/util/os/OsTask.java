package gui.util.os;

import log.*;

import java.net.*;

/**
 * User: 吴晓春
 * Date: 11-4-14
 */
abstract public class OsTask {

    abstract protected void init();

    static private OsTask _instance;
    static public OsTask instance() {
        if (_instance == null) {
            String osName = System.getProperty("os.name");
            String osVersion = System.getProperty("os.version");
            Trace.debug("OsTask.build():",
                "OS Name:\"", osName, "\" OS Version:\"", osVersion, "\"");
            if (osName.equalsIgnoreCase("Windows 7")) {
                _instance =  new OsWindows7();
                _instance.init();
            }
            else {
                // to be add for other os;
                _instance =  new OsWindows7();
            }
        }
        return _instance;
    }

    abstract public void browse(URI uri);
}
