/**
 *
 */
package junit.config;

import config.*;
import gui.util.*;
import log.*;
import org.junit.*;

import java.io.*;
import java.util.*;

import static config.Config.*;

/**
 * @author 吴晓春
 */
public class JUnitTestConfig {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getProfiles() {
        // String[] profiles = Config.instance().getProfiles();
        ArrayList<String> profiles = new ArrayList<String>(Arrays.asList(
                instance().getProfiles()));
        Trace.debug("profiles is:", profiles.toString());
    }

    @Test
    public void getTempString() {
        Trace.debug("tempString is:", FileUtil.getSystemTempPath());
    }

    @Test
    public void getTempPath() {
        File temp = Config.instance().getVideoTempPath();
    }

    @Test
    public void getLastOpenDir() {
        Trace.debug("last dir is:", ConvertLog.instance().getLastOpenDir());
    }

    @Test
    public void setLastOpenDir() {
//        Trace.debug("last dir is:", Config.instance().getLastOpenDir());
        String newDir = "new dir";
        Trace.debug("set last dir to:", newDir);
        ConvertLog.instance().setLastOpenDir(newDir);
        Trace.debug("last dir is:", ConvertLog.instance().getLastOpenDir());
    }
}
