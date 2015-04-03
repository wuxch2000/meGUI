package convert.util.info;

import convert.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午5:33
 */
abstract public class A_VI_String extends A_VideoInfo {

    protected String value;

    public A_VI_String(final VideoFileInfor videoFileInfor, String ID) {
        super(videoFileInfor);
        value = getStringFromOutput(ID);
    }

    @Override
    public int getIntValue() {
        return -1;
    }

    @Override
    public String getStringValue() {
        return value;
    }
}
