package gui.profile.right.video.codec.lavc.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vpass extends A_SimpleCfgInt {

    private final static String label = "vpass";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "Activates internal 2pass mode (default: disabled):";
    private final static int defaultValue = 0;
    private final static int minValue = 0;
    private final static int maxValue = 2;

    public Cfg_vpass() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }
}
