package gui.profile.right.video.codec.lavc.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_vcodec extends A_SimpleCfgList {

    private final static String label = "vcodec";

    private final static String xmlPath = "/profile/video/codec/lavc/" + label;
    private final static String tip = "vcodec";

    static private final ValueType[] options = {
        new ValueType("mjpeg", "mjpeg"), new ValueType("h263", "h263"),
        new ValueType("h263p", "h263p"), new ValueType("mpeg4", "mpeg4"),
        new ValueType("msmpeg4", "msmpeg4"), new ValueType("rv10", "rv10"),
        new ValueType("mpeg1video", "mpeg1video")};

    static private final ValueType defaultValue = options[3];

    public Cfg_vcodec() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(NO_OUTPUT),
            FactoryArgOutputFormat.build(EQUAL), defaultValue, options);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return false;
    }
}
