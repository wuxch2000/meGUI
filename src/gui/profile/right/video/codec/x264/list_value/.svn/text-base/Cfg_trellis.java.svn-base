package gui.profile.right.video.codec.x264.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_trellis extends A_SimpleCfgList {

    private final static String label = "trellis";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "(cabac only) rate-distortion optimal quantization";

    static private final ValueType[] options = {
        new ValueType("0", "0"),
        new ValueType("1", "1"),
        new ValueType("2", "2")
    };

    static private final ValueType defaultValue = options[1];

    public Cfg_trellis() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
