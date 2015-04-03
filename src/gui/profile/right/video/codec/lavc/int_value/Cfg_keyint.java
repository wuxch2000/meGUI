package gui.profile.right.video.codec.lavc.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_keyint extends A_SimpleCfgInt {

    private final static String label = "keyint";
    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "interval between keyframes in frames. Larger numbers mean slightly smaller " +
                                      "files, but less precise seeking, 0 means no key frames and values >300 aren't " +
                                      "recommended. For a strict mpeg1/:2/:4 compliance this would have to be <=132. " +
                                      "(default: 250 or one key frame every ten seconds in a 25fps movie)";
    private final static int defaultValue = 250;
    private final static int minValue = 0;
    private final static int maxValue = 300;

    public Cfg_keyint() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL), defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
