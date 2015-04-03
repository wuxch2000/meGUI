package gui.util.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * User: 吴晓春
 * Date: 11-3-19
 * Time: 下午6:14
 */
public class ModuleDialog extends JDialog {

    @Override
    public void pack() {
        super.pack();
        setLocationRelativeTo(null);
    }

    public enum ReturnValue {
        Error,
        OK,
        Cancel
    }

    public ModuleDialog(final Frame frame, final String s) {
        super(frame, s);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setRetValue(final ReturnValue retValue) {
        this.retValue = retValue;
    }

    public ReturnValue getRetValue() {
        return retValue;
    }

    private ReturnValue retValue = ReturnValue.Error;

    static public ReturnValue showDialog(ModuleDialog dlg) {
        dlg.setVisible(true);
        return dlg.retValue;
    }

    public void close(ReturnValue returnValue) {
        setRetValue(returnValue);
        setVisible(false);
    }

}
