package gui.util.monitor;

import log.Trace;

import javax.swing.*;

public class GuiMonitor extends Monitor {
    // private final JFrame frame;
    private final ProgressDialog progressDialog;

    public GuiMonitor(JFrame frame) {
        // this.frame = frame;
        progressDialog = new ProgressDialog(frame);
    }

    @Override
    public void setProgress(int progress) {
        // progressMonitor = new ProgressMonitor(container, "Wait...", "",
        // 0,
        // 100);
        // progressMonitor.setIndeterminate(true);
        // progressDialog.setMillisToDecideToPopup(0);
        // progressDialog.setMillisToPopup(0);
        Trace.debug("Monitor: Progress " + progress + "%");
        progressDialog.setProgress(progress);
    }

    @Override
    public void setDone() {
        if (progressDialog == null) {
            return;
        }
        progressDialog.close();
        super.setCancel(null);
    }

    @Override
    public void setCancel(SupportCancel cancel) {
        super.setCancel(cancel);
        progressDialog.setCancel(cancel);
    }

    @Override
    public void setPrompt(String str) {
        Trace.debug("Monitor: setPrompt: ", str);
        progressDialog.setPrompt(str);
    }

}
