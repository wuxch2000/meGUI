package gui.profile.right.audio.codec.twolame;

import gui.profile.right.basetype.*;
import gui.util.*;

public class Cfg_twolame extends A_CfgItems {

    public Cfg_twolame() {
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
        return "twolame";
    }


}
