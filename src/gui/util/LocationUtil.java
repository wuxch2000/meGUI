package gui.util;

import javax.swing.*;
import java.awt.*;

public final class LocationUtil {
	static public void setCenterOfScreen(Window window) {
		// Point p = new Point();
		// Toolkit kit = Toolkit.getDefaultToolkit();
		// Dimension screenSize = kit.getScreenSize();
		// p.setLocation((screenSize.width - window.getSize().width) / 2,
		// (screenSize.height - window.getSize().height) / 2);
		// window.setLocation(p);

		window.setLocationRelativeTo(null);
		return;
	}

    // 需要在dialog.pack之后执行
	static public void setCenterOfScreen(JDialog dialog) {
		Point p = new Point();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		p.setLocation((screenSize.width - dialog.getSize().width) / 2,
		(screenSize.height - dialog.getSize().height) / 2);
		dialog.setLocation(p);

	}

}
