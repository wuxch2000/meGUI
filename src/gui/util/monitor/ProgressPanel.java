package gui.util.monitor;

import config.LocalConfig;
import config.properties.DialogProperties;
import gui.util.BorderUtil;
import gui.util.SizeUtil;
import gui.util.dialog.OptionPaneDialog;
import gui.util.layout.LayoutUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: 吴晓春
 * Date: 11-4-18
 * Time: 下午2:04
 */
public class ProgressPanel extends JPanel implements ActionListener {
    private final JProgressBar progressBar;
    private final JLabel prompt;
    private final JButton cancel;
    private final Window window;
    private SupportCancel cancelInterface = null;

    public ProgressPanel(final Window window) {
        this.window = window;
        prompt = new JLabel("");
        prompt.setFont(LocalConfig.instance().getLocalFont());

        progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);

        cancel = new JButton(DialogProperties.instance().getString(DialogProperties.Key.Cancel));
        cancel.setFont(LocalConfig.instance().getLocalFont());
        cancel.addActionListener(this);

        layoutAll();
    }

    private void layoutAll() {

        LayoutUtil.UsingGridBagLayout(this);

        GridBagConstraints c;
        int line;

        int largeWidth = 3;
        line = 0;
        c = LayoutUtil.buildConstraints(line, 0);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = largeWidth;
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(prompt, c);

        line++;
        c = LayoutUtil.buildConstraints(line, 0);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = largeWidth;
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(progressBar, c);

        line++;
        c = LayoutUtil.buildConstraints(line, largeWidth - 1);
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_END;
        add(cancel, c);

        BorderUtil.addSpaceBorder(this, 5);

        SizeUtil.sameSize(this, new Dimension(400, 100));

    }

    void cancel() {
        if (!window.isVisible()) {
            return;
        }

        if (OptionPaneDialog.showConfirmDialog(window,
                DialogProperties.Key.QuitNow,
                DialogProperties.Key.QuitNow,
                OptionPaneDialog.YES_NO_OPTION) == OptionPaneDialog.YES_OPTION) {
            if (getCancel() != null) {
                getCancel().cancel();
            }
            window.setVisible(false);
        }
    }

    public void setCancel(SupportCancel cancel) {
        cancelInterface = cancel;
    }

    public SupportCancel getCancel() {
        return cancelInterface;
    }


    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        cancel();
    }

    private void setIndeterminate(boolean newValue) {
        progressBar.setIndeterminate(newValue);
    }

    public void setPrompt(String str) {
        prompt.setText(str);
        prompt.setFont(LocalConfig.instance().getLocalFont());
    }

    public void setProgress(int progress) {
        if (progress == 100) {
            progressBar.setValue(progress);
            close();
        } else if (progress > 0) {
            if (!window.isVisible()) {
                window.setVisible(true);
            }
            setIndeterminate(false);
            progressBar.setStringPainted(true);
            progressBar.setValue(progress);
            progressBar.setString(Integer.toString(progress) + "%");
        } else if (progress == 0) {
            if (!window.isVisible()) {
                window.setVisible(true);
            }
            setIndeterminate(true);
        }


    }

    public void close() {
        progressBar.setString("");
        window.setVisible(false);
    }
}
