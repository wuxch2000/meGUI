package gui.profile.right.audio.codec;

import gui.profile.right.basetype.A_ComboxPanel;
import gui.profile.right.basetype.I_ConfigItem;
import gui.profile.right.audio.codec.copy.Cfg_copy;
import gui.profile.right.audio.codec.faac.Cfg_faac;
import gui.profile.right.audio.codec.lavc.Cfg_lavc;
import gui.profile.right.audio.codec.mp3lame.Cfg_mp3lame;
import gui.profile.right.audio.codec.pcm.Cfg_pcm;
import gui.profile.right.audio.codec.twolame.Cfg_twolame;

public class CfgAudioCodec extends A_ComboxPanel {

    static private I_ConfigItem[] build() {
        I_ConfigItem[] list = new I_ConfigItem[]{
                new Cfg_mp3lame(),
                new Cfg_pcm(),
                new Cfg_copy(),
                new Cfg_faac(),
                new Cfg_lavc(),
                new Cfg_twolame()
        };
        return list;
    }

    static private int defaultChoice = 3; // faac

    public CfgAudioCodec() {
        super(build(), defaultChoice);
    }

    @Override
    public String toString() {
        return "AudioCodec";
    }


}
