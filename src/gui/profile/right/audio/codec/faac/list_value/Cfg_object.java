package gui.profile.right.audio.codec.faac.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_object extends A_SimpleCfgList {

    private final static String label = "object";
    private final static String xmlPath = "/profile/audio/codec/faac/" + label;
    private final static String tip = "object type complexity";

    static private final ValueType[] options = {new ValueType("1:MAIN", "1"),
        new ValueType("2:LOW", "2"), new ValueType("3:SSR", "3"),
        new ValueType("4:LTP", "4"),};

    static private final ValueType defaultValue = options[0];

    public Cfg_object() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }
}
