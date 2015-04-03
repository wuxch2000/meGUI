package junit.convert.util;

import convert.util.ThreadKeepWake;
import log.Trace;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * User: 吴晓春
 * Date: 11-6-8
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class JUT_KeepWakeThread {

    @BeforeClass
    public static void setUp() {
    }

    @Test
    public void buildPlainProfile() throws InterruptedException {
        Trace.debug("JUT_keepWakeThread start ...");
        ThreadKeepWake keepWake = new ThreadKeepWake();
        keepWake.start();
        Thread.sleep(5000);
        keepWake.interrupt();
        Thread.sleep(5000);
        Trace.debug("JUT_keepWakeThread stop ...");
    }
}
