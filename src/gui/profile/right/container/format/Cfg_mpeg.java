package gui.profile.right.container.format;

import gui.profile.right.basetype.*;
import gui.util.*;

public class Cfg_mpeg extends A_CfgItems {

    public Cfg_mpeg() {
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
        return "mpeg";
    }



}
