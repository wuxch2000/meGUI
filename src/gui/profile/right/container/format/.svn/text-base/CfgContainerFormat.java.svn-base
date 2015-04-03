package gui.profile.right.container.format;

import gui.profile.right.basetype.A_ComboxPanel;
import gui.profile.right.basetype.I_ConfigItem;
import gui.profile.right.container.format.lavf.Cfg_lavf;

public class CfgContainerFormat extends A_ComboxPanel {

    static private I_ConfigItem[] build() {
        return new I_ConfigItem[]{
                new Cfg_avi(),
                new Cfg_lavf(),
                new Cfg_mpeg(),
                new Cfg_rawaudio(),
                new Cfg_rawvideo()
        };
    }

    static private int defaultChoice = 1; // lavf

    public CfgContainerFormat() {
        super(build(), defaultChoice);
    }

    @Override
    public String toString() {
        return "Container";
    }


}
