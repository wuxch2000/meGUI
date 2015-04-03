package gui.profile.right.container.others;

import gui.profile.right.basetype.*;
import gui.profile.right.container.others.int_value.*;

public class CfgContainerOthers extends A_CfgItems {

    public CfgContainerOthers() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);

        initItems();

        layout();

    }

    private void initItems() {
        addItem(new Cfg_ofps());
    }
}
