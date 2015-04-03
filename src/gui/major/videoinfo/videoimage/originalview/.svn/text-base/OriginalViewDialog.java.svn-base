package gui.major.videoinfo.videoimage.originalview;

import convert.*;
import gui.*;
import gui.major.*;
import gui.util.*;

import javax.swing.*;

public class OriginalViewDialog extends JDialog implements I_Update{

	private static final String TITLE = "1x View";

    OriginalViewPanel originalViewPanel;

    public OriginalViewDialog() {
		super(MainFrame.instance(), true);
		super.setTitle(TITLE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

        originalViewPanel = new OriginalViewPanel();
        super.setContentPane(originalViewPanel);
        originalViewPanel.requestFocusInWindow();

    }

    @Override
    public void update(final VideoFile videoFile) {
        originalViewPanel.setImages(videoFile.getClip().getClipFiles());
        pack();
        LocationUtil.setCenterOfScreen(this);
    }
}
