package gui.profile.right.video.codec.x264.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_threads extends A_SimpleCfgList {

    private final static String label = "threads";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "threads";

    static private final ValueType[] options = {
        new ValueType("auto", "auto"),
        new ValueType("1", "1"),
        new ValueType("2", "2"),
        new ValueType("3", "3"),
        new ValueType("4", "4"),
        new ValueType("5", "5"),
        new ValueType("6", "6"),
        new ValueType("7", "7"),
        new ValueType("8", "8"),
        new ValueType("9", "9"),
        new ValueType("10", "10"),
        new ValueType("11", "11"),
        new ValueType("12", "12"),
        new ValueType("13", "13"),
        new ValueType("14", "14"),
        new ValueType("15", "15"),
        new ValueType("16", "16")
    };

    static private final ValueType defaultValue = options[0];

    public Cfg_threads() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
