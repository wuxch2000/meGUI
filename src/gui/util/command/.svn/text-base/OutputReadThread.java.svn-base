package gui.util.command;

import log.*;

import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-3-12
 * Timex: 下午5:00
 */
public class OutputReadThread extends Thread {
    private InputStream is;
    private I_ParseString parseString;

    private OutputReadThread(final InputStream is, I_ParseString parseString) {
        super();
        this.is = is;
        this.parseString = parseString;
    }

    public static OutputReadThread build(final InputStream is, I_ParseString parseString) {
        return new OutputReadThread(is, parseString);
    }

    @Override
    public void run() {
        Trace.debug("OutputReadThread running!");

        BufferedReader stdout = new BufferedReader(new InputStreamReader(is));

        String line = null;
        try {
            while (
                ((line = stdout.readLine()) != null) &&
                (!Thread.interrupted())
                ) {
//                Trace.debug("OutputReadThread.run():",
//                    "get line:",line);
                parseString.parseString(line);
            }
            stdout.close();
        } catch (IOException e) {
            Trace.error(e);
            Trace.debug(this, ":Thread quit because IOException");
        }
        if (line == null) {
            Trace.debug(this, ":Thread quit because line == null");
        }
        if (interrupted()) {
            Trace.debug(this, ":Thread quit because interrupted");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OutputReadThread[");
        builder.append(this.getName());
        builder.append("]");
        return builder.toString();
    }
}
