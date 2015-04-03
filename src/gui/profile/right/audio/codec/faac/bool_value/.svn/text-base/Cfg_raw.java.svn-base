package gui.profile.right.audio.codec.faac.bool_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_raw extends A_SimpleCfgBool {

    private final static String label = "raw";
    private final static String xmlPath = "/profile/audio/codec/faac/" + label;
    private final static String tip = "Stores the bitstream as raw payload with extradata in the con- tainer header";
    private final static boolean defaultValue = false;

    public Cfg_raw() {
        super(label,
            xmlPath,
            FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(EQUAL),
            defaultValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
