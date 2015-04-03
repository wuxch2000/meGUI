package gui.profile.right.audio.others.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_srate extends A_SimpleCfgInt {

    private final static String label = "srate";
    private final static String xmlPath = "/profile/audio/" + label;
    private final static String tip = "srate";
    private final static int defaultValue = 48000;
    private final static int minValue = 1;
    private final static int maxValue = 1024000;

    public Cfg_srate() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(SPACE),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
