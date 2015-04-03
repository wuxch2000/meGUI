package gui.util.dialog;

import config.LocalConfig;
import config.properties.DialogProperties;
import config.properties.VideoFileFieldProperties;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 12-3-3
 * Time: 下午10:38
 */
public class OptionPaneDialog extends JOptionPane {

    static private DialogProperties _dialogProperties = null;

    static private DialogProperties getDialogProperties() {
        if (_dialogProperties != null)
            return _dialogProperties;
        _dialogProperties = DialogProperties.instance();

        Font font = LocalConfig.instance().getLocalFont();
        UIManager.put("OptionPane.font", font);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);

        UIManager.put("FileChooser.font", font);
        UIManager.put("ToolTip.font", font);

        UIManager.put("OptionPane.cancelButtonText",
                _dialogProperties.getString(DialogProperties.Key.Cancel));
        UIManager.put("OptionPane.noButtonText",
                _dialogProperties.getString(DialogProperties.Key.No));
        UIManager.put("OptionPane.okButtonText",
                _dialogProperties.getString(DialogProperties.Key.OK));
        UIManager.put("OptionPane.yesButtonText",
                _dialogProperties.getString(DialogProperties.Key.Yes));

        return _dialogProperties;
    }

    public static int showOptionDialogOkCancel(Component parentComponent,
                                               VideoFileFieldProperties.Key message, DialogProperties.Key title, int optionType, int messageType,
                                               Icon icon) {
        Object[] options = {DialogProperties.instance().getString(DialogProperties.Key.OK),
                DialogProperties.instance().getString(DialogProperties.Key.Cancel)};

        return JOptionPane.showOptionDialog(parentComponent,
                VideoFileFieldProperties.instance().getString(message),
                getDialogProperties().getString(title),
                optionType,
                messageType,
                icon,
                options,
                options[0]);

    }


    public static int showOptionDialogOkCancel(Component parentComponent,
                                               DialogProperties.Key message, DialogProperties.Key title, int optionType, int messageType,
                                               Icon icon) {
        Object[] options = {DialogProperties.instance().getString(DialogProperties.Key.OK),
                DialogProperties.instance().getString(DialogProperties.Key.Cancel)};

        return JOptionPane.showOptionDialog(parentComponent,
                getDialogProperties().getString(message),
                getDialogProperties().getString(title),
                optionType,
                messageType,
                icon,
                options,
                options[0]);

    }


    public static int showConfirmDialog(Component parentComponent,
                                        DialogProperties.Key message, DialogProperties.Key title, int optionType) {
        return JOptionPane.showConfirmDialog(parentComponent,
                getDialogProperties().getString(message),
                getDialogProperties().getString(title),
                optionType);
    }

    static public void showMessageDialogEx(JFrame frame, DialogProperties.Key message,
                                           DialogProperties.Key title,
                                           String ext) {
        JOptionPane.showMessageDialog(frame,
                getDialogProperties().getString(message, ext),
                getDialogProperties().getString(title),
                JOptionPane.INFORMATION_MESSAGE);
    }


    static public int showWarningDialog(JFrame frame, DialogProperties.Key key) {
        String title = getDialogProperties().getString(DialogProperties.Key.Warning);
        String prompt = getDialogProperties().getString(key);

        return JOptionPane.showConfirmDialog(frame,
                prompt,
                title,
                JOptionPane.YES_NO_OPTION);
    }

    static public int showWarningDialog(JFrame frame, DialogProperties.Key key,
                                        String addstr) {
        String title = getDialogProperties().getString(DialogProperties.Key.Warning);
        String prompt = getDialogProperties().getString(key, addstr);

        return JOptionPane.showConfirmDialog(frame,
                prompt,
                title,
                JOptionPane.YES_NO_OPTION);

    }

    static public void showErrorDialog(JFrame frame, DialogProperties.Key key,
                                       String addstr) {
        String title = getDialogProperties().getString(DialogProperties.Key.Error);
        String prompt = getDialogProperties().getString(key, addstr);

        Object[] options = new Object[1];
        options[0] = DialogProperties.instance().getString(DialogProperties.Key.OK);
        JOptionPane.showOptionDialog(frame,
                prompt,
                title,
                JOptionPane.YES_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title

    }
}
