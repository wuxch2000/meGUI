package gui.profile.right.video;

import config.properties.*;
import gui.profile.right.basetype.*;
import gui.profile.right.video.codec.*;
import gui.profile.right.video.others.*;

public class CfgVideo extends A_CfgItems {

    public CfgVideo() {
        super(1);

        final I_ConfigItem videoOthers = new CfgVideoOthers();
        super.addItem(videoOthers);

        final I_ConfigItem videoCodec = new CfgVideoCodec();
        super.addItem(videoCodec);

        layout();

    }

    @Override
    public String toString() {
        return DialogProperties.instance().getString(DialogProperties.Key.Video);
    }


}
