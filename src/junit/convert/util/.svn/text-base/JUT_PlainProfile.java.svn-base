package junit.convert.util;

import config.encode.EncodeProfile;
import config.encode.PlainProfile;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * User: 吴晓春
 * Date: 11-6-8
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class JUT_PlainProfile {

    private static EncodeProfile encodeProfile;

    @BeforeClass
    public static void setUp() {
        File profileFile = new File("d:\\JavaCode\\meGUI\\profile\\ipod.nano.xml");
        encodeProfile = new EncodeProfile(profileFile);
    }

    @Test
    public void buildPlainProfile() {
        PlainProfile plainFile = PlainProfile.build(encodeProfile);
        File file = plainFile.getPlainProfile();
        assertTrue(file != null);
    }
}
