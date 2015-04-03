package gui.profile.right.video.codec.lavc.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vme extends A_SimpleCfgList {

    private final static String label = "vme";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "motion estimation method";

    static private final ValueType[] options = {
        new ValueType("0:none(very lq)", "0"),
        new ValueType("1:full(slow)", "1"),
        new ValueType("2:log(lq)", "2"), new ValueType("3:phods(lq)", "3"),
        new ValueType("4:EPZS(default)", "4"),
        new ValueType("5:X1(experimental)", "5")};

    static private final ValueType defaultValue = options[3];

    public Cfg_vme() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);

    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }
}
