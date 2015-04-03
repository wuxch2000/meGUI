package convert.util;

import config.*;
import gui.util.*;
import log.*;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-3-5
 * Timex: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class ClearTempFiles {
    public static void exec(){
        File tempFileDir = Config.instance().getVideoTempPath();

        try {
            FileUtil.del(tempFileDir.getPath());
        } catch (IOException e) {
            Trace.error(e);
        }
    }
}
