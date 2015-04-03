package gui.major.videoinfo.videodetail;

import gui.major.videoinfo.videodetail.items.*;

import java.awt.*;

public class GridBagConstraintBuilder {
    private static GridBagConstraintBuilder instanceGridBagConstraintBuilder;

    public static GridBagConstraintBuilder instance() {
        if (instanceGridBagConstraintBuilder == null) {
            instanceGridBagConstraintBuilder = new GridBagConstraintBuilder();
        }
        return instanceGridBagConstraintBuilder;
    }

    private void commonSetting(GridBagConstraints c) {
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
    }

    public GridBagConstraints build(final Detail_Name item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        return c;
    }

    public GridBagConstraints build(final Detail_Length item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_Format item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_Fps item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_Width item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_Height item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_AudioCodec item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_AudioBitrate item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_AudioChannel item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        return c;
    }

        public GridBagConstraints build(final Detail_VideoCodec item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        return c;
    }

    public GridBagConstraints build(final Detail_VideoBitrate item) {
        GridBagConstraints c = new GridBagConstraints();
        commonSetting(c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        return c;
    }

}
