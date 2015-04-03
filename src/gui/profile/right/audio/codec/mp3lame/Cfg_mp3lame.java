package gui.profile.right.audio.codec.mp3lame;

import gui.profile.right.basetype.*;
import gui.util.*;

public class Cfg_mp3lame extends A_CfgItems {

    public Cfg_mp3lame() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);


        initItems();

        layout();

        setBorder("Detail");
        BorderUtil.addSpaceBorder(getPanel());
    }

    private void initItems() {

    }

    @Override
    public String toString() {
        return "mp3lame";
    }


}
