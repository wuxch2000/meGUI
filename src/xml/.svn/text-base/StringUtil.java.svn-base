package xml;

public class StringUtil {
//    static public String concat(String[] array) {
//        if (array == null) {
//            return null;
//        }
//        StringBuilder builder = new StringBuilder();
//        for (String str : array) {
//            builder.append(str);
//        }
//        return builder.toString();
//    }

    public final static String NEW_LINE = "\n";
    private static StringBuffer buffer = null;

    static public String concat(String... args) {
        if (buffer == null) {
            buffer = new StringBuffer();
        }
        buffer.setLength(0);
        for (String str : args) {
            buffer.append(str);
        }
        return buffer.toString();
    }

    static public String format(int i) {
        return String.format("%d", i);
    }

    static public String replaceSpace(String str, char c) {
        return str.replace(' ', c);
    }

}
