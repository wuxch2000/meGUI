package convert.util.info;

import convert.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午5:33
 */
abstract public class A_VI_Int extends A_VideoInfo{

    protected int value;

    public A_VI_Int(final VideoFileInfor videoFileInfor, String ID) {
        super(videoFileInfor);
        value = getIntFromOutput(ID);
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return String.format("%d",value);
    }

}
