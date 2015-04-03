package gui;

import gui.util.lookfeel.*;
import gui.util.os.*;
import log.*;

import javax.swing.*;

public class GuiMain {
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		try {
            LookFeelUtil.setLookAndFell(LookFeelUtil.LF_TYPE.Nimbus);
            // 1. Create the frame.
			MainFrame frame = MainFrame.instance();

			// 2. Optional: What happens when the frame closes?
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// 3. Create components and put them in the frame.
			// ...create emptyLabel...
			// frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

			// 4. Size the frame.
			// frame.pack();

			frame.setLocationRelativeTo(null);
			// 5. show it.
			frame.setVisible(true);

		} catch (Exception e) {
            Trace.error(e);
		}

	}

	public static void main(String[] args) throws Exception {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
                OsTask.instance();
				createAndShowGUI();
			}
		});
	}


}
