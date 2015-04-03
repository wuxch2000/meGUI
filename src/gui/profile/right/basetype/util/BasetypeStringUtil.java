package gui.profile.right.basetype.util;

import gui.profile.right.basetype.*;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-16
 * Timex: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
public class BasetypeStringUtil {

    static final String SPACE = " ";

    static public String buildSubOptions(String subLabel, I_ConfigItem items[]) {
        StringBuilder builder = new StringBuilder();

        boolean addlabel = false;
        if (items.length > 0) {
            for (I_ConfigItem item : items) {
                if (item.toCmdLineArg().equals("") == false) {

                    if (addlabel == false) {
                        builder.append(subLabel);
                        builder.append(SPACE);
                        addlabel = true;
                    }

                    builder.append(item.toCmdLineArg());
                    builder.append(":");
                }
            }
            if (addlabel == true &&
                    (builder.charAt(builder.length() - 1) == ':')) {
                builder.deleteCharAt(builder.length() - 1);
            }

            builder.append(SPACE);
        }
        return builder.toString();
    }
}
