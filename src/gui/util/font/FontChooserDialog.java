package gui.util.font;

import config.properties.*;
import gui.util.dialog.*;

import java.awt.*;

import static config.properties.DialogProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-3-28
 * Time: 下午7:50
 */
public class FontChooserDialog extends ModuleDialog {

    private final FontChooserPanel fontChooserPanel;

    public FontChooserDialog(final Frame frame, final String defaultFontname) {
        super(frame, DialogProperties.instance().getString(FontChooser));

        fontChooserPanel = new FontChooserPanel(this, defaultFontname);

        this.setContentPane(fontChooserPanel);
        this.pack();

    }

    public String getSelectedFontName() {
        return fontChooserPanel.getSetectedFontName();
    }

}
