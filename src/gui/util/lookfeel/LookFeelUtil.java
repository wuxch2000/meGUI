package gui.util.lookfeel;

import javax.swing.*;
import java.util.*;

/**
 * User: 吴晓春
 * Date: 11-4-19
 * Time: 下午4:22
 */
public class LookFeelUtil {
    private final static HashMap<LF_TYPE, String> lfMap;

    static {
        lfMap = new HashMap<LF_TYPE, String>();
        for (UIManager.LookAndFeelInfo lf : UIManager.getInstalledLookAndFeels()) {
            if (lf.getName().equals("Metal")) {
                lfMap.put(LF_TYPE.Metal, lf.getClassName());
            } else if (lf.getName().equals("Nimbus")) {
                lfMap.put(LF_TYPE.Nimbus, lf.getClassName());
            } else if (lf.getName().equals("Motif")) {
                lfMap.put(LF_TYPE.Motif, lf.getClassName());
            } else if (lf.getName().equals("Windows")) {
                lfMap.put(LF_TYPE.Windows, lf.getClassName());
            } else if (lf.getName().equals("Windows Classic")) {
                lfMap.put(LF_TYPE.WindowsClassic, lf.getClassName());
            }
        }
    }

    public enum LF_TYPE {
        Metal, Nimbus, Motif, Windows, WindowsClassic,
        System
    }

    static public void setLookAndFell(LF_TYPE lfType, JFrame frame) {
        setLookAndFell(lfType);
        SwingUtilities.updateComponentTreeUI(frame);
//        frame.pack();
    }

    static public void setLookAndFell(LF_TYPE lfType) {
        try {
            if (lfType == LookFeelUtil.LF_TYPE.System) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else {
                UIManager.setLookAndFeel(lfMap.get(lfType));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


}
