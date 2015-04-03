package gui.profile.right.basetype.format;

import java.text.MessageFormat;

/**
 * format:-a b
 */
public class OutputUsingSpace implements I_ArgOutputFormat{
    public static OutputUsingSpace instance = new OutputUsingSpace();
    @Override
    public String getArgString(String label, String value) {
        return new StringBuilder().append("-").append(label).append(" ").append(value).append(" ").toString();
    }
    @Override
    public String getArgString(String label, int value) {
        return getArgString(label, MessageFormat.format("{0,number,###}", value));
    }

}
