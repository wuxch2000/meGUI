package gui.util.command;

import convert.util.ThreadKeepWake;
import log.*;

import java.io.*;
import java.util.*;

import static gui.util.command.Status.DONE;
import static gui.util.command.Status.INTERRUPPTED;
import static gui.util.command.Status.RUNNING;

/**
 * User: 吴晓春
 * Date: 11-3-12
 * Timex: 下午5:00
 */
public class CommandExecThread extends Thread {

    private CommandInfo info;

    public CommandExecThread(final CommandInfo info) {
        this.info = info;
    }

    public static CommandExecThread build(final CommandInfo info) {
        return new CommandExecThread(info);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CommandExecThread[");
//        builder.append(info.getCommandString());
        builder.append(getName());
        builder.append("]");
        return builder.toString();
    }


    @Override
    public void run() {
        Trace.debug("CommandExecThread.run():",
            "start running. command:",info.getCommandString());

        info.setProcessThread(this);

        ProcessBuilder pb = new ProcessBuilder(info.getArg());

        pb.directory(info.getExecDir());
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            info.setStartTime(new Date(System.currentTimeMillis()));
            info.setStatus(RUNNING);
        } catch (IOException e) {
            Trace.error(e);
            return;
        }
        info.setProcess(p);

        OutputReadThread outputReadThread = OutputReadThread.build(
            p.getInputStream(), info.getParseString());
        info.setPollOutputThread(outputReadThread);
        outputReadThread.start();

        ThreadKeepWake threadKeepWake = new ThreadKeepWake();
        threadKeepWake.start();

        try {
            p.waitFor();
            outputReadThread.join();
            info.setEndTime(new Date(System.currentTimeMillis()));
            info.setStatus(DONE);
            threadKeepWake.interrupt();

        } catch (InterruptedException e) {
            Trace.debug("CommandExecThread.run():", this, " is interuppted!");
            outputReadThread.interrupt();
            p.destroy();
            info.setEndTime(new Date(System.currentTimeMillis()));
            info.setStatus(INTERRUPPTED);
            threadKeepWake.interrupt();
        }
    }

    public CommandInfo getInfo() {
        return info;
    }
}
