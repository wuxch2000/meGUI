package gui.major.videofilesetting.timerange;

import config.*;
import config.properties.*;
import gui.util.*;
import gui.util.layout.*;
import gui.util.time.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 * Date: 11-3-15
 * Timex: 下午2:52
 */
public class TimeRangePanel extends JPanel {

    private TimeRangeSetting timeRangeSetting;
    private TimeRangeDialog dialog;

    public TimeRangePanel(TimeRangeDialog dialog, String fileName, VideoRange videoRange) {

        this.dialog = dialog;

        LayoutUtil.UsingGridBagLayout(this);

        timeRangeSetting = new TimeRangeSetting(fileName, videoRange);

        int line, column;
        GridBagConstraints c;

        line = 0;
        column = 0;
        final int MAX_COLUMN = 3;

        c = LayoutUtil.buildConstraints(line, column);
        c.gridwidth = MAX_COLUMN;
        add(timeRangeSetting, c);

        line++;
        final JButton buttonOK = new JButton(
                DialogProperties.instance().getString(DialogProperties.Key.OK));
        buttonOK.setFont(LocalConfig.instance().getLocalFont());
        buttonOK.addActionListener(new okAction());
        column = MAX_COLUMN - 2;
        c = LayoutUtil.buildConstraints(line, column);
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;
        add(buttonOK, c);

        final JButton buttonCancel = new JButton(DialogProperties.instance().getString(DialogProperties.Key.Cancel));
        buttonCancel.setFont(LocalConfig.instance().getLocalFont());
        buttonCancel.addActionListener(new cancelAction());
        column = MAX_COLUMN - 1;
        c = LayoutUtil.buildConstraints(line, column);
        c.weightx = 0;
        add(buttonCancel, c);

        BorderUtil.addSpaceBorder(this);
    }

    private class okAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            VideoRange videoRange =
                    timeRangeSetting.getVideoRange();
            if (dialog != null) {
                dialog.setRetValue(TimeRangeDialog.ReturnValue.OK);
                dialog.setVideoRange(videoRange);
                dialog.setVisible(false);
            }
        }
    }

    private class cancelAction implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (dialog != null) {
                dialog.setRetValue(TimeRangeDialog.ReturnValue.Cancel);
                dialog.setVisible(false);
            }
        }
    }

}
