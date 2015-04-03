package junit.stub;

import config.encode.*;

import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-23
 * Time: 上午9:20
 */
public class StubEncodeProfile extends EncodeProfile{
    public StubEncodeProfile(File profile) {
        super(null);
    }

    @Override
    public String toString() {
        return "ipod.nano";
    }
}
