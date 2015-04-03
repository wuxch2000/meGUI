package gui.util.command;

import java.io.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-3-12
 * Timex: 下午10:53
 */
public class CommandInfo {
    final private File execDir;
    final private List<String> arg;
    final private I_ParseString parseString;

    final private I_CommandStatusUpdate commandStatusUpdate;
    private Process process;
    private Thread pollOutputThread;
    private Thread processThread;

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
        if (commandStatusUpdate != null) {
            commandStatusUpdate.commandStatusUpdate(status);
        }
    }

    private Status status;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    private Date startTime;
    private Date endTime;

    public static CommandInfo build(final File execDir,
                                    final List<String> arg,
                                    final I_ParseString parseString,
                                    final I_CommandStatusUpdate commandStatusUpdate) {
        return new CommandInfo(execDir, arg, parseString, commandStatusUpdate);
    }

    public static CommandInfo build(final File execDir,
                                    final List<String> arg,
                                    final I_ParseString parseString) {
        return new CommandInfo(execDir, arg, parseString, null);
    }

    public static CommandInfo build(final File execDir,
                                    final List<String> arg) {
        return new CommandInfo(execDir, arg, null, null);
    }

    public Thread getProcessThread() {
        return processThread;
    }

    public void setProcessThread(final Thread processThread) {
        this.processThread = processThread;
    }

    private CommandInfo(final File execDir,
                        final List<String> arg,
                        final I_ParseString parseString,
                        final I_CommandStatusUpdate commandStatusUpdate) {
        this.execDir = execDir;
        this.arg = arg;
        this.parseString = parseString;
        this.commandStatusUpdate = commandStatusUpdate;
        startTime = null;
        endTime = null;
        status = Status.IDLE;
    }

    public Process getProcess() {
        return process;
    }

    public Thread getPollOutputThread() {
        return pollOutputThread;
    }

    public File getExecDir() {

        return execDir;
    }

    public List<String> getArg() {
        return arg;
    }

    public I_ParseString getParseString() {
        return parseString;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("command dir:").append(getExecDir().getPath()).append("\n");

        builder.append("command str:").append(getCommandString());

        return builder.toString();
    }

    public String getCommandString() {
        StringBuilder builder = new StringBuilder();
        String[] commandStringList = getArg().toArray(new String[arg.size()]);
        for (String s : commandStringList) {
            builder.append(s).append(" ");
        }
        return builder.toString();
    }


    public void setProcess(final Process process) {
        this.process = process;
    }

    public void setPollOutputThread(final Thread pollOutputThread) {
        this.pollOutputThread = pollOutputThread;
    }

}
