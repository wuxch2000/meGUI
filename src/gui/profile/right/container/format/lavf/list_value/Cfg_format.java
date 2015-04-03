package gui.profile.right.container.format.lavf.list_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_format extends A_SimpleCfgList {

    private final static String label = "format";
    private final static String xmlPath = "/profile/container/codec/lavf/" + label;
    private final static String tip = "Override which container format to mux into";

    static private final ValueType[] options = {
        new ValueType("mpg:MPEG-1/2", "mpg"),
        new ValueType("asf:Advanced Streaming Format", "asf"),
        new ValueType("avi:Audio Video Interleave", "avi"),
        new ValueType("wav:Waveform Audio", "wav"),
        new ValueType("swf:Macromedia Flash", "swf"),
        new ValueType("flv:Macromedia Flash video files", "flv"),
        new ValueType("rm:RealAudio and RealVideo", "rm"),
        new ValueType("au:SUN AU format", "au"),
        new ValueType("nut:NUT open container format", "nut"),
        new ValueType("mov:QuickTime", "mov"),
        new ValueType("mp4:MPEG-4 format", "mp4"),
        new ValueType("ipod:Apple iPod firmware", "ipod"),
        new ValueType("dv:Sony Digital Video", "dv"),
        new ValueType("matroska:Matroska", "matroska")};

    static private final ValueType defaultValue = options[11];

    public Cfg_format() {
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
