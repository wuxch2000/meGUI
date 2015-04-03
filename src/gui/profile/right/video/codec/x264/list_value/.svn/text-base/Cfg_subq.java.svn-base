package gui.profile.right.video.codec.x264.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_subq extends A_SimpleCfgList {

    private final static String label = "subq";

    private final static String xmlPath = "/profile/video/codec/x264/" + label;
    private final static String tip = "Adjust subpel refinement quality";

    static private final ValueType[] options = {
        new ValueType("0", "0"),
        new ValueType("1", "1"),
        new ValueType("2", "2"),
        new ValueType("3", "3"),
        new ValueType("4", "4"),
        new ValueType("5", "5"),
        new ValueType("6", "6"),
        new ValueType("7", "7"),
        new ValueType("8", "8"),
        new ValueType("9", "9")
    };

    static private final ValueType defaultValue = options[3];

    public Cfg_subq() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT), FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
