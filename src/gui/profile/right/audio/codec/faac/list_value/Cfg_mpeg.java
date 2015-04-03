package gui.profile.right.audio.codec.faac.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_mpeg extends A_SimpleCfgList {

    private final static String label = "mpeg";
    private final static String xmlPath = "/profile/audio/codec/faac/" + label;
    private final static String tip = "mpeg version";

    static private final ValueType[] options = {new ValueType("2", "2"),
        new ValueType("4", "4")};

    static private final ValueType defaultValue = options[1];

    public Cfg_mpeg() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }
}
