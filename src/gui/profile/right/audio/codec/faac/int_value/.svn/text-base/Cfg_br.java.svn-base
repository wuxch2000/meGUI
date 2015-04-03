package gui.profile.right.audio.codec.faac.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_br extends A_SimpleCfgInt {

    private final static String label = "br";
    private final static String xmlPath = "/profile/audio/codec/faac/" + label;
    private final static String tip = "bitrate";
    private final static int defaultValue = 128;
    private final static int minValue = 1;
    private final static int maxValue = 1024;

    public Cfg_br() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
