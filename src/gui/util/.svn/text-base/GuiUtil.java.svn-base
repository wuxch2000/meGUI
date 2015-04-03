package gui.util;

import log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: 吴晓春
 */
public class GuiUtil {
    static private final String Nimbus = "Nimbus";

    private static void usingNimbus() {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            // UIManager.setLookAndFeel(UIManager
            // .getCrossPlatformLookAndFeelClassName());

            UIManager.LookAndFeelInfo[] allLookFeel = UIManager
                .getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo laf : allLookFeel) {
                if (Nimbus.equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                    break;
                }
            }

        } catch (Exception e) {
            Trace.error(e);
        }
    }

    public static class MyFrame extends JFrame implements WindowListener {
        private Runnable runnable;

        public MyFrame(final String s, final Runnable runnable) throws HeadlessException {
            super(s);
            this.runnable = runnable;
            this.addWindowListener(this);
        }

        @Override
        public void windowOpened(final WindowEvent windowEvent) {
        }

        @Override
        public void windowClosing(final WindowEvent windowEvent) {
            Trace.debug("Windows closing...");
            if (runnable != null) {
                runnable.run();
            }

        }

        @Override
        public void windowClosed(final WindowEvent windowEvent) {
        }

        @Override
        public void windowIconified(final WindowEvent windowEvent) {
        }

        @Override
        public void windowDeiconified(final WindowEvent windowEvent) {
        }

        @Override
        public void windowActivated(final WindowEvent windowEvent) {

        }

        @Override
        public void windowDeactivated(final WindowEvent windowEvent) {
        }
    }

    public static JFrame frame;

    public static void createAndShowGUI(String title, JComponent panel, Runnable execWhenQuit) {
//        GuiUtil.usingNimbus();
        try {
            // 1. Create the frame.
            frame = new MyFrame(title, execWhenQuit);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 2. Add Panel
            frame.getContentPane().

                add(panel,
                    BorderLayout.CENTER);

            // 3. Set size and position
            frame.pack();
            LocationUtil.setCenterOfScreen(frame);

            // 4. display
            frame.setVisible(true);

        } catch (Exception e) {
            Trace.error(e);
        }
    }

    public static void createAndShowGUI(String title, JComponent panel) {
        createAndShowGUI(title, panel, null);
    }


}
