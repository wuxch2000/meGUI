package gui.profile.right.container.format.lavf;

import gui.profile.right.basetype.*;
import gui.profile.right.container.format.lavf.list_value.*;
import gui.util.*;

import static gui.profile.right.basetype.util.BasetypeStringUtil.*;

public class Cfg_lavf extends A_CfgItems {

    public Cfg_lavf() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);


        initItems();

        layout();

        setBorder("Detail");
        BorderUtil.addSpaceBorder(getPanel());
    }

    private void initItems() {
        addItem(new Cfg_format());
    }

    @Override
    public String toString() {
        return "lavf";
    }


    @Override
    public String toCmdLineArg() {
        StringBuilder builder = new StringBuilder();

        builder.append("-of lavf ");

        builder.append(buildSubOptions("-lavfopts", getAllItems()));

        return builder.toString();
    }

}
