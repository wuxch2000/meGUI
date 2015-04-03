package gui.profile.right.video.codec.lavc;

import gui.profile.right.basetype.*;
import gui.profile.right.video.codec.lavc.bool_value.*;
import gui.profile.right.video.codec.lavc.int_value.*;
import gui.profile.right.video.codec.lavc.list_value.*;
import gui.util.*;

import static gui.profile.right.basetype.util.BasetypeStringUtil.*;

public class Cfg_lavc extends A_CfgItems {

    public Cfg_lavc() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);
        initItems();

        layout();

        setBorder("Detail");
        BorderUtil.addSpaceBorder(getPanel());

    }

    private void initItems() {

        addItem(new Cfg_vcodec());
        addItem(new Cfg_vqmin());
        addItem(new Cfg_vqscale());
        addItem(new Cfg_vqmax());
        addItem(new Cfg_mbqmin());
        addItem(new Cfg_mbqmax());
        addItem(new Cfg_vqdiff());
        addItem(new Cfg_vmax_b_frames());
        addItem(new Cfg_vme());
        addItem(new Cfg_vhq());
        addItem(new Cfg_v4mv());
        addItem(new Cfg_keyint());
        addItem(new Cfg_vb_strategy());
        addItem(new Cfg_vpass());
        addItem(new Cfg_aspect());
        addItem(new Cfg_vbitrate());
        addItem(new Cfg_vratetol());
    }

    @Override
    public String toString() {
        return "lavc";
    }


    @Override
    public String toCmdLineArg() {
        StringBuilder builder = new StringBuilder();

        builder.append("-ovc lavf ");

        builder.append(buildSubOptions("-lavfopts", getAllItems()));

        return builder.toString();
    }
}
