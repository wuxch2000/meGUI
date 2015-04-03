package gui.util.command;

import log.*;

import java.io.*;

/**
 * User: 吴晓春
 * Date: 11-2-22
 */

public class Command {
    static private Command gInstance;

    static public Command instance() {
        if (gInstance == null) {
            gInstance = new Command();
        }
        return gInstance;
    }

    public Command() {
        commandDispatchThread = new CommandDispatchThread();
    }

    private CommandDispatchThread commandDispatchThread;

    public void stopAsyn(CommandInfo info) {
        commandDispatchThread.stopThread(info);
    }

    public void stopAll() {
        commandDispatchThread.stopAllThread();
    }

    public void runAsyn(CommandInfo info) {
        Trace.debug("Command.runAsyn:", info);
        if (commandDispatchThread.isAlive()) {
            commandDispatchThread.addThread(info);
        } else {
            commandDispatchThread = new CommandDispatchThread();
            commandDispatchThread.addThread(info);
            commandDispatchThread.start();
        }
    }

    public String runSyn(CommandInfo info) {
        try {

            Trace.debug(info);

            ProcessBuilder pb = new ProcessBuilder(info.getArg());

            pb.directory(info.getExecDir());
            pb.redirectErrorStream(true);
            Process p = pb.start();

            //read the standard output
            BufferedReader stdout = new BufferedReader(new InputStreamReader(p
                .getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = stdout.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            int ret = p.waitFor();
            Trace.debug("the return code is:" + ret);
            stdout.close();
            return stringBuilder.toString();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
