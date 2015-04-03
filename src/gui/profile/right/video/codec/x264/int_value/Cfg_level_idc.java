package gui.profile.right.video.codec.x264.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_level_idc extends A_SimpleCfgInt {

    private final static String label = "level_idc";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "level_idc";
    private final static int defaultValue = 30;
    private final static int minValue = 15;
    private final static int maxValue = 51;

    public Cfg_level_idc() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
