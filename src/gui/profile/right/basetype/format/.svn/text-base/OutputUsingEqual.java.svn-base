package gui.profile.right.basetype.format;

import java.text.MessageFormat;

/**
 * format:-a b
 */
public class OutputUsingEqual implements I_ArgOutputFormat{
    public static OutputUsingEqual instance = new OutputUsingEqual();
    @Override
    public String getArgString(String label, String value) {
        return new StringBuilder().append(label).append("=").append(value).toString();
    }

    @Override
    public String getArgString(String label, int value) {
        return getArgString(label, MessageFormat.format("{0,number,###}",value));
    }

}
