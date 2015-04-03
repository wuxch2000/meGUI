package gui.util.font;


import config.*;
import config.properties.*;
import gui.util.*;
import gui.util.dialog.*;
import gui.util.layout.*;
import log.*;
import sun.font.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static config.properties.DialogProperties.Key.*;

/**
 * User: 吴晓春
 * Date: 11-3-28
 * Time: 下午8:04
 */
public class FontChooserPanel extends JPanel {


    private final FontChooserComboBox fontChooserComboBox;

    public FontChooserPanel(final ModuleDialog dialog, String defaultFontName) {

        LayoutUtil.UsingGridBagLayout(this);

        int line = 0, column = 0;
        final int MAX_COLUMN = 3;

        fontChooserComboBox = new FontChooserComboBox();
        fontChooserComboBox.setPreviewFontSize((int) (new JLabel().getFont().getSize2D() * 1.5));
        if (defaultFontName != null) {
            fontChooserComboBox.setSelectedItem(defaultFontName);
        }


        GridBagConstraints c;
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.WEST;
        c.weighty = 0;
        c.gridwidth = MAX_COLUMN;
        add(fontChooserComboBox, c);

        line++;
        final String demoStr = "The quick brown fox jumps over the lazy dog. 1234567890.";

        final JTextPane textPane = new JTextPane();
        SizeUtil.sameSize(textPane, new Dimension(300, 100));
        textPane.setText(demoStr);
        textPane.setEditable(false);

        textPane.setFont(new java.awt.Font(fontChooserComboBox.getSelectedFontName(), java.awt.Font.PLAIN, 14));

        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.WEST;
        c.weighty = 1;
        c.gridwidth = MAX_COLUMN;
        add(textPane, c);


        fontChooserComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String fontName = fontChooserComboBox.getSelectedFontName();

                if (fontName == null) {
                    return;
                }
                Trace.debug("FontChooserPanel.actionPerformed():",
                    "selecting font:", fontName, " file name:",
                    SunFontManager.getInstance().getFileNameForFontName(fontName));
                Font preFont = textPane.getFont();
                if (!preFont.getFontName().equals(fontName)) {
                    Trace.debug("FontChooserPanel.actionPerformed():",
                        "setting font:", fontName);
                    textPane.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, 14));
                }
            }
        });

        line++;
        column = (MAX_COLUMN - 1) - 1;
        JButton buttonOK = new JButton(DialogProperties.instance().getString(OK));
        buttonOK.setFont(LocalConfig.instance().getLocalFontSize());
        buttonOK.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (dialog != null) {
                    dialog.close(ModuleDialog.ReturnValue.OK);
                }
            }
        });
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 1.0;
        add(buttonOK, c);

        column++;
        JButton buttonCancel = new JButton(DialogProperties.instance().getString(Cancel));
        buttonCancel.setFont(LocalConfig.instance().getLocalFontSize());
        buttonCancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (dialog != null) {
                    dialog.close(ModuleDialog.ReturnValue.Cancel);
                }
            }
        });
        c = LayoutUtil.buildConstraints(line, column);
        c.anchor = GridBagConstraints.EAST;
        add(buttonCancel, c);

        BorderUtil.addSpaceBorder(this, 10);
    }

    public String getSetectedFontName() {
        return fontChooserComboBox.getSelectedFontName();
    }
}
