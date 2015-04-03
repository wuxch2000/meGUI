package gui.profile.right.font;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_subcp extends A_SimpleCfgList {

    private final static String label = "subcp";
    private final static String xmlPath = "/profile/font/" + label;
    private final static String tip = "code page";

    static private final ValueType[] options;

    static {
        options = new ValueType[]{new ValueType("cp936", "cp936")
           };
    }

    static private final ValueType defaultValue = options[0];

    public Cfg_subcp() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(SPACE), defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
