package gui.util.monitor;

import log.Trace;

public class ConsoleMonitor extends Monitor {

    public ConsoleMonitor() {
    }

    @Override
    public void setProgress(int progress) {
        Trace.debug("Progress:", Integer.toString(progress), "%");
    }

    /*
      * (non-Javadoc)
      *
      * @see gui.monitor.Monitor#setDone()
      */
    @Override
    public void setDone() {
    }

    @Override
    public void setPrompt(String str) {
        Trace.debug(str);
    }

}
