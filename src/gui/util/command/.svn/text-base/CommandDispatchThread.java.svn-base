package gui.util.command;

import log.*;

import java.util.*;

import static gui.util.command.Status.*;

/**
 * User: 吴晓春
 * Date: 11-3-12
 * Timex: 下午5:00
 */
public class CommandDispatchThread extends Thread {

    private List<CommandInfo> commandInfoQueue;

    public CommandDispatchThread() {
        commandInfoQueue = Collections.synchronizedList(new LinkedList<CommandInfo>());
    }

    public static CommandDispatchThread build() {
        return new CommandDispatchThread();
    }

    public void addThread(CommandInfo info) {
        commandInfoQueue.add(info);
        info.setStatus(WAITING);

    }

    public void stopThread(CommandInfo info) {

        if (commandInfoQueue.remove(info)) {
            info.getProcessThread().interrupt();
        }
    }

    @Override
    public void run() {

        Trace.debug("CommandDispatchThread.run():",
            "start running.:");

        while (!commandInfoQueue.isEmpty()) {
            CommandInfo info = commandInfoQueue.get(0);

            Thread thread = CommandExecThread.build(info);

            Trace.debug("CommandDispatchThread.run():",
                "running thread:", thread.getName());
            thread.start();

            try {
                thread.join();
                commandInfoQueue.remove(info);
            } catch (InterruptedException e) {
                Trace.error(e);
                stopAllThread();
                return;
            }
        }
    }

    public void stopAllThread() {
        while (!commandInfoQueue.isEmpty()) {
            Thread currentThread;
            currentThread = commandInfoQueue.remove(0).getProcessThread();
            if (currentThread != null) {
                Trace.debug("CommandDispatchThread.stopAllThread():",
                    "stop thread:", currentThread.getName());
                currentThread.interrupt();
            }
        }
    }

}
