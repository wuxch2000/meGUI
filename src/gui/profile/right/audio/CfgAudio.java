package gui.profile.right.audio;

import config.properties.*;
import gui.profile.right.audio.codec.*;
import gui.profile.right.audio.others.*;
import gui.profile.right.basetype.*;

public class CfgAudio extends A_CfgItems {

    public CfgAudio() {
        super(1);

        I_ConfigItem audioOthers = new CfgAudioOthers();
        addItem(audioOthers);

        I_ConfigItem audioCodec = new CfgAudioCodec();
        addItem(audioCodec);

        layout();
    }

    @Override
    public String toString() {
        return DialogProperties.instance().getString(DialogProperties.Key.Audio);
    }

}
