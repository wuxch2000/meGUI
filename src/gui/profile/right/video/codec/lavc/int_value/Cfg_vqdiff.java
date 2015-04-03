package gui.profile.right.video.codec.lavc.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vqdiff extends A_SimpleCfgInt {

    private final static String label = "vqdiff";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "maximum quantizer difference between I or P frames (pass 1/:2) ";
    private final static int defaultValue = 3;
    private final static int minValue = 1;
    private final static int maxValue = 31;

    public Cfg_vqdiff() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }
}
