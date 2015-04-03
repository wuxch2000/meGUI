package gui.profile.right.video.codec.lavc.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vb_strategy extends A_SimpleCfgInt {

    private final static String label = "vb_strategy";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "strategy to choose between I/:P/:B frames (pass 2): \n 0: always use the " +
                                      "maximum number of B frames (default) \n 1: avoid B frames in high motion " +
                                      "scenes (bitrate mispredictions)";
    private final static int defaultValue = 0;
    private final static int minValue = 0;
    private final static int maxValue = 1;

    public Cfg_vb_strategy() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }
}
