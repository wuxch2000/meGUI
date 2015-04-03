package gui.toolbar;

import config.properties.*;
import gui.major.table.*;

import javax.swing.*;
import java.util.*;

public class MainToolBar extends JToolBar {

    private HashSet<A_ProcessTableButton> buttons;

    public MainToolBar() {
//        setRollover(false);
//        setBorderPainted(false);

        buttons = new HashSet<>();

        add(new ToolBarProfile(),
            DialogProperties.instance().getString(DialogProperties.Key.EditProfile));

        add(new ToolBarEditConvert(),
            DialogProperties.instance().getString(DialogProperties.Key.editConvertOption));


        add(new ToolBarAdd(),
            DialogProperties.instance().getString(DialogProperties.Key.AddVideoFile));

        add(new ToolBarRemove(),
            DialogProperties.instance().getString(DialogProperties.Key.Remove));

        add(new ToolBarConvert(),
            DialogProperties.instance().getString(DialogProperties.Key.Convert));

        add(new ToolBarStop(),
            DialogProperties.instance().getString(DialogProperties.Key.StopConvert));

        add(new ToolBarUp(),
            DialogProperties.instance().getString(DialogProperties.Key.Up));

        add(new ToolBarDown(),
            DialogProperties.instance().getString(DialogProperties.Key.Down));

        add(new ToolBarBrowseLog(),
            DialogProperties.instance().getString(DialogProperties.Key.BrowseLog));

        updateButtonEnable();
    }

//    @Override
//    protected void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);
//
//        Dimension size = getSize();
//
//        Graphics2D g2 = (Graphics2D) graphics;
//
//        g2.setPaint(GradUtil.buildGrad(this));
//
//        g2.fill(new Rectangle(size));
//
//    }


//	abstract protected void init();

    protected void add(A_ProcessTableButton button, String tip) {
        add(button);

        button.setToolTipText(tip);

        buttons.add(button);
    }

    public void setEnable(JButton button, boolean enable) {
        boolean oldEnable = button.isEnabled();
        if (oldEnable != enable) {
            button.setEnabled(enable);
            repaint();
        }
    }

    public void updateButtonEnable() {
        updateButtonEnable(null);
    }

    public void updateButtonEnable(ProcessTable table) {
        for (A_ProcessTableButton button : buttons) {
            setEnable(button,button.getNewButtonEnable(table));
        }
    }

}
