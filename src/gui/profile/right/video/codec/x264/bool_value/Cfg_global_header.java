package gui.profile.right.video.codec.x264.bool_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_global_header extends A_SimpleCfgBool {

    private final static String label = "global_header";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "global_header";
    private final static boolean defaultValue = true;

    public Cfg_global_header() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
