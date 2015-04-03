package convert;

import convert.util.*;
import gui.util.command.*;

/**
 * User: 吴晓春
 * Date: 11-3-14
 * Timex: 下午5:38
 */
public class ExecWhenQuit implements Runnable{
    public ExecWhenQuit() {
    }

    public void run() {
        ClearTempFiles.exec();
        Command.instance().stopAll();
    }
}
