package convert.util.info;

import convert.util.*;
import log.*;
import xml.*;

import java.util.regex.*;

/**
 * User: 吴晓春
 * Date: 11-3-8
 * Timex: 下午5:31
 */
abstract public class A_VideoInfo {
    protected A_VideoInfo(final VideoFileInfor videoFileInfor) {
        this.videoFileInfor = videoFileInfor;
    }

//    public VideoFileInfor getVideoFileInfor() {
//        return videoFileInfor;
//    }

    private VideoFileInfor videoFileInfor;

    public int getIntValue() {
        return -1;
    }

    public double getDoubleValue() {
        return -1.0;
    }


    public abstract String getStringValue();

    // 获取诸如ID_LENGTH=123之类的信息
    protected int getIntFromOutput(final String id) {
        String regexp = StringUtil.concat(".*", id, "=(\\d+).*$");
        String numstr = parserFromOutput(regexp);
        if (!numstr.equals("")) {
            return new Integer(numstr);
        }
        return -1;
    }

    protected double getDoubleFromOutput(final String id) {
        String regexp = StringUtil.concat(".*", id, "=(\\S+).*$");
        String numstr = parserFromOutput(regexp);
        if (!numstr.equals("")) {
            return new Double(numstr);
        }
        return -1;
    }

    // 获取诸如ID_FILENAME=a.avi之类的信息
    protected String getStringFromOutput(final String id) {
        String regexp = StringUtil.concat(".*", id, "=(\\S+)$");
        return parserFromOutput(regexp);
    }

    private String parserFromOutput(final String regexp) {
        String[] raw = videoFileInfor.getRawInforStringArray();
        Pattern p;
        p = Pattern.compile(regexp);
        Trace.debug("parserFromOutput:pattern:" + p.toString());
        for (String s : raw) {
            Matcher m = p.matcher(s);
            if (m.matches()) {
                Trace.debug("parserFromOutput:match sucessed");
                return m.group(1);
            }
        }

        Trace.debug("parserFromOutput:match failed");
        return "";
    }

}
