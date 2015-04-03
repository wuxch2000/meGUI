package gui.profile.right.audio.others.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_channels extends A_SimpleCfgList {

    private final static String label = "channels";
    private final static String xmlPath = "/profile/audio/" + label;
    private final static String tip = "channels";

    static private final ValueType[] options;

    static {
        options = new ValueType[]{new ValueType("2:stereo", "2"),
            new ValueType("4:surround", "4"), new ValueType("6:full 5.1", "6")};
    }

    static private final ValueType defaultValue = options[0];

    public Cfg_channels() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(SPACE), defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
