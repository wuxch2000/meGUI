package gui.profile.right.video.others.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_scale extends A_SimpleCfgList {

    private final static String label = "scale";

    private final static String xmlPath = "/profile/video/" + label;
    private final static String tip = "scale";

    static private final ValueType[] options = {
            new ValueType("-10:240,harddup", "-10:240,harddup"),
            new ValueType("-10:480,harddup", "-10:480,harddup"),
            new ValueType("-10:640,harddup", "-10:640,harddup")
    };

    static private final ValueType defaultValue = options[0];

    public Cfg_scale() {
        super(label, xmlPath,
                FactoryDefaultBehaviour.build(OUTPUT),
                FactoryArgOutputFormat.build(SPACE),
                defaultValue, options);
        setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
