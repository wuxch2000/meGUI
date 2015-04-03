package gui.profile.right.video.codec.x264;

import gui.profile.right.basetype.*;
import gui.profile.right.video.codec.x264.bool_value.*;
import gui.profile.right.video.codec.x264.int_value.*;
import gui.profile.right.video.codec.x264.list_value.*;
import gui.util.*;

import static gui.profile.right.basetype.util.BasetypeStringUtil.*;

public class Cfg_x264 extends A_CfgItems {

    public Cfg_x264() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);

        initItems();

        layout();

        setBorder("Detail");
        BorderUtil.addSpaceBorder(getPanel());
    }

    private void initItems() {
        addItem(new Cfg_cabac());
        addItem(new Cfg_global_header());
        addItem(new Cfg_bitrate());
        addItem(new Cfg_level_idc());
        addItem(new Cfg_vbv_bufsize());
        addItem(new Cfg_vbv_maxrate());
        addItem(new Cfg_frameref());
        addItem(new Cfg_me());
        addItem(new Cfg_subq());
        addItem(new Cfg_threads());
        addItem(new Cfg_trellis());
    }

    @Override
    public String toString() {
        return "x264";
    }

    @Override
    public String toCmdLineArg() {
        StringBuilder builder = new StringBuilder();

        builder.append("-ovc x264 ");

        builder.append(buildSubOptions("-x264encopts", getAllItems()));

        return builder.toString();
    }

}
