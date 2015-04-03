package gui.swingworker;

import gui.profile.right.font.*;
import gui.util.font.*;
import gui.util.monitor.*;

import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-6-1
 * Time: 下午3:26
 */
public class DoShowFontChooserDialog implements NeedUsingSwingWorker {
    private final Frame frame;
    private final String defaultFontname;
    private FontChooserDialog dlg;
    private final Cfg_subfont cfg_subfont;

    public DoShowFontChooserDialog(final Frame frame, final String defaultFontname, final Cfg_subfont cfg_subfont) {
        this.defaultFontname = defaultFontname;
        this.frame = frame;
        this.cfg_subfont = cfg_subfont;
    }

    @Override
    public void done() throws Exception {
        Monitor.instance().setDone();
        if (FontChooserDialog.showDialog(dlg) == FontChooserDialog.ReturnValue.OK &&
            cfg_subfont != null) {
            cfg_subfont.setValue(dlg.getSelectedFontName());
        }

    }

    @Override
    public void doInBackground() throws Exception {
        dlg = new FontChooserDialog(frame, defaultFontname);
    }
}
