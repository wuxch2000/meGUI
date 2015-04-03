package gui.profile.right.video.codec.lavc.bool_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vhq extends A_SimpleCfgBool {

    private final static String label = "vhq";
    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "high quality mode, encode each macro block in all modes an choose the smallest" +
                                      " (slow). (default: HQ disabled)";
    private final static boolean defaultValue = false;

    public Cfg_vhq() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
