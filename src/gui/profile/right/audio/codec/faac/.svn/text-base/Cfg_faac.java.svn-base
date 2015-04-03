package gui.profile.right.audio.codec.faac;

import gui.profile.right.audio.codec.faac.bool_value.*;
import gui.profile.right.audio.codec.faac.int_value.*;
import gui.profile.right.audio.codec.faac.list_value.*;
import gui.profile.right.basetype.*;
import gui.util.*;

import static gui.profile.right.basetype.util.BasetypeStringUtil.*;

/**
 * 产生诸如-oac faac -faacopts br=192:mpeg=4:object=2 -channels 2 -srate 48000配置
 */
public class Cfg_faac extends A_CfgItems {

    public Cfg_faac() {
        super(A_CfgItems.MAX_ITEM_IN_ROW);

        initItems();

        layout();

        setBorder("Detail");
        BorderUtil.addSpaceBorder(getPanel());
    }

    private void initItems() {
        addItem(new Cfg_mpeg());
        addItem(new Cfg_object());
        addItem(new Cfg_br());
        addItem(new Cfg_raw());
    }

    @Override
    public String toString() {
        return "faac";
    }


    @Override
    public String toCmdLineArg() {
        StringBuilder builder = new StringBuilder();

        builder.append("-oac faac ");

        builder.append(buildSubOptions("-faacopts", getAllItems()));

        return builder.toString();
    }


}
