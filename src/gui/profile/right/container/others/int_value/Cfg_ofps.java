package gui.profile.right.container.others.int_value;

import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_ofps extends A_SimpleCfgInt {

    private final static String label = "ofps";
    private final static String xmlPath = "/profile/container/" + label;
    private final static String tip = "output frames per second(fps)";
    private final static int defaultValue = 30;
    private final static int minValue = 1;
    private final static int maxValue = 100;

    public Cfg_ofps() {
        super(label, xmlPath,
            FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(SPACE),
            defaultValue, minValue, maxValue);
        super.setToolTip(tip);
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

}
