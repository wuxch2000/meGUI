package gui.profile.right.video.codec.lavc.bool_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_v4mv extends A_SimpleCfgBool {

    private final static String label = "v4mv";
    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "4 motion vectors per macroblock (slightly better quality). (default: disabled)" +
                                      "";
    private final static boolean defaultValue = false;

    public Cfg_v4mv() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL), defaultValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
