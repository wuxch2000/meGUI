package gui.profile.right.font;

import config.encode.*;
import config.properties.*;
import gui.*;
import gui.profile.right.basetype.*;
import gui.profile.right.basetype.defaultbehaviour.*;
import gui.profile.right.basetype.format.*;
import gui.swingworker.*;
import gui.util.*;
import gui.util.monitor.*;
import sun.font.*;
import xml.*;

import java.awt.event.*;

import static gui.profile.right.basetype.defaultbehaviour.FactoryDefaultBehaviour.Arg.*;
import static gui.profile.right.basetype.format.FactoryArgOutputFormat.Arg.*;


public class Cfg_subfont extends A_SimpleCfgString {

    private final static String label = "subfont";
    private final static String xmlPath = "/profile/font/" + label;
    private final static String tip = "sub font";

    static private final String defaultValue = "Arial";

    private final static String fontNamePath = xmlPath + "/name";
    private final static String fontFilePath = xmlPath + "/file";

    public Cfg_subfont() {
        super(label, xmlPath, FactoryDefaultBehaviour.build(OUTPUT),
            FactoryArgOutputFormat.build(SPACE), defaultValue);
        setToolTip(tip);

        getButton().addActionListener(new ButtonClick(this));
    }

    @Override
    protected boolean alwaysSaveToConfig() {
        return true;
    }

    @Override
    public void updateFromFile(final EncodeProfile file) {

        String fontName = file.getValueByPath(fontNamePath);
        setValue(fontName);
    }

    @Override
    public void updateToFile(final EncodeProfile file) {
        String oldFontName = file.getValueByPath(fontNamePath);
        if (oldFontName.equals("")) {
            oldFontName = defaultValue;
        }

        final String newFontname = getValue();

        if (!oldFontName.equals(newFontname)) {
            file.setValueByPath(fontNamePath, newFontname);

            final String newFontFile = SunFontManager.getInstance().getFileNameForFontName(newFontname);

            file.setValueByPath(fontFilePath, newFontFile);
        }

    }

    class ButtonClick implements ActionListener {
        private final Cfg_subfont outer;

        public ButtonClick(final Cfg_subfont outer) {
            this.outer = outer;
        }

        @Override
        public void actionPerformed(final ActionEvent e) {


            Monitor.instance().setBegin(
                DialogProperties.instance().
                    getString(DialogProperties.Key.InitialingFontChooserDialog));

            SwingWorkerGui worker =
                new SwingWorkerGui(new DoShowFontChooserDialog(MainFrame.instance(), getValue(), outer));
            worker.execute();


        }
    }

}
