package gui.profile.right.audio.others;

import gui.profile.right.audio.others.int_value.*;
import gui.profile.right.audio.others.list_value.*;
import gui.profile.right.basetype.*;

public class CfgAudioOthers extends A_CfgItems {

    public CfgAudioOthers() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);

        initItems();
        layout();

    }

    private void initItems() {
        addItem(new Cfg_channels());
        addItem(new Cfg_srate());
    }
}
