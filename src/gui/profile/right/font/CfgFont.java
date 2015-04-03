package gui.profile.right.font;

import config.properties.*;
import gui.profile.right.basetype.*;

public class CfgFont extends A_CfgItems {

    public CfgFont() {
        super(1);

        I_ConfigItem subcp = new Cfg_subcp();
        super.addItem(subcp);

        I_ConfigItem subfont = new Cfg_subfont();
        super.addItem(subfont);

        layout();
    }

    @Override
    public String toString() {
        return DialogProperties.instance().getString(DialogProperties.Key.Font);
    }

}
