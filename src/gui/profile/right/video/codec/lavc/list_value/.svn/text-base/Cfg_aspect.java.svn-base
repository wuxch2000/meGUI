package gui.profile.right.video.codec.lavc.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_aspect extends A_SimpleCfgList {

    private final static String label = "aspect";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "Store movie aspect internally, just like MPEG files. Much nicer solution than " +
                                      "rescaling, because quality isn't decreased. Only Command will play these files" +
                                      " correctly, other players will display them with wrong aspect. The aspect " +
                                      "parameter can be given as a ratio or a floating point number.";

    static private final ValueType[] options = {new ValueType("16/9", "16/9"),
        new ValueType("4/3", "4/3")};

    static private final ValueType defaultValue = options[0];

    public Cfg_aspect() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }

}
