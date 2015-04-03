package gui.util.monitor;

import javax.swing.*;

public abstract class Monitor {
    static private Monitor instance = null;

    private SupportCancel cancelInterface = null;

    public Monitor() {
    }

    static public void useGuiMonitor(JFrame container) {
        if (instance != null) {
            instance = null;
        }
        instance = new GuiMonitor(container);
    }

    static public Monitor instance() {
        if (instance == null) {
            // default monitor is console monitor
            instance = new ConsoleMonitor();
        }
        return instance;
    }

    public void setCancel(SupportCancel cancel) {
        cancelInterface = cancel;
    }

    public SupportCancel getCancel() {
        return cancelInterface;
    }

    public abstract void setProgress(int progress);

    public abstract void setDone();

    public abstract void setPrompt(String str);

    public void setBegin(String str) {
        setPrompt(str);
        setProgress(0);
    }
}
