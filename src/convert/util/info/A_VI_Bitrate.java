package convert.util.info;

import convert.util.*;

import java.text.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午5:33
 */
abstract public class A_VI_Bitrate extends A_VI_Int {

    public A_VI_Bitrate(final VideoFileInfor videoFileInfor, final String ID) {
        super(videoFileInfor, ID);
    }

    @Override
    public String getStringValue() {
        return formatSize(value,3);
    }

    private String formatSize(int longSize, int decimalPos) {
        NumberFormat fmt = NumberFormat.getNumberInstance();
        if (decimalPos >= 0) {
            fmt.setMaximumFractionDigits(decimalPos);
        }
        final double size = longSize;
        double val;
        val = size / (1000 * 1000);
        if (val > 1) {
            return fmt.format(val).concat(" mbps");
        }
        val = size / 1000;
        if (val > 10) {
            return fmt.format(val).concat(" kbps");
        }
        return fmt.format(val).concat(" bps");
    }

}
