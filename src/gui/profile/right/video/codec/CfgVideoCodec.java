package gui.profile.right.video.codec;

import gui.profile.right.basetype.A_ComboxPanel;
import gui.profile.right.basetype.I_ConfigItem;
import gui.profile.right.video.codec.lavc.Cfg_lavc;
import gui.profile.right.video.codec.x264.Cfg_x264;

public class CfgVideoCodec extends A_ComboxPanel {

    static private I_ConfigItem[] build() {
        I_ConfigItem[] list = new I_ConfigItem[]{
                new Cfg_x264(),
                new Cfg_lavc(),
        };
        return list;
    }

    static private int defaultChoice = 0; // x264

    public CfgVideoCodec() {
        super(build(), defaultChoice);
    }


    @Override
    public String toString() {
        return "VideoCodec";
    }


}
