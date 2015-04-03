package gui.profile.right.video.codec.x264.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_me extends A_SimpleCfgList {

    private final static String label = "me";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "me version";

    static private final ValueType[] options = {
        new ValueType("dia", "dia"),
        new ValueType("hex", "hex"),
        new ValueType("umh", "umh"),
        new ValueType("esa", "esa")};

    static private final ValueType defaultValue = options[1];

    public Cfg_me() {
        super(label, xmlPath,
                FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
