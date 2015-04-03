package gui.profile.right.container;

import config.properties.*;
import gui.profile.right.basetype.*;
import gui.profile.right.container.format.*;
import gui.profile.right.container.others.*;

public class CfgContainer extends A_CfgItems {

    public CfgContainer() {
        super(1);

        I_ConfigItem containerOthers = new CfgContainerOthers();
        addItem(containerOthers);

        I_ConfigItem containerFormat = new CfgContainerFormat();
        addItem(containerFormat);

        layout();

    }

    @Override
    public String toString() {
        return DialogProperties.instance().getString(DialogProperties.Key.Container);
    }


}
