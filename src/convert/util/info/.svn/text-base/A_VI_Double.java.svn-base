package convert.util.info;

import convert.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午5:33
 */
abstract public class A_VI_Double extends A_VideoInfo{

    protected double value;

    public A_VI_Double(final VideoFileInfor videoFileInfor, String ID) {
        super(videoFileInfor);
        value = getDoubleFromOutput(ID);
    }

    @Override
    public double getDoubleValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return String.format("%f",value);
    }

}
